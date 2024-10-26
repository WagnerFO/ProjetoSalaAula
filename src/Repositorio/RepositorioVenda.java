package Repositorio;

import java.util.ArrayList;

import Entity.Venda;
import IRepositorio.repositorioVendaInterface;

public class RepositorioVenda implements repositorioVendaInterface {
	
    private ArrayList<Venda> vendas = new ArrayList<>();

    @Override
    public void adicionarVenda(Venda venda) {
        vendas.add(venda);
    }

    @Override
    public void atualizarVenda(int id, Venda vendaAtualizada) {
        for (int i = 0; i < vendas.size(); i++) {
            if (vendas.get(i).getId() == id) {
                vendas.set(i, vendaAtualizada);
                break;
            }
        }
    }

    @Override
    public void removerVenda(int id) {
        vendas.removeIf(venda -> venda.getId() == id);
    }
    
    @Override
    public ArrayList<Venda> listarVendas() {
        return vendas;
    }

    @Override
    public Venda buscarVendaPorId(int id) {
        for (Venda venda : vendas) {
            if (venda.getId() == id) {
                return venda;
            }
        }
        return null; 
    }   
}