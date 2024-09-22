package Repositorio;

import java.util.ArrayList;

import Entidades.Caminhao;
import IRepositorio.repositorioCaminhaoInterface;

public class RepositorioCaminhao implements repositorioCaminhaoInterface {
    private ArrayList<Caminhao> caminhõesDisp = new ArrayList<>();
    private ArrayList<Caminhao> caminhõesVend = new ArrayList<>();

    @Override
    public void cadastrarCaminhao(Caminhao caminhao) {
        caminhõesDisp.add(caminhao);
    }

    @Override
    public void atualizarCaminhao(Caminhao caminhao) {
        Caminhao buscar = buscarCaminhaoPorPlaca(caminhao.getPlaca());
        if (buscar != null) {
            buscar.setModelo(caminhao.getModelo());
            buscar.setAno(caminhao.getAno());
            buscar.setPlaca(caminhao.getPlaca());
        }
    }

    @Override
    public void removerCaminhao(Caminhao caminhao) {
        caminhõesDisp.remove(caminhao);
    }

    @Override
    public ArrayList<Caminhao> verCaminhoesDisp() {
        return caminhõesDisp;
    }

    @Override
    public ArrayList<Caminhao> verCaminhoesVend() {
        return caminhõesVend;
    }

    @Override
    public Caminhao buscarCaminhaoPorPlaca(String placa) {
        for (Caminhao caminhao : caminhõesDisp) {
            if (caminhao.getPlaca().equals(placa)) {
                return caminhao;
            }
        }
        for (Caminhao caminhao : caminhõesVend) {
            if (caminhao.getPlaca().equals(placa)) {
                return caminhao;
            }
        }
        return null;
    }

    public void venderCaminhao(Caminhao caminhao) {
        removerCaminhao(caminhao);
        caminhõesVend.add(caminhao);
    }

    @Override
    public void desfazerVendaCaminhao(Caminhao caminhao) {
        caminhõesVend.remove(caminhao);
        cadastrarCaminhao(caminhao);
    }
}
