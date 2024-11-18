package Service;

import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Proprietario;
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
		if(proprietario.getNome()==null || proprietario.getNome().trim().isEmpty())
			throw new SQLException("nome do Proprietario é Obrigatório!");
		if(proprietario.getCpf() == null || proprietario.getCpf().trim().isEmpty())
            throw new SQLException("CPF do Proprietário é OBRIGATÓRIO!");
        if(proprietario.getIdade() < 18 ) 
        	throw new SQLException("Idade do Proprietário deve ser maior que 18 anos.");
		if(proprietario.getEndereco() == null || proprietario.getEndereco().trim().isEmpty())
			throw new SQLException("Endereco do Proprietário é obrigatório! ");
		if(proprietario.getTelefoneContato() == null || proprietario.getTelefoneContato().trim().isEmpty());
			
		proprietarioRepositorioSQL.adicionarProprietario(proprietario);
	}

	@Override
	public void removerProprietario(Proprietario proprietario){
		proprietarioRepositorio.removerProprietario(proprietario);
	}

	@Override
	public void excluirProp(Proprietario proprietario){
		proprietarioRepositorioSQL.excluirProp(proprietario);
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
	public void alterarProp(Proprietario proprietario, String cpfOriginal) throws SQLException {
		if (proprietario.getNome() == null || proprietario.getNome().trim().isEmpty()) {
			throw new SQLException("Nome do Proprietário é OBRIGATÓRIO!");
		}
		if (proprietario.getCpf() == null || proprietario.getCpf().trim().isEmpty()) {
			throw new SQLException("CPF do Proprietário é OBRIGATÓRIO!");
		}
		if (proprietario.getIdade() < 18) {
			throw new SQLException("Idade do Proprietário deve ser maior que 18 anos.");
		}

		proprietarioRepositorioSQL.alterarProprietario(proprietario);
	}

	@Override
	public ArrayList<Proprietario> verProprietario() {
		return proprietarioRepositorio.verProprietarios();
	}

	@Override
	public ArrayList<Proprietario> listarTodos() throws SQLException{
		return proprietarioRepositorioSQL.listarTodos();
	}

	@Override
	public Proprietario buscarProprietario(String cpf) {
		return proprietarioRepositorio.buscarProprietarioPorCpf(cpf);
	}

	@Override
	public ArrayList<Proprietario> listarProp(int id)throws SQLException{
		return proprietarioRepositorioSQL.listarTodosProprietario();
	}
	
	@Override
	public Proprietario pesquisarPorprietario(String cpf){
		return proprietarioRepositorioSQL.pesquisarProprietarios(cpf);
	}
}