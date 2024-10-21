package Repositorio;

import java.sql.PreparedStatement;
import java.sql.SQLException;


import Entidades.Proprietario;
import IRepositorio.IRepositorioProprietarioSQL;
import Util.Conexao;

public class RepositorioProprietarioSQL implements IRepositorioProprietarioSQL{
	
	@Override
	public void adicionarProprietario(Proprietario proprietario) throws SQLException {
		String sql = "INSERT INTO proprietario( nome, idade, cpf, telefoneContato, endereco) VALUES(?, ?, ?, ?, ?)";
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

}
