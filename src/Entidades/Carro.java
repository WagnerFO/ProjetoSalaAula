package Entidades;

public class Carro extends Veiculo {
   
    Proprietario proprietario;
    
    public Carro() {
        super();
    }

    public Carro(String marca, String modelo, String cor, int ano,String placa, Proprietario proprietario) {
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
