package Service;

import java.util.ArrayList;

import Entidades.Caminhao;
import IRepositorio.repositorioCaminhaoInterface;
import IService.serviceCaminhaoInterface;


public class ServiceCaminhao implements serviceCaminhaoInterface{

    private repositorioCaminhaoInterface caminhaoRepositorio;
    public ServiceCaminhao (repositorioCaminhaoInterface caminhaoRepositorio){
        this.caminhaoRepositorio = caminhaoRepositorio;
    }


    @Override
    public void cadastrarCaminhao(Caminhao caminhao) throws Exception {
        if(caminhao.getModelo() == null || caminhao.getModelo().trim().isBlank()) {
            throw new Exception("Modelo do caminhão é OBRIGATÓRIO!");
        }
        if(caminhao.getMarca() == null || caminhao.getMarca().trim().isEmpty()) {
            throw new Exception("Marca do caminhão é OBRIGATÓRIA!");
        }
        if(caminhao.getCor() == null || caminhao.getCor().trim().isEmpty()) {
            throw new Exception ("Cor do caminhão é OBRIGATÓRIA!");
        }
        if(caminhao.getProprietario() == null) {
            throw new Exception ("Caminhão deve possuir um proprietário!");
        }
        caminhaoRepositorio.cadastrarCaminhao(caminhao);
    }

    @Override
    public void removerCaminhao(Caminhao caminhao) {
        caminhaoRepositorio.removerCaminhao(caminhao);
    }

    @Override
    public void alterarCaminhao(Caminhao caminhao) throws Exception {
        if(caminhao.getModelo() == null || caminhao.getModelo().trim().isBlank()) {
            throw new Exception("Modelo do caminhão é OBRIGATÓRIO!");
        }
        if(caminhao.getMarca() == null || caminhao.getMarca().trim().isEmpty()) {
            throw new Exception("Marca do caminhão é OBRIGATÓRIA!");
        }
        if(caminhao.getCor() == null || caminhao.getCor().trim().isEmpty()) {
            throw new Exception ("Cor do caminhão é OBRIGATÓRIA!");
        }
        if(caminhao.getProprietario() == null) {
            throw new Exception ("Caminhão deve possuir um proprietário!");
        }
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
