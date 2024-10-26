package IRepositorio;

import java.util.ArrayList;

import Entity.Carro;

public interface repositorioCarroInterface {
    public void cadastrarCarro(Carro carro) throws Exception;
    public void removerCarro(Carro carro);
    public void atualizarCarro(Carro carro) throws Exception;
    ArrayList<Carro> verCarrosDisp();
    ArrayList<Carro> verCarrosVend();
    public Carro buscarCarroPorPlaca(String placa);
    void venderCarro(Carro carro);
    void desfazerVendaCarro(Carro carro);
}
