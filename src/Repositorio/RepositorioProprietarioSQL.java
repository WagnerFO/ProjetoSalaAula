package Repositorio;

import java.sql.*;
import java.util.ArrayList;

import Entity.Proprietario;
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
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1,proprietario.getNome());
			stmt.setInt(2,proprietario.getIdade());
			stmt.setString(3,proprietario.getCpf());
			stmt.setString(4,proprietario.getTelefoneContato());
			stmt.setString(5,proprietario.getEndereco());
			stmt.executeUpdate();
		}
	}



	public void alterarProprietario(Proprietario proprietario, String cpfOriginal) throws SQLException {
		String sql = "UPDATE proprietarios SET cpf = ?, nome = ?, idade = ?, telefoneContato = ?, endereco = ? WHERE cpf = ?";
		try (PreparedStatement stmt = connection.prepareStatement(sql)) {
			// Define os valores que serão atualizados
			stmt.setString(1, proprietario.getCpf()); // Novo CPF
			stmt.setString(2, proprietario.getNome());
			stmt.setInt(3, proprietario.getIdade());
			stmt.setString(4, proprietario.getTelefoneContato());
			stmt.setString(5, proprietario.getEndereco());
			
			// Define o CPF original no WHERE para encontrar o proprietário correto
			stmt.setString(6, cpfOriginal);

			stmt.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	

	@Override
	public Proprietario listarProp(int id) throws SQLException{
		String sql = "SELECT * FROM proprietarios WHERE id = ?";
		Proprietario proprietario = null;
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery();
			if(rs.next()){
				proprietario = new Proprietario(
					rs.getString("nome"),
					rs.getInt("idade"),
					rs.getString("cpf"),
					rs.getString("telefoneContato"),
					rs.getString("endereco"));
			}
		}
		return proprietario;
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


	/* 
	public void cadastrarProp(Proprietario proprietario) throws SQLException {
	    String sql = "INSERT INTO proprietario (nome, idade, cpf, telefoneContato, endereco) VALUES (?, ?, ?, ?, ?)";
	    
	    try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        ps.setString(1, proprietario.getNome());
	        ps.setInt(2, proprietario.getIdade());
	        ps.setString(3, proprietario.getCpf());
	        ps.setString(4, proprietario.getTelefoneContato());
	        ps.setString(5, proprietario.getEndereco());
	        
	        int retorno = ps.executeUpdate();
	        if (retorno == 0) {
	            throw new SQLException("Persistência do proprietário falhou, ID do proprietário não foi gerado.");
	        }

	        // Recuperar a chave gerada (idProprietario)
	        try (ResultSet generatedKeys = ps.getGeneratedKeys()) {
	            if (generatedKeys.next()) {
	                long idProprietarioGerado = generatedKeys.getLong(1);
	                System.out.println("Proprietário salvo com sucesso. ID gerado: " + idProprietarioGerado);
	            } else {
	                throw new SQLException("Persistência do proprietário falhou, ID do proprietário não foi gerado.");
	            }
	        }
	    } catch (SQLException e2) {
	        System.out.printf("Erro: %s", e2.getMessage());
	        throw new SQLException("Persistência do proprietário falhou.");
	    }
	}*/

	
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
