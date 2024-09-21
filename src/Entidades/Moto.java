package Entidades;

import Entidades.Enum.MotoTipo;

public class Moto extends Veiculo {

    private int cilindradas;
    private MotoTipo tipo;
 

    public Moto() {
        super();
    }

    public Moto(String marca, String modelo, String cor, int ano, String placa, int cilindradas, MotoTipo tipo) {
		super(marca, modelo, cor, ano, placa);
        this.cilindradas = cilindradas;
        this.tipo = tipo;
	}

    public MotoTipo getTipo() {
        return tipo;
    }

    public void setTipo(MotoTipo tipo) {
        this.tipo = tipo;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }
}
