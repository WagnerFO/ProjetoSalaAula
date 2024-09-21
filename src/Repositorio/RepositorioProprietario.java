package Repositorio;

import java.util.ArrayList;

import Entidades.Proprietario;
import IRepositorio.repositorioProprietarioInterface;

public class RepositorioProprietario implements repositorioProprietarioInterface {
	private ArrayList<Proprietario> proprietarios = new ArrayList<>();

	@Override
	public void cadastrarProprietario(Proprietario proprietario) {
		proprietarios.add(proprietario);
	}
    public void cadastrarProprietario(int id, String nome, int idade, String cpf, String telefoneContato, String endereco){
        Proprietario proprietario = new Proprietario();
        proprietarios.add(proprietario);
    }

	@Override
	public void atualizarProprietario(Proprietario proprietario) {
		Proprietario buscar = buscarProprietarioPorCpf(proprietario.getCpf());
        if(buscar!=null){
            buscar.setNome(proprietario.getNome());
            buscar.setIdade(proprietario.getIdade());
            buscar.setCpf(proprietario.getCpf());            
        }
	}

	@Override
	public void removerProprietario(Proprietario proprietario) {
		proprietarios.remove(proprietario);
	}
	

    @Override
    public ArrayList<Proprietario> verProprietarios() {
        return proprietarios;
    }
    
    @Override
    public Proprietario buscarProprietarioPorCpf(String cpf) {
        for(Proprietario proprietario : proprietarios){
            if(proprietario.getCpf().equals(cpf)){
                return proprietario;
            }
        }
        return null;
    }
    

}
