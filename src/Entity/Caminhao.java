package Entity;

import Entity.Enum.CaminhaoTipo;

public class Caminhao extends Veiculo {
	
	private int id;
    private double toneladasCarga;
    private CaminhaoTipo tipo;

    public Caminhao() {
    }
    
    public Caminhao(String placa) {
    	super(placa);
    }

    public Caminhao(String marca, String modelo, String cor, int ano, String placa, double valorVenda, double toneladasCarga, CaminhaoTipo tipo) {
        super(marca, modelo, cor, ano, placa, valorVenda);
        this.toneladasCarga = toneladasCarga;
        this.tipo = tipo;
    }
    
    public Caminhao(int id, String marca, String modelo, String cor, int ano, String placa, double valorVenda, double toneladasCarga, CaminhaoTipo tipo) {
        super(marca, modelo, cor, ano, placa, valorVenda);
        this.id=id;
        this.toneladasCarga = toneladasCarga;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id=id;
    }

    public double getToneladasCarga() {
        return toneladasCarga;
    }

    public void setToneladasCarga(double toneladasCarga) {
        this.toneladasCarga = toneladasCarga;
    }

    public CaminhaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(CaminhaoTipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nCaminhão:\n" +
               "ID: " + getId() + "\n" +
               "Marca: " + getMarca() + "\n" +
               "Modelo: " + getModelo() + "\n" +
               "Cor: " + getCor() + "\n" +
               "Ano: " + getAno() + "\n" +
               "Placa: " + getPlaca() + "\n" +
               "Valor: " + getValorVenda() + "\n" +
               "Toneladas de Carga: " + getToneladasCarga() + "\n" +
               "Tipo: " + getTipo() + "\n";
    }
}
