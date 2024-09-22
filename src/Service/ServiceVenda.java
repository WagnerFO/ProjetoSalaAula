package Service;

import Entidades.Venda;
import IRepositorio.repositorioVendaInterface;
import IRepositorio.repositorioCaminhaoInterface;
import IRepositorio.repositorioCarroInterface;
import IRepositorio.repositorioMotoInterface;
import IService.serviceVendaInterface;
import Entidades.Caminhao;
import Entidades.Carro;
import Entidades.Moto;
import Entidades.Proprietario;
import Entidades.Veiculo;

import java.util.List;

public class ServiceVenda implements serviceVendaInterface{

    private repositorioVendaInterface vendaRepositorio;
    private repositorioCarroInterface carroRepositorio;
    private repositorioMotoInterface motoRepositorio;
    private repositorioCaminhaoInterface caminhaoRepositorio;

    public ServiceVenda (repositorioVendaInterface vendaRepositorio){
        this.vendaRepositorio=vendaRepositorio;
    }

    @Override
    public void venderCarro(String placa, Proprietario proprietario) throws Exception{
        Carro carro = carroRepositorio.buscarCarroPorPlaca(placa);
        if(carro!=null){
            throw new Exception("Carro não Encontrado! ");
        }
        Venda venda = new Venda(proprietario);
        venda.vendaVeiculo(carro);

        carroRepositorio.venderCarro(carro);

        realizarVenda(venda);
    }

    @Override
    public void venderMoto(String placa, Proprietario proprietario) throws Exception{
        Moto moto = motoRepositorio.buscarMotoPorPlaca(placa);
        if(moto!=null)
            throw new Exception("Moto não Encontrada! ");

        Venda venda = new Venda(proprietario);
        venda.vendaVeiculo(moto);

        motoRepositorio.venderMoto(moto);

        realizarVenda(venda);
    }

    @Override
    public void venderCaminhao(String placa, Proprietario proprietario) throws Exception{
        Caminhao caminhao = caminhaoRepositorio.buscarCaminhaoPorPlaca(placa);
        if(caminhao!=null)
            throw new Exception("Caminhão não Encontrado! ");
        
        Venda venda = new Venda(proprietario);
        venda.vendaVeiculo(caminhao);

        caminhaoRepositorio.venderCaminhao(caminhao);

        realizarVenda(venda);

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

    public void desfazerVendaCarro(int id, String placa)throws Exception{
        Carro carro = carroRepositorio.buscarCarroPorPlaca(placa);
        if(carro!=null)
            throw new Exception ("Carro não Encontrado!");

        Venda venda = vendaRepositorio.buscarVendaPorId(id);
        
        carroRepositorio.desfazerVendaCarro(carro);

        removerVenda(venda.getId());
    }

    public void desfazerVendaMoto(int id, String placa)throws Exception{
        Moto moto = motoRepositorio.buscarMotoPorPlaca(placa);
        if(moto!=null)
            throw new Exception ("Moto não Encontrado!");

        Venda venda = vendaRepositorio.buscarVendaPorId(id);
        
        motoRepositorio.desfazerVendaMoto(moto);

        removerVenda(venda.getId());
    }

    public void desfazerVendaCaminhao(int id, String placa)throws Exception{
        Caminhao caminhao = caminhaoRepositorio.buscarCaminhaoPorPlaca(placa);
        if(caminhao!=null)
            throw new Exception ("caminhao não Encontrado!");

        Venda venda = vendaRepositorio.buscarVendaPorId(id);
        
        caminhaoRepositorio.desfazerVendaCaminhao(caminhao);

        removerVenda(venda.getId());
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
                if (veiculo.getPlaca().equalsIgnoreCase(placa)) { 
                    return veiculo;
                }
            }
        }
        return null; 
    }

    
}