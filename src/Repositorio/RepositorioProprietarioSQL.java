package Repositorio;

import java.sql.*;
import java.util.ArrayList;

import Entity.*;
import IRepositorio.IRepositorioProprietarioSQL;
import Util.ConnectionFactory;
import Util.ConnectionSingleton;


public class RepositorioProprietarioSQL implements IRepositorioProprietarioSQL{
	
	private Connection connection;

	public RepositorioProprietarioSQL() {
		try {
			this.connection = ConnectionSingleton.getInstance().conexao;
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	@Override
	public void cadastrarProp(Proprietario proprietario) throws SQLException {
	    String sql = "INSERT INTO proprietarios (nome, idade, cpf, telefoneContato, endereco) VALUES (?, ?, ?, ?, ?)";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, proprietario.getNome());
	        stmt.setInt(2, proprietario.getIdade());
	        stmt.setString(3, proprietario.getCpf());
	        stmt.setString(4, proprietario.getTelefoneContato());
	        stmt.setString(5, proprietario.getEndereco());
	        stmt.executeUpdate();
	        
	        // Para cada veículo do proprietário, verificar a placa e salvar na tabela de vendas
	        for (Veiculo veiculo : proprietario.getVeiculos()) {
	            String placa = veiculo.getPlaca();
	            
	            // Validação: verificar se a placa não excede 7 caracteres
	            if (placa.length() > 7) {
	                System.out.println("Erro: a placa " + placa + " excede o limite de 7 caracteres.");
	                // Você pode lançar uma exceção ou tomar outra ação, dependendo da sua lógica de erro
	                throw new IllegalArgumentException("Placa " + placa + " é inválida, deve ter no máximo 7 caracteres.");
	            } else {
	                // Se a placa for válida, identificar o tipo do veículo e salvar
	                String tipoVeiculo = identificarTipoVeiculo(veiculo);
	                salvarVeiculo(proprietario.getCpf(), veiculo, tipoVeiculo);
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao cadastrar proprietário: " + e.getMessage());
	        throw e; // Re-lança a exceção para que ela seja tratada em outro lugar, se necessário
	    }
	}

	public void salvarVeiculo(String cpfProprietario, Veiculo veiculo, String tipoVeiculo) throws SQLException {
	    String sql = "INSERT INTO venda_veiculo (proprietario_cpf, veiculo_placa, veiculo_tipo) VALUES (?, ?, ?)";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, cpfProprietario);
	        stmt.setString(2, veiculo.getPlaca());
	        stmt.setString(3, tipoVeiculo); // Define o tipo do veículo (CARRO, MOTO, CAMINHAO)
	        stmt.executeUpdate();
	    }
	}

	// Método para identificar o tipo de veículo
	public String identificarTipoVeiculo(Veiculo veiculo) {
	    if (veiculo instanceof Carro) {
	        return "CARRO";
	    } else if (veiculo instanceof Moto) {
	        return "MOTO";
	    } else if (veiculo instanceof Caminhao) {
	        return "CAMINHAO";
	    }
	    throw new IllegalArgumentException("Tipo de veículo desconhecido.");
	}
	
	public void alterarProprietario(Proprietario proprietario) throws SQLException {
	    String sql = "UPDATE proprietarios SET nome = ?, idade = ?, telefoneContato = ?, endereco = ? WHERE cpf = ?";
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, proprietario.getNome());
	        stmt.setInt(2, proprietario.getIdade());
	        stmt.setString(3, proprietario.getTelefoneContato());
	        stmt.setString(4, proprietario.getEndereco());
	        stmt.setString(5, proprietario.getCpf()); // Use 'cpf' corretamente aqui

	        stmt.executeUpdate();

	        // Lógica adicional para gerenciar veículos do proprietário
	        removerVeiculos(proprietario.getCpf());

	        for (Veiculo veiculo : proprietario.getVeiculos()) {
	            String placa = veiculo.getPlaca();

	            if (placa.length() > 7) {
	                System.out.println("Erro: a placa " + placa + " excede o limite de 7 caracteres.");
	                throw new IllegalArgumentException("Placa " + placa + " é inválida, deve ter no máximo 7 caracteres.");
	            } else {
	                String tipoVeiculo = identificarTipoVeiculo(veiculo);
	                salvarVeiculo(proprietario.getCpf(), veiculo, tipoVeiculo);
	            }
	        }
	    } catch (SQLException e) {
	        System.out.println("Erro ao alterar proprietário: " + e.getMessage());
	        throw e; // Re-lança a exceção
	    }
	}

	@Override
	public void removerVeiculos(String cpfProprietario) throws SQLException{
		String sql = "DELETE FROM venda_veiculo WHERE cpfProprietario = ?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, cpfProprietario);
			stmt.executeUpdate();
		}
	}
	

	@Override
	public ArrayList<Proprietario> listarTodosProprietario() throws SQLException{
		String sql = "SELECT * FROM proprietarios";
		ArrayList<Proprietario>  proprietarios = new ArrayList<>();
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			ResultSet rs = stmt.executeQuery();
			while(rs.next()) {
				Proprietario proprietario = new Proprietario(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getInt("idade"),
						rs.getString("cpf"),
						rs.getString("telefoneContato"),
						rs.getString("endereco"));
				proprietario.setVeiculos(listarVeiculos(rs.getString("cpf")));
				proprietarios.add(proprietario);
			}
		}
		return proprietarios;
	}
	
	private ArrayList<Veiculo> listarVeiculos(String cpfProprietario) throws SQLException {
	    String sql = "SELECT * FROM venda_veiculo WHERE proprietario_cpf = ?";
	    ArrayList<Veiculo> veiculos = new ArrayList<>();
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, cpfProprietario);
	        ResultSet rs = stmt.executeQuery();
	        while (rs.next()) {
	            Veiculo veiculo = null;
	            String tipoVeiculo = rs.getString("veiculo_tipo"); // Campo que indica o tipo de veículo

	            // Usar o tipo de veículo para determinar em qual tabela buscar os detalhes
	            if ("CARRO".equals(tipoVeiculo)) {
	                // Consultar a tabela de carros
	                veiculo = listarCarro(rs.getString("veiculo_placa"));
	            } else if ("MOTO".equals(tipoVeiculo)) {
	                // Consultar a tabela de motos
	                veiculo = listarMoto(rs.getString("veiculo_placa"));
	            } else if ("CAMINHAO".equals(tipoVeiculo)) {
	                // Consultar a tabela de caminhões
	                veiculo = listarCaminhao(rs.getString("veiculo_placa"));
	            }

	            if (veiculo != null) {
	                veiculos.add(veiculo);
	            }
	        }
	    }
	    return veiculos;
	}
	
	private Carro listarCarro(String placa) throws SQLException {
	    String sql = "SELECT * FROM carros WHERE placa = ?";
	    Carro carro = null;
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, placa);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            carro = new Carro();
	            carro.setPlaca(rs.getString("placa"));
	            carro.setMarca(rs.getString("marca"));
	            carro.setModelo(rs.getString("modelo"));
	            carro.setCor(rs.getString("cor"));
	            carro.setAno(rs.getInt("ano"));
	            carro.setValorVenda(rs.getDouble("valorVenda"));
	        }
	    }
	    return carro;
	}

	private Moto listarMoto(String placa) throws SQLException {
	    String sql = "SELECT * FROM motos WHERE placa = ?";
	    Moto moto = null;
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, placa);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            moto = new Moto();
	            moto.setPlaca(rs.getString("placa"));
	            moto.setMarca(rs.getString("marca"));
	            moto.setModelo(rs.getString("modelo"));
	            moto.setCor(rs.getString("cor"));
	            moto.setAno(rs.getInt("ano"));
	            moto.setValorVenda(rs.getDouble("valorVenda"));
	        }
	    }
	    return moto;
	}

	
	private Caminhao listarCaminhao(String placa) throws SQLException {
	    String sql = "SELECT * FROM caminhoes WHERE placa = ?";
	    Caminhao caminhao = null;
	    try (PreparedStatement stmt = connection.prepareStatement(sql)) {
	        stmt.setString(1, placa);
	        ResultSet rs = stmt.executeQuery();
	        if (rs.next()) {
	            caminhao = new Caminhao();
	            caminhao.setPlaca(rs.getString("placa"));
	            caminhao.setMarca(rs.getString("marca"));
	            caminhao.setModelo(rs.getString("modelo"));
	            caminhao.setCor(rs.getString("cor"));
	            caminhao.setAno(rs.getInt("ano"));
	            caminhao.setValorVenda(rs.getDouble("valorVenda"));
	        }
	    }
	    return caminhao;
	}

	@Override
	public Proprietario pesquisarProprietarios(String cpf) {
		String sql = "SELECT * FROM proprietarios WHERE cpf = ?";
		Proprietario proprietario = null;
			
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			stmt.setString(1, cpf);
			ResultSet rs = stmt.executeQuery();
			
			if (rs.next()) {
				proprietario = new Proprietario();
				proprietario.setId(rs.getInt("id"));
				proprietario.setNome(rs.getString("nome"));
				proprietario.setIdade(rs.getInt("idade"));
				proprietario.setCpf(rs.getString("cpf"));
				proprietario.setTelefoneContato(rs.getString("telefoneContato"));
				proprietario.setEndereco(rs.getString("endereco"));
			} 
		} catch (SQLException e) {
			System.out.println("Erro ao pesquisar proprietário: " + e.getMessage());
			e.printStackTrace();
		}
		return proprietario;
	}

	public ArrayList<Proprietario> listarTodos() throws SQLException{
		String sql = "SELECT * FROM proprietarios";
		ArrayList<Proprietario> proprietarios = new ArrayList<>();
		try (PreparedStatement stmt = connection.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery()){
			while (rs.next()) {
				Proprietario proprietario = new Proprietario(
						rs.getInt("id"),
						rs.getString("nome"),
						rs.getInt("idade"),
						rs.getString("cpf"),
						rs.getString("telefoneContato"),
						rs.getString("endereco"));
				proprietarios.add(proprietario);
				}
			}
		return proprietarios;
	}

	@Override
	public void excluirProp(Proprietario proprietario){
		String sql = "DELETE FROM proprietarios WHERE cpf =?";
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, proprietario.getCpf());
			stmt.executeUpdate();
		} catch(SQLException e){
			e.printStackTrace();
		}
	}

	
	@Override
	public void adicionarProprietario(Proprietario proprietario) throws SQLException {
		String sql = "INSERT INTO proprietarios( nome, idade, cpf, telefoneContato, endereco) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps=ConnectionFactory.createConnection().prepareStatement(sql);
			ps.setString(1,proprietario.getNome());
			ps.setInt(2,proprietario.getIdade());
			ps.setString(3,proprietario.getCpf());
			ps.setString(4,proprietario.getTelefoneContato());
			ps.setString(5,proprietario.getEndereco());
			
			ps.execute();
			ps.close();
			
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
	}
	
}
