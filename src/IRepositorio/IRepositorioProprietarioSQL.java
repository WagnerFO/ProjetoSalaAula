package IRepositorio;

import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Proprietario;
import Entity.Veiculo;

public interface IRepositorioProprietarioSQL {
	
	void cadastrarProp (Proprietario proprietario) throws SQLException;
	void alterarProprietario(Proprietario proprietario) throws SQLException;
	ArrayList<Proprietario> listarTodosProprietario() throws SQLException;
	Proprietario pesquisarProprietarios(String cpf);
	ArrayList<Proprietario> listarTodos() throws SQLException;
	void excluirProp(Proprietario proprietario);
	void adicionarProprietario(Proprietario proprietario) throws SQLException;
	void salvarVeiculo(String cpfProprietario, Veiculo veiculo, String tipoVeiculo) throws SQLException;
	void removerVeiculos(String cpfProprietario)throws SQLException;

}
