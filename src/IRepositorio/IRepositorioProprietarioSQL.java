package IRepositorio;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import Entity.Proprietario;
import Entity.Veiculo;
import Entity.Venda;

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
	void removerVenda(int idVenda) throws SQLException;
	void removerVeiculosDaVenda(int idVenda) throws SQLException;
	List<Veiculo> buscarVeiculosPorVenda(int idVenda) throws SQLException;
	Venda buscarVendaPorNumVenda(int numVenda) throws SQLException;
	List<Map<String, String>> buscarRegistrosPorNumVenda(int numVenda) throws SQLException;
	List<Map<String, String>> listarRegistrosVenda() throws SQLException;
	void atualizarProprietarioVenda(int numVenda, String novoCpf) throws SQLException;
	void atualizarVeiculoNaVenda(int numVenda, String placaAtual, String novaPlaca, String novoTipo)
			throws SQLException;

}
