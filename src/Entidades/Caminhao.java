package Entidades;

import Entidades.Enum.CaminhaoTipo;

public class Caminhao extends Veiculo {

    private int toneladasCarga;
    private CaminhaoTipo tipo;
 

    public Caminhao() {
        super();
    }

    public Caminhao(String marca, String modelo, String cor, int ano, String placa, int toneladasCarga, CaminhaoTipo tipo) {
		super(marca, modelo, cor, ano, placa);
        this.toneladasCarga = toneladasCarga;
        this.tipo = tipo;
	}

    public CaminhaoTipo getTipo() {
        return tipo;
    }

    public void setTipo(CaminhaoTipo tipo) {
        this.tipo = tipo;
    }

    public int getToneladasCarga() {
        return toneladasCarga;
    }

    public void setToneladasCarga(int toneladasCarga) {
        this.toneladasCarga = toneladasCarga;
    }
}


