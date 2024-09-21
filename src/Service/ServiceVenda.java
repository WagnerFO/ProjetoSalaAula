package Service;

import Entidades.Venda;
import IRepositorio.repositorioVendaInterface;
import IService.serviceVendaInterface;
import Entidades.Veiculo;

import java.util.List;

public class ServiceVenda implements serviceVendaInterface{

    private repositorioVendaInterface vendaRepositorio;
    public ServiceVenda (repositorioVendaInterface vendaRepositorio){
        this.vendaRepositorio=vendaRepositorio;
    }

    @Override
    public void realizarVenda(Venda venda) {
        vendaRepositorio.adicionarVenda(venda);
    }

    @Override
    public List<Venda> listarVendas() {
        return vendaRepositorio.listarVendas();
    }

    @Override
    public Venda buscarVendaPorId(int id) {
        return vendaRepositorio.buscarVendaPorId(id);
    }

    @Override
    public void removerVenda(int id) {
        vendaRepositorio.removerVenda(id);
    }

    @Override
    public void atualizarVenda(int id, Venda vendaAtualizada) {
        vendaRepositorio.atualizarVenda(id, vendaAtualizada);
    }

    @Override
    public Veiculo buscarVeiculoNaVenda(int vendaId, String placa) {
        Venda venda = vendaRepositorio.buscarVendaPorId(vendaId);
        if (venda != null) {
            for (Veiculo veiculo : venda.getVeiculosVendidos()) {
                if (veiculo.getPlaca().equalsIgnoreCase(placa)) { // Método getPlaca() deve existir na classe Veiculo
                    return veiculo;
                }
            }
        }
        return null; // Se não encontrar
    }
}