package IService;

import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Proprietario;

public interface serviceProprietarioInterface {

    public void cadastrarProprietario(Proprietario proprietario) throws Exception;
    public void adicionarProprietario(Proprietario proprietario) throws SQLException;
    public void removerProprietario(Proprietario proprietario);
    public void excluirProp(Proprietario proprietario);
    public void atualizarProprietario(Proprietario proprietario) throws Exception;
    public void alterarProp(Proprietario proprietario) throws SQLException;
    ArrayList<Proprietario> verProprietario();
    ArrayList<Proprietario> listarTodos() throws SQLException;
    public Proprietario buscarProprietario(String cpf);
    public Proprietario listarProp(int codigo)throws SQLException;
    Proprietario pesquisarPorprietario(String cpf);
}
