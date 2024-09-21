package Entidades;

import Entidades.Enum.CarroTipo;

public class Carro extends Veiculo {

    private int quantPortas;
    private CarroTipo tipo;
 

    public Carro() {
        super();
    }

    public Carro(String marca, String modelo, String cor, int ano,String placa, double valorVenda, int quantPortas, CarroTipo tipo) {
		super(marca, modelo, cor, ano,placa, valorVenda);
        this.quantPortas=quantPortas;
        this.tipo=tipo;
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
    return "Carro:\n" +
            "ID: "+getId()+"\n"+
            "Marca: " + getMarca() + "\n" +
            "Modelo: " + getModelo() + "\n" +
            "Cor: " + getCor() + "\n" +
            "Ano: " + getAno() + "\n" +
            "Placa: " + getPlaca() + "\n" +
            "Valor: " + getValorVenda() + "\n" +
            "Quantidade de Portas: " + getQuantPortas() + "\n" +
            "Tipo: " + tipo;
        }    
    
}
