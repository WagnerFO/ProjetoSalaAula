package IRepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Carro;

public interface IRepositorioCarroSQL {
	
	void salvar(Carro carro) throws SQLException;
	ArrayList<Carro> listarCarros();
	Carro buscarPorPlaca(Carro carro);
	void remover(Carro carro);
	Carro atualizar(Carro carro) throws SQLException;
}
