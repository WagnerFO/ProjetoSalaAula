package Entidades;

public class Moto extends Veiculo{
	
	Proprietario proprietario;

	public Moto() {
		super();
	}
	
	public Moto (String marca, String modelo, String cor, int ano,String placa, Proprietario proprietario) {
		super(marca, modelo, cor, ano,placa);
		this.proprietario=proprietario;
	}

	

	public Proprietario getProprietario() {
		return proprietario;
	}

	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}
	
}
