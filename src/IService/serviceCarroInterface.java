package IService;

import java.util.ArrayList;

import Entidades.Carro;

public interface serviceCarroInterface {

    public void cadastrarCarro(Carro carro) throws Exception;
    public void removerCarro(Carro carro);
    public void alterarCarro(Carro carro) throws Exception;
    ArrayList<Carro> verCarrosDisp();
    ArrayList<Carro> verCarrosVend();
    public Carro buscarCarro(String placa);
}