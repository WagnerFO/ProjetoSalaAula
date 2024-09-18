package IService;

import java.util.ArrayList;

import Entidades.Moto;

public interface serviceMotoInterface {

    public void cadastrarMoto(Moto moto) throws Exception;
    public void removerMoto(Moto moto);
    public void alterarMoto(Moto moto) throws Exception;
    ArrayList<Moto> verMotos();
    public Moto buscarMoto(String placa);
}
