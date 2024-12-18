package IRepositorio;

import java.util.ArrayList;

import Entity.Moto;

public interface repositorioMotoInterface {
    public void cadastrarMoto(Moto moto) throws Exception;
    public void removerMoto(Moto moto);
    public void atualizarMoto(Moto moto) throws Exception;
    ArrayList<Moto> verMotosDisp();
    ArrayList<Moto> verMotosVend();
    public Moto buscarMotoPorPlaca(String placa);
    void venderMoto(Moto moto);
    void desfazerVendaMoto(Moto moto);
}
