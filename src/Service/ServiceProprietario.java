package Service;

import java.util.ArrayList;

import Entidades.Proprietario;
import IRepositorio.repositorioProprietarioInterface;
import IService.serviceProprietarioInterface;

public class ServiceProprietario implements serviceProprietarioInterface{

    private repositorioProprietarioInterface proprietarioRepositorio;
    public ServiceProprietario (repositorioProprietarioInterface proprietarioRepositorio){
        this.proprietarioRepositorio = proprietarioRepositorio;
    }
    
	@Override
	public void cadastrarProprietario(Proprietario proprietario) throws Exception {
		if(proprietario.getNome() == null || proprietario.getNome().trim().isEmpty()){
            throw new Exception("Nome do Proprietario é OBRIGATÓRIO!");
        }
        if(proprietario.getCpf() == null || proprietario.getCpf().trim().isEmpty()){
            throw new Exception("CPF do Proprietário é OBRIGATÓRIO!");
        }
        if(proprietario.getIdade() < 18 ) {
        	throw new Exception("Idade do Proprietário deve ser maior que 18 anos.");
        }
		proprietarioRepositorio.cadastrarProprietario(proprietario);
	}

	@Override
	public void removerProprietario(Proprietario proprietario){
		proprietarioRepositorio.removerProprietario(proprietario);	
	}

	@Override
	public void alterarProprietario(Proprietario proprietario) throws Exception {
		if(proprietario.getNome() == null || proprietario.getNome().trim().isEmpty()){
            throw new Exception("Nome do Proprietario é OBRIGATÓRIO!");
        }
        if(proprietario.getCpf() == null || proprietario.getCpf().trim().isEmpty()){
            throw new Exception("CPF do Proprietário é OBRIGATÓRIO!");
        }
        if(proprietario.getIdade() < 18 ) {
        	throw new Exception("Idade do Proprietário deve ser maior que 18 anos.");
        }
		proprietarioRepositorio.atualizarProprietario(proprietario);	
	}

	@Override
	public Proprietario buscarProprietario(String cpf) {
		return proprietarioRepositorio.buscarProprietarioPorCpf(cpf);
	}

	@Override
	public ArrayList<Proprietario> verProprietario() {
		return proprietarioRepositorio.verProprietarios();
	}
	
}