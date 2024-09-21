package Entidades;

import Entidades.Enum.CaminhaoTipo;

public class Caminhao extends Veiculo {

    private double toneladasCarga;
    private CaminhaoTipo tipo;

    public Caminhao() {
        super();
    }

    public Caminhao(String marca, String modelo, String cor, int ano, String placa, double valorVenda, double toneladasCarga, CaminhaoTipo tipo) {
        super(marca, modelo, cor, ano, placa, valorVenda);
        this.toneladasCarga = toneladasCarga;
        this.tipo = tipo;
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
        return "Caminhão:\n" +
               "ID: " + getId() + "\n" +
               "Marca: " + getMarca() + "\n" +
               "Modelo: " + getModelo() + "\n" +
               "Cor: " + getCor() + "\n" +
               "Ano: " + getAno() + "\n" +
               "Placa: " + getPlaca() + "\n" +
               "Valor: " + getValorVenda() + "\n" +
               "Toneladas de Carga: " + getToneladasCarga() + "\n" +
               "Tipo: " + tipo;
    }
}
