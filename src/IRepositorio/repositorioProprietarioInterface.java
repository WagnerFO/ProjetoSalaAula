package IRepositorio;

import java.util.ArrayList;

import Entity.Proprietario;

public interface repositorioProprietarioInterface {

    public void cadastrarProprietario(Proprietario proprietario);
    public void atualizarProprietario(Proprietario proprietario);
    public void removerProprietario(Proprietario proprietario);
    ArrayList <Proprietario> verProprietarios();    
    Proprietario buscarProprietarioPorCpf(String cpf);

}
