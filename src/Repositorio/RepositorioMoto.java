package Repositorio;

import java.util.ArrayList;

import Entidades.Moto;
import Entidades.Proprietario;
import IRepositorio.repositorioMotoInterface;

public class RepositorioMoto implements repositorioMotoInterface{
    private ArrayList<Moto> motos = new ArrayList<>();
    
    
		@Override
	public void cadastrarMoto(Moto moto) {
		motos.add(moto);
	}

	public void cadastrarMoto(String marca, String modelo, String cor, int ano, String placa, Proprietario proprietario) {
		Moto moto = new Moto(marca, modelo, cor, ano, placa, proprietario);
		motos.add(moto);
	}

	@Override
	public void atualizarMoto(Moto moto) {
		Moto buscar = buscarMotoPorPlaca(moto.getPlaca());
		if(buscar != null) {
			buscar.setModelo(moto.getModelo());
			buscar.setAno(moto.getAno());
			buscar.setPlaca(moto.getPlaca());
		}
	}

	@Override
	public void removerMoto(Moto moto) {
		motos.remove(moto);
	}

	@Override
	public ArrayList<Moto> verMotos() {
		return motos;
	}

	@Override
	public Moto buscarMotoPorPlaca(String placa) {
		for(Moto moto : motos) {
			if(moto.getPlaca().equals(placa)) {
				return moto;
			}
		}
		return null;
	}


}
