package IRepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Moto;

public interface IRepositorioMotoSQL {
	
	void salvar(Moto moto) throws SQLException;
	ArrayList<Moto> listarMotos();
	Moto buscarPorPlaca(Moto moto);
	void remover(Moto moto);
	Moto atualizar(Moto moto) throws SQLException;
}
