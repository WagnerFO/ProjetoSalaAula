package Entidades;

import java.util.ArrayList;
import java.util.List;

public class Venda {

    private static int nextId=1;

    private int id;
    private Proprietario proprietario;
    private List<Veiculo> veiculosVendidosPorCliente;
    
    public Venda(Proprietario proprietario){
        this.id=nextId++;
        this.proprietario=proprietario;
        this.veiculosVendidosPorCliente= new ArrayList<>();
    }
    
    public int getId() {
        return id;
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
}
