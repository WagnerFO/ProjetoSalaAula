package Repositorio;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Caminhao;
import Entity.Enum.CaminhaoTipo;
import IRepositorio.IRepositorioCaminhaoSQL;
import Util.ConnectionSingleton;

public class RepositorioCaminhaoSQL implements IRepositorioCaminhaoSQL {

    private Connection connection;

    public RepositorioCaminhaoSQL() {
        try {
            this.connection = ConnectionSingleton.getInstance().conexao;
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    @Override
    public void salvar(Caminhao caminhao) throws SQLException {
        String sql = "INSERT INTO caminhoes (marca, modelo, cor, ano, placa, valorVenda, toneladasCarga, caminhaoTipo) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, caminhao.getMarca());
            stmt.setString(2, caminhao.getModelo());
            stmt.setString(3, caminhao.getCor());
            stmt.setInt(4, caminhao.getAno());
            stmt.setString(5, caminhao.getPlaca());
            stmt.setDouble(6, caminhao.getValorVenda());
            stmt.setDouble(7, caminhao.getToneladasCarga());
            stmt.setString(8, caminhao.getTipo().name());
            stmt.executeUpdate();
        }
    }

    @Override
    public ArrayList<Caminhao> listarCaminhoesDisp() {
        String sql = "SELECT * FROM caminhoes";
        ArrayList<Caminhao> caminhões = new ArrayList<>();
        try (PreparedStatement stmt = connection.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
                Caminhao caminhao = new Caminhao(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("cor"),
                        rs.getInt("ano"),
                        rs.getString("placa"),
                        rs.getDouble("valorVenda"),
                        rs.getDouble("toneladasCarga"),
                        CaminhaoTipo.valueOf(rs.getString("caminhaoTipo"))
                );
                caminhões.add(caminhao);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return caminhões;
    }

    @Override
    public Caminhao buscarPorPlaca(Caminhao caminhao) {
        String sql = "SELECT * FROM caminhoes WHERE placa=?";
        Caminhao resultado = null;
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, caminhao.getPlaca());
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                resultado = new Caminhao(
                        rs.getString("marca"),
                        rs.getString("modelo"),
                        rs.getString("cor"),
                        rs.getInt("ano"),
                        rs.getString("placa"),
                        rs.getDouble("valorVenda"),
                        rs.getDouble("toneladasCarga"),
                        CaminhaoTipo.valueOf(rs.getString("caminhaoTipo"))
                        );
                System.out.println("Caminhão encontrado: "+resultado);
                }else {
                	System.out.println("Caminhão não encontrado.");
                	}
            } catch (SQLException e) {
            	e.printStackTrace();
            	}
        return resultado;
        }

    @Override
    public void remover(Caminhao caminhao) {
        String sql = "DELETE FROM caminhoes WHERE placa = ?";
        try (PreparedStatement stmt = connection.prepareStatement(sql)) {
            stmt.setString(1, caminhao.getPlaca());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
