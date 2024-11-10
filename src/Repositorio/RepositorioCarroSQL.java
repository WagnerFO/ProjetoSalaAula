package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Carro;
import Entity.Enum.CarroTipo;
import IRepositorio.IRepositorioCarroSQL;
import Util.ConnectionSingleton;

public class RepositorioCarroSQL implements IRepositorioCarroSQL{
	
	private Connection connection;
	
	public RepositorioCarroSQL () {
		try {
			this.connection = ConnectionSingleton.getInstance().conexao;
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	
	@Override
	public void salvar(Carro carro) throws SQLException {
		String sql = ("INSERT INTO carros (marca, modelo, cor,	ano, placa,  valorVenda, quantPortas, carroTipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
		try (PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, carro.getMarca());
			stmt.setString(2, carro.getModelo());
			stmt.setString(3, carro.getCor());
			stmt.setInt(4, carro.getAno());
			stmt.setString(5, carro.getPlaca());
			stmt.setDouble(6, carro.getValorVenda());
			stmt.setInt(7, carro.getQuantPortas());
			stmt.setString(8, carro.getTipo().name());
			stmt.executeUpdate();
		}
		
	}

	@Override
	public ArrayList<Carro> listarCarrosDisp() {
		String sql = ("SELECT * FROM carros");
		ArrayList<Carro> cars = new ArrayList<>();
		try (PreparedStatement stmt = connection.prepareStatement(sql);
	             ResultSet rs = stmt.executeQuery()) {

	            while (rs.next()) {
	            	Carro carro = new Carro(
	            		    rs.getString("marca"),
	            		    rs.getString("modelo"),
	            		    rs.getString("cor"),
	            		    rs.getInt("ano"),
	            		    rs.getString("placa"),
	            		    rs.getDouble("valorVenda"),
	            		    rs.getInt("quantPortas"),
	            		    CarroTipo.valueOf(rs.getString("carroTipo")));
	            	cars.add(carro);
	            	}
	            }catch(SQLException e) {
	            	e.printStackTrace();
	            	}
		return cars;
		}

	@Override
	public Carro buscarPorPlaca(Carro carro) {
		String sql = "SELECT * FROM carros WHERE placa=?";
		Carro resultado = null;
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, carro.getPlaca());
			ResultSet rs = stmt.executeQuery();
			if(rs.next()) {
				resultado = new Carro(
            		    rs.getString("marca"),
            		    rs.getString("modelo"),
            		    rs.getString("cor"),
            		    rs.getInt("ano"),
            		    rs.getString("placa"),
            		    rs.getDouble("valorVenda"),
            		    rs.getInt("quantPortas"),
            		    CarroTipo.valueOf(rs.getString("carroTipo"))
            		    );
				
				System.out.println("Carro encontrado: "+resultado);
			}else {
				System.out.println("Carro não encontrado.");
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return resultado;
	}

	@Override
	public void remover(Carro carro) {
		String sql = "DELETE FROM carros WHERE placa = ?";		
		try(PreparedStatement stmt = connection.prepareStatement(sql)){
			stmt.setString(1, carro.getPlaca());
			stmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}

}
