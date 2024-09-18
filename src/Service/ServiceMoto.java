package Service;

import java.util.ArrayList;

import Entidades.Moto;
import Exception.validarCadastro;
import IRepositorio.repositorioMotoInterface;
import IService.serviceMotoInterface;

public class ServiceMoto implements serviceMotoInterface{

    private repositorioMotoInterface motoRepositorio;
    public ServiceMoto (repositorioMotoInterface motoRepositorio){
        this.motoRepositorio = motoRepositorio;
    }

    @Override
    public void cadastrarMoto(Moto moto) throws Exception {
        validarCadastro.validarMoto(moto);
        motoRepositorio.cadastrarMoto(moto);
    }

    @Override
    public void removerMoto(Moto moto) {
        motoRepositorio.removerMoto(moto);
    }

    @Override
    public void alterarMoto(Moto moto) throws Exception {
        validarCadastro.validarMoto(moto);
        motoRepositorio.atualizarMoto(moto);
    }

    @Override
    public Moto buscarMoto(String placa) {
        return motoRepositorio.buscarMotoPorPlaca(placa);
    }

    @Override
    public ArrayList<Moto> verMotos() {
        return motoRepositorio.verMotos();
    }
    
}
