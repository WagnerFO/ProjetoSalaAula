package Entity;

public abstract class  Veiculo {

    private String marca;
    private String modelo;
    private String cor;
    private int ano;
	private String placa;
	private double valorVenda;
	

    public Veiculo(){
    }
    public Veiculo(String placa) {
    	this.placa=placa;
    }

    public Veiculo(String marca, String modelo, String cor, int ano, String placa, double valorVenda){
		this.marca=marca;
        this.modelo=modelo;
        this.cor=cor;
        this.ano=ano;
		this.placa=placa;
		this.valorVenda=valorVenda;
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
		if(ano>1900 && ano <=java.time.Year.now().getValue()){
		this.ano = ano;
		}
		else{
			throw new IllegalArgumentException("Ano Inválido!");
		}
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public double getValorVenda() {
		return valorVenda;
	}

	public void setValorVenda(double valorVenda) {
		this.valorVenda = valorVenda;
	}

}
