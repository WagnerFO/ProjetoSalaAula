package IRepositorio;

import java.util.ArrayList;

import Entity.Caminhao;

public interface repositorioCaminhaoInterface {
    public void cadastrarCaminhao(Caminhao caminhao) throws Exception;
    public void removerCaminhao(Caminhao caminhao);
    public void atualizarCaminhao(Caminhao caminhao) throws Exception;
    ArrayList<Caminhao> verCaminhoesDisp();
    ArrayList<Caminhao> verCaminhoesVend();
    public Caminhao buscarCaminhaoPorPlaca(String placa);
    void venderCaminhao(Caminhao caminhao);
    void desfazerVendaCaminhao(Caminhao caminhao);
}
