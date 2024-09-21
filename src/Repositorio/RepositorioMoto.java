package Repositorio;

import java.util.ArrayList;
import Entidades.Moto;
import IRepositorio.repositorioMotoInterface;

public class RepositorioMoto implements repositorioMotoInterface {
    private ArrayList<Moto> motosDisp = new ArrayList<>();
    private ArrayList<Moto> motosVend = new ArrayList<>();

    @Override
    public void cadastrarMoto(Moto moto) {
        motosDisp.add(moto);
    }

    @Override
    public void atualizarMoto(Moto moto) {
        Moto buscar = buscarMotoPorPlaca(moto.getPlaca());
        if (buscar != null) {
            buscar.setModelo(moto.getModelo());
            buscar.setAno(moto.getAno());
            buscar.setPlaca(moto.getPlaca());
            buscar.setCilindradas(moto.getCilindradas());
        }
    }

    @Override
    public void removerMoto(Moto moto) {
        if (motosDisp.remove(moto)) {
            motosVend.add(moto);
        } else {
            System.out.println("Moto não encontrada.");
        }
    }

    @Override
    public ArrayList<Moto> verMotosDisp() {
        return motosDisp;
    }

    @Override
    public ArrayList<Moto> verMotosVend() {
        return motosVend;
    }

    @Override
    public Moto buscarMotoPorPlaca(String placa) {
        for (Moto moto : motosDisp) {
            if (moto.getPlaca().equals(placa)) {
                System.out.println("A Moto com a placa " + placa + " está disponível.");
                return moto;
            }
        }
        for (Moto moto : motosVend) {
            if (moto.getPlaca().equals(placa)) {
                System.out.println("A Moto com a placa " + placa + " já foi vendida.");
                return moto;
            }
        }
        System.out.println("A Moto com a placa " + placa + " não foi encontrada!");
        return null;
    }
}
