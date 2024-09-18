package Entidades;

public abstract class  Veiculo {

	private static int nextId = 1;

	private int id;
    private  String marca;
    private String modelo;
    private String cor;
    private int ano;
	private String placa;
	

    public Veiculo(){
		this.id=nextId++;
    }

    public Veiculo(String marca, String modelo, String cor, int ano, String placa){
        this.id=nextId++;
		this.marca=marca;
        this.modelo=modelo;
        this.cor=cor;
        this.ano=ano;
		this.placa=placa;
    }

	

    public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	

}
