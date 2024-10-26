package IRepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Proprietario;

public interface IRepositorioProprietarioSQL {
	
	void cadastrarProp (Proprietario proprietario) throws SQLException;
	void alterarProprietario(Proprietario proprietario) throws SQLException;
	Proprietario listarProp(int codigo)throws SQLException;
	Proprietario pesquisarProprietarios(String cpf);
	ArrayList<Proprietario> listarTodos() throws SQLException;
	void excluirProp(Proprietario proprietario);
	void adicionarProprietario(Proprietario proprietario) throws SQLException;

}
