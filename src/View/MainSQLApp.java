package View;

import java.sql.SQLException;
import java.util.ArrayList;

import Entity.Caminhao;
import Entity.Carro;
import Entity.Moto;
import Entity.Proprietario;
import Entity.Veiculo;
import Entity.Enum.CaminhaoTipo;
import Entity.Enum.CarroTipo;
import Entity.Enum.MotoTipo;
import IRepositorio.IRepositorioCaminhaoSQL;
import IRepositorio.IRepositorioCarroSQL;
import IRepositorio.IRepositorioMotoSQL;
import IRepositorio.IRepositorioProprietarioSQL;
import Repositorio.RepositorioCaminhaoSQL;
import Repositorio.RepositorioCarroSQL;
import Repositorio.RepositorioMotoSQL;
import Repositorio.RepositorioProprietarioSQL;

public class MainSQLApp {
	
	private static IRepositorioCarroSQL repositorioCarroSql = new RepositorioCarroSQL();
	private static IRepositorioMotoSQL repositorioMotoSql = new RepositorioMotoSQL();
	private static IRepositorioCaminhaoSQL repositorioCaminhaoSql = new RepositorioCaminhaoSQL();
	private static IRepositorioProprietarioSQL repositorioProprietarioSql = new RepositorioProprietarioSQL();
	
	

	public static void main(String[] args) throws SQLException {
		
		// Adicionando 3 proprietários para o teste
        Proprietario proprietario1 = new Proprietario("João Silva", 30, "12345678900", "987654321", "Rua A");
        Proprietario proprietario2 = new Proprietario("Maria Souza", 28, "23456789001", "123456789", "Rua B");
        Proprietario proprietario3 = new Proprietario("Carlos Oliveira", 35, "34567890102", "456789123", "Rua C");
		
        // Criando 2 carros com novas placas
        Carro carro1 = new Carro("Volkswagen", "Fusca", "Azul", 1972, "ABC9876", 20000.0, 2, CarroTipo.HATCH);
        Carro carro2 = new Carro("Honda", "Civic", "Preto", 2020, "DEF4321", 95000.0, 4, CarroTipo.SPORT);


        // Criando 2 motos com novas placas
        Moto moto1 = new Moto("CB500", "Honda", "Vermelha", 2018, "GHI5678", 30000.0, 500, MotoTipo.SPORT);
        Moto moto2 = new Moto("Titan", "Honda", "Branca", 2015,  "JKL1234", 15000.0, 150, MotoTipo.URBANA);

        // Criando 2 caminhões com novas placas 
        Caminhao caminhao1 = new Caminhao("Mercedes Benz", "Atego", "Prata", 2021, "MNO8765", 200000.0, 12, CaminhaoTipo.TRUCK);
        Caminhao caminhao2 = new Caminhao("Volvo", "FH", "Preto", 2019, "PQR4321", 180000.0, 15, CaminhaoTipo.BITRUCK);


		repositorioCarroSql.salvar(carro1);
		repositorioCarroSql.salvar(carro2);
		System.out.println("Salvando Carro ...");
		repositorioCaminhaoSql.salvar(caminhao1);
		repositorioCaminhaoSql.salvar(caminhao2);
		System.out.println("Salvando Caminhão ...");
		repositorioMotoSql.salvar(moto1);
		repositorioMotoSql.salvar(moto2);
		System.out.println("Salvando Moto ...");
		
		proprietario1.adicionarVeiculo(carro1);
		proprietario1.adicionarVeiculo(caminhao2);
		
		
		proprietario2.adicionarVeiculo(carro2);
		proprietario2.adicionarVeiculo(moto1);
		
		proprietario3.adicionarVeiculo(moto2);
		proprietario3.adicionarVeiculo(caminhao1);
        
        repositorioProprietarioSql.cadastrarProp(proprietario1);
        repositorioProprietarioSql.cadastrarProp(proprietario2);
        repositorioProprietarioSql.cadastrarProp(proprietario3);
       
		
		
		
		System.out.println();
		Carro car1 = new Carro();
		car1.setPlaca("GHI9101");
		
		Moto mot1 = new Moto();
		moto1.setPlaca("DEF5678");
		
		
		Caminhao truck1 = new Caminhao();
		truck1.setPlaca("ABC1234");
		
		
		System.out.println("BUSCANDO CAMINHÃO");
		repositorioCaminhaoSql.buscarPorPlaca(truck1);
		
		
		System.out.println("BUSCANDO MOTO");
		repositorioMotoSql.buscarPorPlaca(mot1);
		

		System.out.println("BUSCANDO CARRO");
		repositorioCarroSql.buscarPorPlaca(car1);
		
		
		
		ArrayList<Proprietario> proprietarios = repositorioProprietarioSql.listarTodos();
        proprietarios.forEach(e -> System.out.println(e.getNome()));
		
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        System.out.println("\n");
        
        System.out.println("\nLISTANDO CAMINHÕES");
		ArrayList<Caminhao> caminhoes = repositorioCaminhaoSql.listarCaminhoesDisp();
		caminhoes.forEach(e -> System.out.println(e.getModelo()));
		
		
		
		System.out.println("LISTANDO MOTOS");
		ArrayList<Moto> motos = repositorioMotoSql.listarMotosDisp();
		motos.forEach(e -> System.out.println(e.getModelo()));
		
		
		
		System.out.println("LISTANDO CARROS");
		ArrayList<Carro> carros = repositorioCarroSql.listarCarrosDisp();
		carros.forEach(e -> System.out.println(e.getModelo()));
		
		
		
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		System.out.println(" ");
		
		
		System.out.println("LISTANDO POR PROPRIETARIOS ");
		try{
			ArrayList <Proprietario> listarProprietarios = repositorioProprietarioSql.listarTodosProprietario();
			if (listarProprietarios != null) {
				for(Proprietario donos : listarProprietarios) {
					System.out.println("\n"+"Proprietario: " + donos.getNome()+"\n");
					System.out.println("Lista de Veiculos de "+donos.getNome());
					for (Veiculo veiculo : donos.getVeiculos()) {
						System.out.println("Marca do Veiculo: "+veiculo.getMarca()+", "+veiculo.getModelo()+ ", Placa: " + veiculo.getPlaca());
						}
					}
				}else {
					System.out.println("Proprietario não encontrado.");
					}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		
		
		int i = 1;
		if( i == 2) {
		repositorioCaminhaoSql.remover(caminhao1);
		repositorioMotoSql.remover(moto1);
		repositorioCarroSql.remover(carro1);
		}
		
		}

	}

