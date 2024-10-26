package Entity;

import Entity.Enum.MotoTipo;

public class Moto extends Veiculo {

    private static int nextId = 1;

	private int id;
    private int cilindradas;
    private MotoTipo tipo;

    public Moto() {
        super();
        this.id=nextId++;
    }

    public Moto(String marca, String modelo, String cor, int ano, String placa, double valorVenda, int cilindradas, MotoTipo tipo) {
        super(marca, modelo, cor, ano, placa, valorVenda);
        this.id=nextId++;
        this.cilindradas = cilindradas;
        this.tipo = tipo;
    }

    public int getId() {
        return id;
    }

    public int getCilindradas() {
        return cilindradas;
    }

    public void setCilindradas(int cilindradas) {
        this.cilindradas = cilindradas;
    }

    public MotoTipo getTipo() {
        return tipo;
    }

    public void setTipo(MotoTipo tipo) {
        this.tipo = tipo;
    }

    @Override
    public String toString() {
        return "\nMoto:\n" +
               "ID: " + getId() + "\n" +
               "Marca: " + getMarca() + "\n" +
               "Modelo: " + getModelo() + "\n" +
               "Cor: " + getCor() + "\n" +
               "Ano: " + getAno() + "\n" +
               "Placa: " + getPlaca() + "\n" +
               "Valor: " + getValorVenda() + "\n" +
               "Tipo: " + getTipo() + "\n" +
               "Cilindrada: " + getCilindradas() + "\n";
    }
}
