package Repositorio;

import java.util.ArrayList;

import Entidades.Carro;
import Entidades.Proprietario;
import IRepositorio.repositorioCarroInterface;

public class RepositorioCarro implements repositorioCarroInterface{
    private ArrayList<Carro> carros = new ArrayList<>();
    
    
	@Override
	public void cadastrarCarro(Carro carro) {
		carros.add(carro);
		
	}
    
    public void cadastrarCarro(String marca, String modelo, String cor, int ano, String placa, Proprietario proprietario){
        Carro carro = new Carro (marca, modelo, cor, ano, placa, proprietario);
        carros.add(carro); 
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
		carros.remove(carro);
	}

	@Override
	public ArrayList<Carro> verCarros() {
		return carros;
	}

	@Override
	public Carro buscarCarroPorPlaca(String placa) {
		for(Carro carro : carros) {
			if(carro.getPlaca().equals(placa)) {
				return carro;
			}
		}
		return null;
	}

}
