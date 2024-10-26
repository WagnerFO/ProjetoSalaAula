package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


import Entidades.Proprietario;
import IRepositorio.IRepositorioProprietarioSQL;
import Util.Conexao;
import Util.ConnectionSingleton;

public class RepositorioProprietarioSQL implements IRepositorioProprietarioSQL{
	
	private Connection conn;
	public RepositorioProprietarioSQL() {
		try {
			this.conn = this.conn = ConnectionSingleton.getInstance().conexao;
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
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
	}

	
	@Override
	public void adicionarProprietario(Proprietario proprietario) throws SQLException {
		String sql = "INSERT INTO proprietarios( nome, idade, cpf, telefoneContato, endereco) VALUES(?, ?, ?, ?, ?)";
		PreparedStatement ps = null;
		
		try {
			ps=Conexao.createConnection().prepareStatement(sql);
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

	@Override
	public void alterarProprietario(Proprietario proprietario) throws SQLException {
		
		
	}
	
}
