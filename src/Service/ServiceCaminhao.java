package Service;

import java.util.ArrayList;

import Entidades.Caminhao;
import Exception.validarCadastro;
import IRepositorio.repositorioCaminhaoInterface;
import IService.serviceCaminhaoInterface;


public class ServiceCaminhao implements serviceCaminhaoInterface{

    private repositorioCaminhaoInterface caminhaoRepositorio;
    public ServiceCaminhao (repositorioCaminhaoInterface caminhaoRepositorio){
        this.caminhaoRepositorio = caminhaoRepositorio;
    }


    @Override
    public void cadastrarCaminhao(Caminhao caminhao) throws Exception {
        validarCadastro.validarCaminhao(caminhao);
        caminhaoRepositorio.cadastrarCaminhao(caminhao);
    }

    @Override
    public void removerCaminhao(Caminhao caminhao) {
        caminhaoRepositorio.removerCaminhao(caminhao);
    }

    @Override
    public void alterarCaminhao(Caminhao caminhao) throws Exception {
        validarCadastro.validarCaminhao(caminhao);
        caminhaoRepositorio.atualizarCaminhao(caminhao);
    }

    @Override
    public Caminhao buscarCaminhao(String placa) {
        return caminhaoRepositorio.buscarCaminhaoPorPlaca(placa);
    }

    @Override
    public ArrayList<Caminhao> verCaminhoes() {
        return caminhaoRepositorio.verCaminhoes();
    }
    
}
