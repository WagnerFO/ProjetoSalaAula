package Entidades;

public class Pessoa {

    private static int nextId = 1;

    private int id;
    private String nome;
    private int idade;
    private String cpf;

    public Pessoa(){
        this.id=nextId++;
    }

    public Pessoa(String nome, int idade, String cpf){
        this.id=nextId++;
        this.nome=nome;
        this.idade=idade;
        this.cpf=cpf;
    }

	public int getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getIdade() {
		return idade;
	}

	public void setIdade(int idade) {
		this.idade = idade;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

}
