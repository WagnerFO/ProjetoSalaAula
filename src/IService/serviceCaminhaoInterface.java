package IService;

import java.util.ArrayList;
import Entidades.Caminhao;

public interface serviceCaminhaoInterface {

    public void cadastrarCaminhao(Caminhao caminhao) throws Exception;
    public void removerCaminhao(Caminhao caminhao);
    public void alterarCaminhao(Caminhao caminhao) throws Exception;
    ArrayList<Caminhao> verCaminhoesDisp();
    ArrayList<Caminhao> verCaminhoesVend();
    public Caminhao buscarCaminhao(String placa);
}
