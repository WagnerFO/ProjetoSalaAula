package IService;

import java.util.List;

import Entidades.Veiculo;
import Entidades.Venda;

public interface serviceVendaInterface {
    void realizarVenda(Venda venda);
    List<Venda> listarVendas();
    Venda buscarVendaPorId(int id);
    void removerVenda(int id);
    void atualizarVenda(int id, Venda vendaAtualizada);
    Veiculo buscarVeiculoNaVenda(int vendaId, String placa);
}
