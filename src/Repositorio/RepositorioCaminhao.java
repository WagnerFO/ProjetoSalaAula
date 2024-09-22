package Repositorio;

import java.util.ArrayList;
import Entidades.Caminhao;
import IRepositorio.repositorioCaminhaoInterface;

public class RepositorioCaminhao implements repositorioCaminhaoInterface {
    private ArrayList<Caminhao> caminhoesDisp = new ArrayList<>();
    private ArrayList<Caminhao> caminhoesVend = new ArrayList<>();

    @Override
    public void cadastrarCaminhao(Caminhao caminhao) {
        caminhoesDisp.add(caminhao);
    }

    @Override
    public void atualizarCaminhao(Caminhao caminhao) {
        Caminhao buscar = buscarCaminhaoPorPlaca(caminhao.getPlaca());
        if (buscar != null) {
            buscar.setModelo(caminhao.getModelo());
            buscar.setAno(caminhao.getAno());
            buscar.setPlaca(caminhao.getPlaca());
            buscar.setToneladasCarga(caminhao.getToneladasCarga());
        }
    }

    @Override
    public void removerCaminhao(Caminhao caminhao) {
        if (caminhoesDisp.remove(caminhao)) {
            caminhoesVend.add(caminhao);
        } else {
            System.out.println("Caminhão não encontrado.");
        }
    }

    @Override
    public ArrayList<Caminhao> verCaminhoesDisp() {
        return caminhoesDisp;
    }

    @Override
    public ArrayList<Caminhao> verCaminhoesVend() {
        return caminhoesVend;
    }

    @Override
    public Caminhao buscarCaminhaoPorPlaca(String placa) {
        for (Caminhao caminhao : caminhoesDisp) {
            if (caminhao.getPlaca().equals(placa)) {
                System.out.println("O Caminhão com a placa " + placa + " está disponível.");
                return caminhao;
            }
        }
        for (Caminhao caminhao : caminhoesVend) {
            if (caminhao.getPlaca().equals(placa)) {
                System.out.println("O Caminhão com a placa " + placa + " já foi vendido.");
                return caminhao;
            }
        }
        System.out.println("O Caminhão com a placa " + placa + " não foi encontrado!");
        return null;
    }

    @Override
    public void venderCaminhao(Caminhao caminhao) {
        removerCaminhao(caminhao);
        caminhoesVend.add(caminhao);
    }

    @Override
    public void desfazerVendaCaminhao(Caminhao caminhao){
        caminhoesVend.remove(caminhao);
        cadastrarCaminhao(caminhao);
    }
}
