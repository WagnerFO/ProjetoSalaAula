package Entity;

import java.util.ArrayList;

public class Proprietario extends Pessoa {

    private int id;
    private String telefoneContato;
    private String endereco;
    private ArrayList<Veiculo> veiculos;	

    public Proprietario(){
        
    }

    public Proprietario(String nome, int idade, String cpf, String telefoneContato, String endereco){
        super(nome, idade, cpf);
        this.telefoneContato=telefoneContato;
        this.endereco=endereco;
        this.veiculos = new ArrayList<>();
        }
    
    
    public int getId(){
        return id;
    }
    
    public void setId(int id) {
    	this.id=id;
    }

    public String getTelefoneContato() {
        return telefoneContato;
    }

    public void setTelefoneContato(String telefoneContato) {
        this.telefoneContato = telefoneContato;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }
    
    public ArrayList<Veiculo> getVeiculos(){
    	return veiculos;
    }
    
    public void setVeiculos(ArrayList<Veiculo> veiculos) {
    	this.veiculos = veiculos;
    }
    
    public void adicionarVeiculo(Veiculo veiculo) {
    	this.veiculos.add(veiculo);
    }
    
    
    @Override
    public String toString() {
        return 
            "\n"+"Proprietário:\n" +
           "ID: " + getId() + "\n" +
           "Nome: " + getNome() + "\n" +
           "Idade: " + getIdade() + "\n" +
           "CPF: " + getCpf() + "\n" +
           "Telefone de Contato: " + telefoneContato + "\n" +
           "Endereço: " + endereco+"\n";
}


    
}
