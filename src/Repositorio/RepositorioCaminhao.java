package Repositorio;

import java.util.ArrayList;

import Entidades.Caminhao;
import Entidades.Proprietario;
import IRepositorio.repositorioCaminhaoInterface;


public class RepositorioCaminhao implements repositorioCaminhaoInterface{
    private ArrayList<Caminhao> caminhoes = new ArrayList<>();
    
    
		@Override
	public void cadastrarCaminhao(Caminhao caminhao) {
		caminhoes.add(caminhao);
	}

	public void cadastrarCaminhao(String marca, String modelo, String cor, int ano, String placa, Proprietario proprietario) {
		Caminhao caminhao = new Caminhao(marca, modelo, cor, ano, placa, proprietario);
		caminhoes.add(caminhao);
	}

	@Override
	public void atualizarCaminhao(Caminhao caminhao) {
		Caminhao buscar = buscarCaminhaoPorPlaca(caminhao.getPlaca());
		if(buscar != null) {
			buscar.setModelo(caminhao.getModelo());
			buscar.setAno(caminhao.getAno());
			buscar.setPlaca(caminhao.getPlaca());
		}
	}

	@Override
	public void removerCaminhao(Caminhao caminhao) {
		caminhoes.remove(caminhao);
	}

	@Override
	public ArrayList<Caminhao> verCaminhoes() {
		return caminhoes;
	}

	@Override
	public Caminhao buscarCaminhaoPorPlaca(String placa) {
		for(Caminhao caminhao : caminhoes) {
			if(caminhao.getPlaca().equals(placa)) {
				return caminhao;
			}
		}
		return null;
	}


}
