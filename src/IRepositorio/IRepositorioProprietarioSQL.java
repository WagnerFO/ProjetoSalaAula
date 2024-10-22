package IRepositorio;

import java.sql.SQLException;

import Entidades.Proprietario;

public interface IRepositorioProprietarioSQL {
	
	void adicionarProprietario(Proprietario proprietario) throws SQLException;
	void alterarProprietario(Proprietario proprietario) throws SQLException;

}
