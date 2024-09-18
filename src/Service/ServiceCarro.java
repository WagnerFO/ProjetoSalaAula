package Service;

import java.util.ArrayList;

import Entidades.Carro;
import Exception.validarCadastro;
import IRepositorio.repositorioCarroInterface;
import IService.serviceCarroInterface;

public class ServiceCarro implements serviceCarroInterface{

	private repositorioCarroInterface carroRepositorio;
	public ServiceCarro (repositorioCarroInterface carroRepositorio){
		this.carroRepositorio=carroRepositorio;
	}

		@Override
	public void cadastrarCarro(Carro carro) throws Exception {
		validarCadastro.validarCarro(carro);
		carroRepositorio.cadastrarCarro(carro);
	}

	@Override
	public void removerCarro(Carro carro) {
		carroRepositorio.removerCarro(carro);
	}

	@Override
	public void alterarCarro(Carro carro) throws Exception {
		validarCadastro.validarCarro(carro);
		carroRepositorio.atualizarCarro(carro);
	}

	@Override
	public Carro buscarCarro(String placa) {
		return carroRepositorio.buscarCarroPorPlaca(placa);
	}

	@Override
	public ArrayList<Carro> verCarros() {
		return carroRepositorio.verCarros();
	}


    
}
