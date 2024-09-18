package IRepositorio;

import java.util.ArrayList;

import Entidades.Carro;

public interface repositorioCarroInterface {
    public void cadastrarCarro(Carro carro) throws Exception;
    public void removerCarro(Carro carro);
    public void atualizarCarro(Carro carro) throws Exception;
    ArrayList<Carro> verCarros();
    public Carro buscarCarroPorPlaca(String placa);

}
