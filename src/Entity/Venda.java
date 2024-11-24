package Entity;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private int id;
    private int numVenda;
    private Proprietario proprietario;
    private List<Veiculo> veiculosVendidosPorCliente;
    
    public Venda() {
    	
    }
    
    public Venda(int id, int numVenda) {
    	this.id=id;
    	this.numVenda=numVenda;
    }
    
    public Venda(Proprietario proprietario,int numVenda){
        this.proprietario=proprietario;
        this.numVenda=numVenda;
        this.veiculosVendidosPorCliente= new ArrayList<>();
    }
    
    public int getId() {
        return id;
    }
    
    public void setId(int id) {
    	this.id=id;
    }

    public Proprietario getProprietario() {
        return proprietario;
    }

    public void setProprietario(Proprietario proprietario) {
        this.proprietario = proprietario;
    }

    public List<Veiculo> getVeiculosVendidos(){
        return veiculosVendidosPorCliente;
    }
    
    public void setVeiculoVendidos(List<Veiculo> veiculos) {
    	this.veiculosVendidosPorCliente = veiculos;
    }

    public void vendaVeiculo(Veiculo veiculo){
        veiculosVendidosPorCliente.add(veiculo);
    }

    public void listarVeiculosVendidos(){
        if(veiculosVendidosPorCliente.isEmpty()){
            System.out.println("Esse Proprietário não possui nenhum veiculo");
        }
        else{
            System.out.println("Veiculos vendidos para "+proprietario.getNome()+": ");
            for(Veiculo veiculo: veiculosVendidosPorCliente){
                System.err.println(veiculo.getMarca());
            }
        }
    }

	public int getNumVenda() {
		return numVenda;
	}

	public void setNumVenda(int numVenda) {
		this.numVenda = numVenda;
	}
}
