package View;

import java.util.Scanner;

import IRepositorio.repositorioCaminhaoInterface;
import IRepositorio.repositorioCarroInterface;
import IRepositorio.repositorioMotoInterface;
import IRepositorio.repositorioProprietarioInterface;
import IService.serviceCaminhaoInterface;
import IService.serviceCarroInterface;
import IService.serviceMotoInterface;
import IService.serviceProprietarioInterface;
import Repositorio.RepositorioCaminhao;
import Repositorio.RepositorioCarro;
import Repositorio.RepositorioMoto;
import Repositorio.RepositorioProprietario;
import Service.ServiceCaminhao;
import Service.ServiceCarro;
import Service.ServiceMoto;
import Service.ServiceProprietario;

public class MainApp {
    private static repositorioProprietarioInterface repositorioProprietario = new RepositorioProprietario();
    private static repositorioCarroInterface repositorioCarro = new RepositorioCarro();
    private static repositorioMotoInterface repositorioMoto = new RepositorioMoto();
    private static repositorioCaminhaoInterface repositorioCaminhao = new RepositorioCaminhao();

    private static serviceProprietarioInterface serviceProprietario = new ServiceProprietario(repositorioProprietario);
    private static serviceCarroInterface serviceCarro = new ServiceCarro(repositorioCarro);
    private static serviceMotoInterface serviceMoto = new ServiceMoto(repositorioMoto);
    private static serviceCaminhaoInterface serviceCaminhao = new ServiceCaminhao(repositorioCaminhao);
   
    
    private static Scanner scanner = new Scanner (System.in);
    
    public static void main(String[] args) throws Exception {
        
    }
}

//teste!