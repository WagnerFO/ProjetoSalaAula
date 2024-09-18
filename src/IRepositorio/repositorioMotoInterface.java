package IRepositorio;

import java.util.ArrayList;

import Entidades.Moto;

public interface repositorioMotoInterface {
    public void cadastrarMoto(Moto moto) throws Exception;
    public void removerMoto(Moto moto);
    public void atualizarMoto(Moto moto) throws Exception;
    ArrayList<Moto> verMotos();
    public Moto buscarMotoPorPlaca(String placa);
}

