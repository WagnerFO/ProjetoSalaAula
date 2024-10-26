package Service;

import java.util.ArrayList;

import Entity.Moto;
import IRepositorio.repositorioMotoInterface;
import IService.serviceMotoInterface;

public class ServiceMoto implements serviceMotoInterface {

    private repositorioMotoInterface motoRepositorio;

    public ServiceMoto(repositorioMotoInterface motoRepositorio) {
        this.motoRepositorio = motoRepositorio;
    }

    @Override
    public void cadastrarMoto(Moto moto) throws Exception {
        if (moto.getModelo() == null || moto.getModelo().trim().isBlank())
            throw new Exception("Modelo da moto é OBRIGATÓRIO!");
        if (moto.getMarca() == null || moto.getMarca().trim().isEmpty())
            throw new Exception("Marca da moto é OBRIGATÓRIA!");
        if (moto.getCor() == null || moto.getCor().trim().isEmpty())
            throw new Exception("Cor da moto é OBRIGATÓRIA!");
        if (moto.getPlaca() == null || moto.getPlaca().trim().isEmpty())
            throw new Exception("Moto deve possuir uma placa!");

        motoRepositorio.cadastrarMoto(moto);
    }

    @Override
    public void removerMoto(Moto moto) {
        motoRepositorio.removerMoto(moto);
    }

    @Override
    public void alterarMoto(Moto moto) throws Exception {
        if (moto.getModelo() == null || moto.getModelo().trim().isBlank())
            throw new Exception("Modelo da moto é OBRIGATÓRIO!");
        if (moto.getMarca() == null || moto.getMarca().trim().isEmpty())
            throw new Exception("Marca da moto é OBRIGATÓRIA!");
        if (moto.getCor() == null || moto.getCor().trim().isEmpty())
            throw new Exception("Cor da moto é OBRIGATÓRIA!");
        if (moto.getPlaca() == null || moto.getPlaca().trim().isEmpty())
            throw new Exception("Moto deve possuir uma placa!");

        motoRepositorio.atualizarMoto(moto);
    }

    @Override
    public Moto buscarMoto(String placa) {
        return motoRepositorio.buscarMotoPorPlaca(placa);
    }

    @Override
    public ArrayList<Moto> verMotosDisp() {
        return motoRepositorio.verMotosDisp();
    }

    @Override
    public ArrayList<Moto> verMotosVend() {
        return motoRepositorio.verMotosVend();
    }
}

