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
		carrosDisp.remove(carro);
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
				return carro;
			}
		}
		for(Carro carro : carrosVend){		
			if(carro.getPlaca().equals(placa)){
				return carro;
			} 
		}
		return null;
	}

	
	public void venderCarro(Carro carro) {
		removerCarro(carro);
		carrosVend.add(carro);
	}

	@Override
	public void desfazerVendaCarro(Carro carro){
		carrosVend.remove(carro);
		cadastrarCarro(carro);
	}
	
}
