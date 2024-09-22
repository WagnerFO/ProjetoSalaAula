package Service;

import java.util.ArrayList;

import Entidades.Carro;
import IRepositorio.repositorioCarroInterface;
import IService.serviceCarroInterface;

public class ServiceCarro implements serviceCarroInterface{

	private repositorioCarroInterface carroRepositorio;
	public ServiceCarro(repositorioCarroInterface carroRepositorio) {
		this.carroRepositorio = carroRepositorio;
		System.out.println("RepositorioCarro inicializado: " + (this.carroRepositorio != null));
	}

		@Override
	public void cadastrarCarro(Carro carro) throws Exception {
		if(carro.getModelo() == null || carro.getModelo().trim().isBlank())
    		throw new Exception("Modelo do carro é OBRIGATÓRIO!");
		if(carro.getMarca() == null || carro.getMarca().trim().isEmpty())
			throw new Exception("Marca do carro é OBRIGATÓRIA!");
		if(carro.getCor() == null || carro.getCor().trim().isEmpty())
			throw new Exception("Cor do carro é OBRIGATÓRIA!");
		if(carro.getPlaca() == null || carro.getPlaca().trim().isEmpty())
			throw new Exception("Carro deve possuir uma placa!");

		carroRepositorio.cadastrarCarro(carro);
	}

	@Override
	public void removerCarro(Carro carro) {
		carroRepositorio.removerCarro(carro);
	}

	@Override
	public void alterarCarro(Carro carro) throws Exception {
		if(carro.getModelo() == null || carro.getModelo().trim().isBlank())
    		throw new Exception("Modelo do carro é OBRIGATÓRIO!");
		if(carro.getMarca() == null || carro.getMarca().trim().isEmpty())
			throw new Exception("Marca do carro é OBRIGATÓRIA!");
		if(carro.getCor() == null || carro.getCor().trim().isEmpty())
			throw new Exception("Cor do carro é OBRIGATÓRIA!");
		if(carro.getPlaca() == null || carro.getPlaca().trim().isEmpty())
			throw new Exception("Carro deve possuir uma placa!");
		carroRepositorio.atualizarCarro(carro);
	}

	@Override
	public Carro buscarCarro(String placa) {
		return carroRepositorio.buscarCarroPorPlaca(placa);
	}

	@Override
	public ArrayList<Carro> verCarrosDisp() {
		return carroRepositorio.verCarrosDisp();
	}

	@Override
	public ArrayList<Carro> verCarrosVend() {
		return carroRepositorio.verCarrosVend();
	}

    
}
