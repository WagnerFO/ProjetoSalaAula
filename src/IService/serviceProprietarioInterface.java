package IService;

import java.util.ArrayList;

import Entidades.Proprietario;

public interface serviceProprietarioInterface {

    public void cadastrarProprietario(Proprietario proprietario) throws Exception;
    public void removerProprietario(Proprietario proprietario);
    public void alterarProprietario(Proprietario proprietario) throws Exception;
    ArrayList<Proprietario> verProprietario();
    public Proprietario buscarProprietario(String cpf);
}
