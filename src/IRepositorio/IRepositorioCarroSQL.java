package IRepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Carro;

public interface IRepositorioCarroSQL {
	
	void salvar(Carro carro) throws SQLException;
	ArrayList<Carro> listarCarrosDisp();
	Carro buscarPorPlaca(Carro carro);
	void remover(Carro carro);
}
