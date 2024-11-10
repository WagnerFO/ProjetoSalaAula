package Entity;

import Entity.Enum.CarroTipo;

public class Carro extends Veiculo {

	private int id;
    private int quantPortas;
    private CarroTipo tipo;
 

    public Carro() {
    }

    public Carro(String marca, String modelo, String cor, int ano,String placa, double valorVenda, int quantPortas, CarroTipo tipo) {
        super(marca, modelo, cor, ano,placa, valorVenda);
        this.quantPortas=quantPortas;
        this.tipo=tipo;
	}
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id=id;
    }

    public CarroTipo getTipo() {
        return tipo;
    }

    public void setTipo(CarroTipo tipo){
        this.tipo = tipo;
    }

    public int getQuantPortas(){
        return quantPortas;
    }

    public void setQuantPortas(int quantPortas){
        this.quantPortas=quantPortas;
    }

    @Override
    public String toString() {
    return 
            "\n"+"Carro:\n" +
            "ID: "+getId()+"\n"+
            "Marca: " + getMarca() + "\n" +
            "Modelo: " + getModelo() + "\n" +
            "Cor: " + getCor() + "\n" +
            "Ano: " + getAno() + "\n" +
            "Placa: " + getPlaca() + "\n" +
            "Valor: " + getValorVenda() + "\n" +
            "Quantidade de Portas: " + getQuantPortas() + "\n" +
            "Tipo: " + tipo +"\n";
        }    
    
}
