package IRepositorio;

import java.util.List;

import Entity.Venda;

public interface repositorioVendaInterface {

    public void adicionarVenda(Venda venda);
    List<Venda> listarVendas();
    Venda buscarVendaPorId(int id);
    public void removerVenda(int id);
    public void atualizarVenda(int id, Venda vendaAtualizada);
}
