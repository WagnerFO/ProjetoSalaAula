package IService;

import java.util.List;

import Entity.Proprietario;
import Entity.Veiculo;
import Entity.Venda;

public interface serviceVendaInterface {
    
    void realizarVenda(Venda venda);
    void venderCarro(String placa, Proprietario proprietario) throws Exception;
    void venderMoto(String placa, Proprietario proprietario) throws Exception;
    void venderCaminhao(String placa, Proprietario proprietario) throws Exception;
    List<Venda> listarVendas();
    Venda buscarVendaPorId(int id);
    void removerVenda(int id);
    void atualizarVenda(int id, Venda vendaAtualizada);
    Veiculo buscarVeiculoNaVenda(int vendaId, String placa);

    
}
