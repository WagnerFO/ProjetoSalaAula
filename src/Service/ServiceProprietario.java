package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import Entidades.Proprietario;
import IRepositorio.IRepositorioProprietarioSQL;
import IRepositorio.repositorioProprietarioInterface;
import IService.serviceProprietarioInterface;

public class ServiceProprietario implements serviceProprietarioInterface{

    private repositorioProprietarioInterface proprietarioRepositorio;
    public ServiceProprietario (repositorioProprietarioInterface proprietarioRepositorio){
        this.proprietarioRepositorio = proprietarioRepositorio;
    }
    
    private IRepositorioProprietarioSQL proprietarioRepositorioSQL;
    public ServiceProprietario(IRepositorioProprietarioSQL proprietarioRepositorioSQL) {
    	this.proprietarioRepositorioSQL=proprietarioRepositorioSQL;
    }
    
	@Override
	public void cadastrarProprietario(Proprietario proprietario) throws Exception {
		if(proprietario.getNome() == null || proprietario.getNome().trim().isEmpty())
            throw new Exception("Nome do Proprietario é OBRIGATÓRIO!");
        if(proprietario.getCpf() == null || proprietario.getCpf().trim().isEmpty())
            throw new Exception("CPF do Proprietário é OBRIGATÓRIO!");
        if(proprietario.getIdade() < 18 ) 
        	throw new Exception("Idade do Proprietário deve ser maior que 18 anos.");
		if(proprietario.getEndereco() == null || proprietario.getEndereco().trim().isEmpty())
			throw new Exception("Endereco do Proprietário é obrigatório! ");
		if(proprietario.getTelefoneContato() == null || proprietario.getTelefoneContato().trim().isEmpty());

		proprietarioRepositorio.cadastrarProprietario(proprietario);
	}
	
	@Override
	public void adicionarProprietario(Proprietario proprietario) throws SQLException{
		proprietarioRepositorioSQL.adicionarProprietario(proprietario);
	}

	@Override
	public void removerProprietario(Proprietario proprietario){
		proprietarioRepositorio.removerProprietario(proprietario);	
	}

	@Override
	public void atualizarProprietario(Proprietario proprietario) throws Exception {
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