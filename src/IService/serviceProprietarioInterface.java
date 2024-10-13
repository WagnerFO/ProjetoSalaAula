package IService;

import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Proprietario;

public interface serviceProprietarioInterface {

    public void cadastrarProprietario(Proprietario proprietario) throws Exception;
    public void adicionarProprietario(Proprietario proprietario) throws SQLException;
    public void removerProprietario(Proprietario proprietario);
    public void atualizarProprietario(Proprietario proprietario) throws Exception;
    ArrayList<Proprietario> verProprietario();
    public Proprietario buscarProprietario(String cpf);
}
