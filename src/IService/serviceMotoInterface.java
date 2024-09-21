package IService;

import java.util.ArrayList;
import Entidades.Moto;

public interface serviceMotoInterface {

    public void cadastrarMoto(Moto moto) throws Exception;
    public void removerMoto(Moto moto);
    public void alterarMoto(Moto moto) throws Exception;
    ArrayList<Moto> verMotosDisp();
    ArrayList<Moto> verMotosVend();
    public Moto buscarMoto(String placa);
}
