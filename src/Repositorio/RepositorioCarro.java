package Repositorio;

import java.util.ArrayList;

import Entidades.Carro;
import IRepositorio.repositorioCarroInterface;

public class RepositorioCarro implements repositorioCarroInterface{
    private ArrayList<Carro> carrosDisp = new ArrayList<>();
	private ArrayList<Carro> carrosVend = new ArrayList<>();
    
	@Override
	public void cadastrarCarro(Carro carro) {
		carrosDisp.add(carro);
	}

	@Override
	public void atualizarCarro(Carro carro) {
    	Carro buscar = buscarCarroPorPlaca(carro.getPlaca());
    	if(buscar != null) {
        	buscar.setModelo(carro.getModelo());
        	buscar.setAno(carro.getAno());
        	buscar.setPlaca(carro.getPlaca());
    	}
	}

	@Override
	public void removerCarro(Carro carro) {
		if(carrosDisp.remove(carro)){
			carrosVend.add(carro);
		}else{
			System.out.println("Carro não encontrado.");
		}		
	}

	@Override
	public ArrayList<Carro> verCarrosDisp() {
		return carrosDisp;
	}

	@Override
	public ArrayList<Carro> verCarrosVend() {
		return carrosVend;
	}
	

	@Override
	public Carro buscarCarroPorPlaca(String placa) {
		for(Carro carro : carrosDisp) {
			if(carro.getPlaca().equals(placa)) {
				System.out.println("O Carro com a placa "+placa+" está disponivel");
				return carro;
			}
		}
		for(Carro carro : carrosVend){
			if(carro.getPlaca().equals(placa)){
				System.out.println("O Carro com a placa "+placa+" já foi vendido");
				return carro;
			}
		}
		System.out.println("O Carro com a placa "+placa+" não foi encontrado!");
		return null;
	}

	

}
