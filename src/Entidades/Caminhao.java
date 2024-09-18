package Entidades;

public class Caminhao extends Veiculo {
	
	Proprietario proprietario;
	
	public Caminhao() {
		super();
	}
	
	public Caminhao(String marca, String modelo, String cor, int ano,String placa, Proprietario proprietario) {
		super(marca, modelo, cor, ano,placa);
		this.proprietario=proprietario;
	}


	public void setProprietario(Proprietario proprietario) {
		this.proprietario = proprietario;
	}

	public Proprietario getProprietario() {
		return proprietario;
	}

    
	
}


