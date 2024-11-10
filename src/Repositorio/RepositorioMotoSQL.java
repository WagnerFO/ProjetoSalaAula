package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Moto;
import Entity.Enum.MotoTipo;
import IRepositorio.IRepositorioMotoSQL;
import Util.ConnectionSingleton;

public class RepositorioMotoSQL implements IRepositorioMotoSQL {

    private Connection connection;

    public RepositorioMotoSQL() {
        try {
            this.connection = ConnectionSingleton.getInstance().conexao;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void salvar(Moto moto) throws SQLException {
        String sql = "INSERT INTO motos (marca, modelo, cor, ano, placa, valorVenda, cilindradas, motoTipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, moto.getMarca());
            stmt.setString(2, moto.getModelo());
            stmt.setString(3, moto.getCor());
            stmt.setInt(4, moto.getAno());
            stmt.setString(5, moto.getPlaca());
            stmt.setDouble(6, moto.getValorVenda());
            stmt.setInt(7, moto.getCilindradas());
            stmt.setString(8, moto.getTipo().name());
            stmt.executeUpdate();
        }
    }

    @Override
    public ArrayList<Moto> listarMotosDisp() {
        String sql = "SELECT * FROM motos";
        ArrayList<Moto> motos = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Moto moto = new Moto(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("cor"),
                        rs.getInt("ano"),
                        rs.getString("placa"),
                        rs.getDouble("valorVenda"),
                        rs.getInt("cilindradas"),
                        MotoTipo.valueOf(rs.getString("motoTipo"))
                );
                motos.add(moto);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return motos;
    }

    @Override
    public Moto buscarPorPlaca(Moto moto) {
        String sql = "SELECT * FROM motos WHERE placa=?";
        Moto resultado = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, moto.getPlaca());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                resultado = new Moto(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("cor"),
                        rs.getInt("ano"),
                        rs.getString("placa"),
                        rs.getDouble("valorVenda"),
                        rs.getInt("cilindradas"),
                        MotoTipo.valueOf(rs.getString("motoTipo"))
                        );
                    	System.out.println("Moto encontrada: "+resultado);
			}else {
				System.out.println("Moto não encontrada.");
			}
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultado;
    }

    @Override
    public void remover(Moto moto) {
        String sql = "DELETE FROM motos WHERE placa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, moto.getPlaca());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
