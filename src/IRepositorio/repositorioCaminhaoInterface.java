package IRepositorio;

import java.util.ArrayList;

import Entidades.Caminhao;

public interface repositorioCaminhaoInterface {
    public void cadastrarCaminhao(Caminhao caminhao) throws Exception;
    public void removerCaminhao(Caminhao caminhao);
    public void atualizarCaminhao(Caminhao caminhao) throws Exception;
    ArrayList<Caminhao> verCaminhoes();
    public Caminhao buscarCaminhaoPorPlaca(String placa);
}

