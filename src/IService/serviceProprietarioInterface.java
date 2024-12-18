package IService;

import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Proprietario;

public interface serviceProprietarioInterface {

    public void cadastrarProprietario(Proprietario proprietario) throws Exception;
    public void adicionarProprietario(Proprietario proprietario) throws SQLException;
    public void removerProprietario(Proprietario proprietario);
    public void excluirProp(Proprietario proprietario);
    public void atualizarProprietario(Proprietario proprietario) throws Exception;
    public void alterarProp(Proprietario proprietario, String cpfOriginal) throws SQLException;
    ArrayList<Proprietario> verProprietario();
    ArrayList<Proprietario> listarTodos() throws SQLException;
    public Proprietario buscarProprietario(String cpf);
    ArrayList<Proprietario> listarProp(int codigo)throws SQLException;
    Proprietario pesquisarPorprietario(String cpf);
}
