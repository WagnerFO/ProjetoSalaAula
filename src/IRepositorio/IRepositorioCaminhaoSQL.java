package IRepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Caminhao;

public interface IRepositorioCaminhaoSQL {
	
	void salvar(Caminhao caminhao) throws SQLException;
	ArrayList<Caminhao> listarCaminhoesDisp();
	Caminhao buscarPorPlaca(Caminhao caminhao);
	void remover(Caminhao caminhao);
}
