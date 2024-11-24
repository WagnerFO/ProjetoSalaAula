package View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

import Entity.*;
import Entity.Enum.*;
import Exceptions.*;
import IRepositorio.*;
import IService.*;
import Repositorio.*;
import Service.*;

public class MainApp {
    private static repositorioProprietarioInterface repositorioProprietario = new RepositorioProprietario();
    private static repositorioCarroInterface repositorioCarro = new RepositorioCarro();
    private static repositorioMotoInterface repositorioMoto = new RepositorioMoto();
    private static repositorioCaminhaoInterface repositorioCaminhao = new RepositorioCaminhao();
    private static IRepositorioProprietarioSQL proprietarioSQL = new  RepositorioProprietarioSQL();
    private static IRepositorioCarroSQL carroSql = new RepositorioCarroSQL();
    private static IRepositorioMotoSQL motoSql = new RepositorioMotoSQL();
    private static IRepositorioCaminhaoSQL caminhaoSql = new RepositorioCaminhaoSQL();

    private static serviceProprietarioInterface serviceProprietario = new ServiceProprietario(repositorioProprietario);
    private static serviceProprietarioInterface serviceProprietarioSQL = new ServiceProprietario(proprietarioSQL);
    private static serviceCarroInterface serviceCarro = new ServiceCarro(repositorioCarro);
    private static serviceMotoInterface serviceMoto = new ServiceMoto(repositorioMoto);
    private static serviceCaminhaoInterface serviceCaminhao = new ServiceCaminhao(repositorioCaminhao);
    private static Scanner scanner = new Scanner (System.in);
    
    public static void main(String[] args) throws Exception {

        Proprietario proprietario = new Proprietario("Maria Silva", 28, "987", "11987654321", "Rua B, 45");

        Caminhao caminhão = new Caminhao("Mercedes", "Actros", "Branco", 2022, "ABC1234", 250000.0, 15, CaminhaoTipo.TRUCK); 
        
        Carro carro = new Carro("Fiat", "Palio", "Preto", 2020, "XYZ1234", 50000.0, 4, CarroTipo.SEDAN);
        Moto moto = new Moto("Honda", "CBR", "Vermelha", 2021, "ABC5678", 30000.0, 600, MotoTipo.URBANA);
       
        serviceProprietario.cadastrarProprietario(proprietario);
        serviceCarro.cadastrarCarro(carro);
        serviceMoto.cadastrarMoto(moto);
        serviceCaminhao.cadastrarCaminhao(caminhão);

        boolean sairMP = false;
        while (!sairMP) {
        exibirMenuPrincipal();
        int opcaoMP = scanner.nextInt();
        scanner.nextLine(); 
        switch (opcaoMP) {
            case 1:
            boolean sairMV = false;
            while (!sairMV) {
            exibirMenuVeiculo();
            int opcaoMV = scanner.nextInt();
            scanner.nextLine(); 
            switch (opcaoMV) {
                case 1:
                    boolean sairCarro = false;
                    while (!sairCarro) {
                        exibirMenuCarro();
                        int opcaoCarro = scanner.nextInt();
                        scanner.nextLine(); 
                        switch (opcaoCarro) {
                            case 1:
                                cadastrarCarro();
                                System.out.println("");
                                break;
                            case 2:
                                removerCarro();
                                System.out.println("");
                                break;
                            case 3:
                                atualizarCarro();
                                System.out.println("");
                                break;
                            case 4:
                                buscarCarro();
                                System.out.println("");
                                break;
                            case 5: 
                                ListarCarros();
                                System.out.println("");
                                break;
                            case 0:
                                sairCarro=true;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente Novamente.");
                                break;
                            }
                        }
                    break;
                case 2:
                    boolean sairMoto = false;
                    while (!sairMoto) {
                        exibirMenuMoto();
                        int opcaoMoto = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcaoMoto) {
                            case 1:
                                cadastrarMoto();
                                System.out.println("");
                                break;
                            case 2:
                                removerMoto();
                                System.out.println("");
                                break;
                            case 3:
                                atualizarMoto();
                                System.out.println("");
                                break;
                            case 4:
                                buscarMoto();
                                System.out.println("");
                                break;
                            case 5:
                                listarMotos();
                                System.out.println("");
                                break;
                            case 0:
                                sairMoto = true;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente Novamente.");
                                break;
                            }
                        }
                    break;
                case 3:
                    boolean sairCaminhao = false;
                    while (!sairCaminhao) {
                        exibirMenuCaminhao();
                        int opcaoCaminhao = scanner.nextInt();
                        scanner.nextLine();
                        switch (opcaoCaminhao) {
                            case 1:
                                cadastrarCaminhao();
                                System.out.println("");
                                break;
                            case 2:
                                removerCaminhao();
                                System.out.println("");
                                break;
                            case 3:
                                atualizarCaminhao();
                                System.out.println("");
                                break;
                            case 4:
                                buscarCaminhao();
                                System.out.println("");
                                break;
                            case 5:
                                listarCaminhoesDisponiveis();
                                System.out.println("");
                                break;
                            case 0:
                                sairCaminhao = true;
                                break;
                            default:
                                System.out.println("Opção inválida! Tente Novamente.");
                                break;
                            }
                        }
                    break;
                case 0: 
            	    sairMV=true;
            	    break;
                default:
            	    System.out.println("Opção inválida! Tente Novamente.");
            	    break;
                }
            }
            break;
            case 2:
                boolean sairMProprietario = false;
                while (!sairMProprietario) {
                    exibirMenuProprietarios();
                    int opcaoMProprietario = scanner.nextInt();
                    scanner.nextLine(); 
                    switch (opcaoMProprietario) {
                        case 1:
                        cadastrarProprietario();
                        System.out.println("");
                        break;
                    case 2:
                        removerProprietario();
                        System.out.println("");
                        break;
                    case 3:
                        atualizarProprietario();
                        System.out.println("");
                        break;
                    case 4:
                        buscarProprietario();
                        System.out.println("");
                        break;
                    case 5:
                        listarProprietarios();
                        System.out.println("");
                        break;
                    case 0:
                        sairMProprietario = true;
                        System.out.println("");
                        break;
                    default:
                        System.out.println("Opção inválida! Tente Novamente.");
                        break;
                }
            }
            break;
            case 3:
            boolean sairVenda = false;
            while (!sairVenda) {
                exibirMenuVendas();
                int opcaoVenda = scanner.nextInt();
                scanner.nextLine();
                switch (opcaoVenda) {
                    case 1:
                        boolean sairVendaVeiculos = false;
                        while (!sairVendaVeiculos) {
                        exibirMenuVendaVeiculos();
                        int opcaoVendaVeiculos = scanner.nextInt();
                        scanner.nextLine();    
                        switch (opcaoVendaVeiculos) {
                            case 1:
                                realizarVendaCarro();
                                System.out.println("");
                                break;
                            case 2:
                                realizarVendaMoto();
                                System.out.println("");
                                break;
                            case 3:
                                realizarVendaCaminhao();
                                System.out.println("");
                                break;
                            case 0:
                                sairVendaVeiculos=true;
                                System.out.println("");
                                break;
                            default:
                                System.out.println("Opção inválida! Tente Novamente.");
                                break;
                            }
                        }
                        System.out.println("");
                        break;                  
                    case 2:
                        removerVenda();
                        System.out.println("");
                        break;
                    case 3:
                        atualizarVenda();
                        System.out.println("");
                        break;
                    case 4:
                        buscarVenda();
                        System.out.println("");
                        break;
                    case 5:
                        listarVendas();
                        System.out.println("");
                        break;
                    case 0:
                        sairVenda = true;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente Novamente.");
                        break;
                }
            }
            break;
            case 0:
                        sairMP = true;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente Novamente.");
                        break;

            }
        }
    }


    private static void exibirMenuPrincipal() {
        System.out.println("\n### APLICAÇÃO DE CADASTRO DE VEICULOS ###");
        System.out.println("");
        System.out.println("1. MENU - Veiculos");
        System.out.println("2. MENU - Clientes");
        System.out.println("3. MENU - Vendas ");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção: ");
    }

    
    public static void exibirMenuVeiculo(){
        System.out.println("\n### MENU-VEICULOS ###");
        System.out.println("");
        System.out.println("Selecione o tipo do veiculo: ");
        System.out.println("1. Carros ");
        System.out.println("2. Motos ");
        System.out.println("3. Caminhões ");
        System.out.println("0. Voltar"+"\n");
    }

    
    public static void exibirMenuCarro(){
        System.out.println("\n### MENU-CARROS ###");
        System.out.println("");
        System.out.println("1. Adicionar Carro");
        System.out.println("2. Remover Carro");
        System.out.println("3. Atualizar Carro");
        System.out.println("4. Buscar Carro");
        System.out.println("5. Listar Carros");
        System.out.println("0. Voltar"+"\n");
    }

    
    public static void cadastrarCarro() throws Exception{
        Carro carro = new Carro();
        System.out.println("\n"+"Cadastrando Novo Carro no Sistema: "+"\n");
        System.out.println("Marca: ");
        carro.setMarca(scanner.nextLine());
        System.out.println("Modelo: ");
        carro.setModelo(scanner.nextLine());
        System.out.println("Cor: ");
        carro.setCor(scanner.nextLine());
        System.out.println("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());
        carro.setAno(ano);
        System.out.println("Placa: ");
        carro.setPlaca(scanner.nextLine());
        System.out.println("Valor do Carro: ");
        double valor = Double.parseDouble(scanner.nextLine());
        carro.setValorVenda(valor);
        System.out.println("Quantidade de Portas: ");
        int porta = Integer.parseInt(scanner.nextLine());
        carro.setQuantPortas(porta);

        CarroTipo tipo = null;
        boolean tipoValido = false;

        while (!tipoValido) {
            System.out.println("Qual Tipo do Carro: Hatch / Sedan / SUV / Sport: ");
            String tipoCarro = scanner.nextLine().trim().toUpperCase();  // .toUpperCase() para garantir correspondência

            try {
                tipo = CarroTipo.valueOf(tipoCarro);  // Tenta converter a string para o enum
                tipoValido = true;  // Se o valor for válido, sai do loop
            } catch (IllegalArgumentException e) {
                // Caso o tipo fornecido não seja válido, informa o usuário e repete o loop
                System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Hatch, Sedan, SUV, Sport).");
            }
        }

        carro.setTipo(tipo);  // Atribui o tipo de carro ao objeto

        
        try{
            carroSql.salvar(carro);
            System.out.println("Carro Adicionado com Sucesso! ");
            
        }catch(Exception e){
            System.out.println("Erro ao Adicionar carro! "+e.getMessage());
        }
    }

    public static void removerCarro() {
        System.out.println("\nDigite a Placa do Carro que Deseja Remover:");
        String placaDel = scanner.nextLine();
        Carro carro1 = new Carro();
        carro1.setPlaca(placaDel);
        try {
            Carro deletarCarro = carroSql.buscarPorPlaca(carro1);
            if (deletarCarro == null) {
                throw new CarroNaoEncontradoException("O carro com a placa " + placaDel + " não foi encontrado");
            }
            carroSql.remover(deletarCarro);
            System.out.println("\nCarro removido com sucesso!");
        } catch (CarroNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    public static void atualizarCarro() throws Exception {
        // Solicitando a placa do carro para atualização
        System.out.println("Digite a Placa do Veículo que você deseja Atualizar");
        String placa = scanner.nextLine();

        // Criando um objeto carro para buscar no banco
        Carro carro = new Carro();
        carro.setPlaca(placa);

        try {
            // Buscando o carro a partir da placa no banco de dados
            Carro carroMudar = carroSql.buscarPorPlaca(carro); // Método que deve buscar o carro no banco
            if (carroMudar == null) {
                throw new CarroNaoEncontradoException("\nO Carro com a placa " + placa + " não foi encontrado.");
            }

            // Exibindo as opções para o usuário atualizar os campos
            System.out.println("Digite a Nova Marca: ");
            String marca = scanner.nextLine();
            System.out.println("Digite o Novo Modelo: ");
            String modelo = scanner.nextLine();
            System.out.println("Digite a Nova Cor: ");
            String cor = scanner.nextLine();
            System.out.println("Digite o Novo Ano: ");
            int ano = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite o Novo Valor: ");
            double valor = Double.parseDouble(scanner.nextLine());
            System.out.println("Digite a Quantidade de Portas: ");
            int qntPorta = Integer.parseInt(scanner.nextLine());

            // Escolhendo o tipo de carro
            CarroTipo tipo = null;
            boolean tipoValido = false;
            while (!tipoValido) {
                System.out.println("Qual Tipo do Carro: Hatch / Sedan / SUV / Sport: ");
                String tipoCarro = scanner.nextLine().toLowerCase();
                try {
                    tipo = CarroTipo.valueOf(tipoCarro.toUpperCase());  // Convertendo para maiúsculas, pois os tipos são definidos dessa forma
                    tipoValido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Hatch, Sedan, SUV, Sport). ");
                }
            }

            // Atualizando os valores no objeto carro
            carroMudar.setMarca(marca);
            carroMudar.setModelo(modelo);
            carroMudar.setCor(cor);
            carroMudar.setAno(ano);

            carroMudar.setValorVenda(valor);
            carroMudar.setQuantPortas(qntPorta);
            carroMudar.setTipo(tipo);

            // Atualizando o carro no banco de dados usando carroSql
            carroSql.atualizar(carroMudar);  // Método de atualização diretamente no carroSql

            // Mensagem de sucesso
            System.out.println("\nCarro Alterado com Sucesso.");

        } catch (CarroNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um Erro Inesperado: " + e.getMessage());
        }
    }

    public static void buscarCarro() {
        System.out.println("Digite a Placa do Veiculo que você deseja Buscar: ");
        String placa = scanner.nextLine();
        Carro carro = new Carro();
        carro.setPlaca(placa);
        try{
            Carro encontarCarro = carroSql.buscarPorPlaca(carro);

            if(encontarCarro == null){
                throw new CarroNaoEncontradoException("O carro com a placa "+placa+" não foi encontrado");
            }

        }catch(CarroNaoEncontradoException e){
            System.out.println("Erro: "+e.getMessage());
        }catch(Exception e){
            System.out.println("Ocorreu um Erro Inexperado "+e.getMessage());
        }
    }

    public static void ListarCarros(){
        ArrayList<Carro> carros = carroSql.listarCarros();  
        if(carros.isEmpty()){
            System.out.println("\n"+"Nenhum Carro Disponivel para Venda.");
        }else{
            for(Carro c : carros){
                System.out.println(c);
            }
        }
    }
    
    
    public static void exibirMenuMoto() {
        System.out.println("\n### MENU-MOTOS ###");
        System.out.println("");
        System.out.println("1. Adicionar Moto");
        System.out.println("2. Remover Moto");
        System.out.println("3. Atualizar Moto");
        System.out.println("4. Buscar Moto");
        System.out.println("5. Listar Motos");
        System.out.println("0. Voltar" + "\n");
    }
    
    
    public static void cadastrarMoto() throws Exception {
        Moto moto = new Moto();
        System.out.println("\nCadastrando Nova Moto no Sistema: " + "\n");
        System.out.println("Marca: ");
        moto.setMarca(scanner.nextLine());
        System.out.println("Modelo: ");
        moto.setModelo(scanner.nextLine());
        System.out.println("Cor: ");
        moto.setCor(scanner.nextLine());
        System.out.println("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());
        moto.setAno(ano);
        System.out.println("Placa: ");
        moto.setPlaca(scanner.nextLine());
        System.out.println("Valor da Moto: ");
        double valor = Double.parseDouble(scanner.nextLine());
        moto.setValorVenda(valor);
        System.out.println("Digite as Cilindradas: ");
        int cilindradas = Integer.parseInt(scanner.nextLine());
        moto.setCilindradas(cilindradas);
        
        MotoTipo tipo = null;
        boolean tipoValido = false;
        while (!tipoValido) {
            System.out.println("Qual Tipo da Moto: Trilha / Urbana / Sport: ");
            String tipoMoto = scanner.nextLine().toLowerCase();

            try {
                tipo = MotoTipo.valueOf(tipoMoto.toUpperCase());
                tipoValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Trilha, Urbana, Sport).");
            }
        }
        
        moto.setTipo(tipo);
    
        try {
            motoSql.salvar(moto);
            System.out.println("Moto Adicionada com Sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao Adicionar moto! " + e.getMessage());
        }
    }
    
    public static void removerMoto() {
        System.out.println("\nDigite a Placa da Moto que Deseja Remover:");
        String placaDel = scanner.nextLine();
        Moto moto1 =new Moto();
        moto1.setPlaca(placaDel);
        try {
            Moto deletarMoto = motoSql.buscarPorPlaca(moto1);
            if (deletarMoto == null) {
                throw new MotoNaoEncontradaException("A moto com a placa " + placaDel + " não foi encontrada");
            }
            motoSql.remover(deletarMoto);
            System.out.println("\nMoto removida com sucesso!");
        } catch (MotoNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
    
    public static void atualizarMoto() throws Exception {

        System.out.println("Digite a Placa da Moto que você deseja Atualizar");
        String placa = scanner.nextLine();

        // Criando um objeto moto para buscar no banco
        Moto moto = new Moto();
        moto.setPlaca(placa);

        try {
            // Buscando a moto a partir da placa no banco de dados
            Moto motoMudar = motoSql.buscarPorPlaca(moto); // Método que deve buscar a moto no banco
            if (motoMudar == null) {
                throw new MotoNaoEncontradaException("\nA Moto com a placa " + placa + " não foi encontrada.");
            }

            // Solicitando os novos dados ao usuário
            System.out.println("Digite a Nova Marca: ");
            String marca = scanner.nextLine();
            System.out.println("Digite o Novo Modelo: ");
            String modelo = scanner.nextLine();
            System.out.println("Digite a Nova Cor: ");
            String cor = scanner.nextLine();
            System.out.println("Digite o Novo Ano: ");
            int ano = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite o Novo Valor: ");
            double valor = Double.parseDouble(scanner.nextLine());
            System.out.println("Digite as Cilindradas: ");
            int cilindradas = Integer.parseInt(scanner.nextLine());

            // Escolhendo o novo tipo da moto
            MotoTipo tipo = null;
            boolean tipoValido = false;
            while (!tipoValido) {
                System.out.println("Qual Tipo da Moto: Trilha / Urbana / Sport: ");
                String tipoMoto = scanner.nextLine().trim().toLowerCase();

                try {
                    tipo = MotoTipo.valueOf(tipoMoto.toUpperCase());
                    tipoValido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Trilha, Urbana, Sport).");
                }
            }

            // Atualizando os valores da moto
            motoMudar.setMarca(marca);
            motoMudar.setModelo(modelo);
            motoMudar.setCor(cor);
            motoMudar.setAno(ano);
            motoMudar.setValorVenda(valor);
            motoMudar.setCilindradas(cilindradas);
            motoMudar.setTipo(tipo);

            // Atualizando no banco
            motoSql.atualizar(motoMudar);
            System.out.println("\nMoto Alterada com Sucesso.");

        } catch (MotoNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um Erro Inesperado: " + e.getMessage());
            e.printStackTrace(); // Diagnóstico adicional durante desenvolvimento
        }
    }
    
    public static void buscarMoto() {
        System.out.println("Digite a Placa da Moto que você deseja Buscar: ");
        String placa = scanner.nextLine();
        Moto moto = new Moto();
        moto.setPlaca(placa);
    
        try {
            Moto encontrarMoto = motoSql.buscarPorPlaca(moto);
    
            if (encontrarMoto == null) {
                throw new MotoNaoEncontradaException("A moto com a placa " + placa + " não foi encontrada");
            }
        } catch (MotoNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um Erro Inesperado: " + e.getMessage());
        }
    }
        
    public static void listarMotos() {
        ArrayList<Moto> motos = motoSql.listarMotos();
        if (motos.isEmpty()) {
            System.out.println("\nNenhuma Moto Disponível para Venda.");
        } else {
            for (Moto m : motos) {
                System.out.println(m);
            }
        }
    }
    
    
    public static void exibirMenuCaminhao() {
        System.out.println("\n### MENU-CAMINHÕES ###");
        System.out.println("");
        System.out.println("1. Adicionar Caminhão");
        System.out.println("2. Remover Caminhão");
        System.out.println("3. Atualizar Caminhão");
        System.out.println("4. Buscar Caminhão");
        System.out.println("5. Listar Caminhões");
        System.out.println("0. Voltar" + "\n");
    }
    
    
    public static void cadastrarCaminhao() throws Exception {
        Caminhao caminhao = new Caminhao();
        System.out.println("\nCadastrando Novo Caminhão no Sistema: " + "\n");
        System.out.println("Marca: ");
        caminhao.setMarca(scanner.nextLine());
        System.out.println("Modelo: ");
        caminhao.setModelo(scanner.nextLine());
        System.out.println("Cor: ");
        caminhao.setCor(scanner.nextLine());
        System.out.println("Ano: ");
        int ano = Integer.parseInt(scanner.nextLine());
        caminhao.setAno(ano);
        System.out.println("Placa: ");
        caminhao.setPlaca(scanner.nextLine());
        System.out.println("Valor do Caminhão: ");
        double valor = Double.parseDouble(scanner.nextLine());
        caminhao.setValorVenda(valor);
        System.out.println("Capacidade de Carga (em toneladas): ");
        double carga = Double.parseDouble(scanner.nextLine());
        caminhao.setToneladasCarga(carga);
        
        CaminhaoTipo tipo = null;
        boolean tipoValido = false;
        while(!tipoValido) {
        	System.out.println("Qual tipo do Caminhão: TRUCK / BITRUCK / CARRETA: ");
        	String tipoCaminhao = scanner.nextLine().toLowerCase();
        	
        	try {
        		tipo = CaminhaoTipo.valueOf(tipoCaminhao.toUpperCase());
        		tipoValido = true;
        	}catch(IllegalArgumentException e) {
        		System.out.println("Tipo Inválido, Por vaor insira um tipo válido: TRUCK / BITRUCK / CARRETA");
        	}
        }
        caminhao.setTipo(tipo);
        
    
        try {
            caminhaoSql.salvar(caminhao);
            System.out.println("Caminhão Adicionado com Sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao Adicionar caminhão! " + e.getMessage());
        }
    }
    
    public static void removerCaminhao() {
        System.out.println("\nDigite a Placa do Caminhão que Deseja Remover:");
        String placaDel = scanner.nextLine();
        Caminhao caminhao = new Caminhao();
        caminhao.setPlaca(placaDel);
        try {
            Caminhao deletarCaminhao = caminhaoSql.buscarPorPlaca(caminhao);
            if (deletarCaminhao == null) {
                throw new CaminhaoNaoEncontradoException("O caminhão com a placa " + placaDel + " não foi encontrado");
            }
            caminhaoSql.remover(deletarCaminhao);
            System.out.println("\nCaminhão removido com sucesso!");
        } catch (CaminhaoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
    
    public static void atualizarCaminhao() throws Exception {
        System.out.println("Digite a Placa do Caminhão que você deseja Atualizar");
        String placa = scanner.nextLine();
        Caminhao caminhao = new Caminhao();
        caminhao.setPlaca(placa);
        try {
            Caminhao caminhaoMudar = caminhaoSql.buscarPorPlaca(caminhao);
            if (caminhaoMudar == null) {
                throw new CaminhaoNaoEncontradoException("\nO Caminhão com a placa " + placa + " não foi encontrado.");
            }
    
            System.out.println("Digite a Nova Marca: ");
            String marca = scanner.nextLine();
            System.out.println("Digite o Novo Modelo: ");
            String modelo = scanner.nextLine();
            System.out.println("Digite a Nova Cor: ");
            String cor = scanner.nextLine();
            System.out.println("Digite o Novo Ano: ");
            int ano = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite o Novo Valor: ");
            double valor = Double.parseDouble(scanner.nextLine());
            System.out.println("Digite a Tonelagem de Carga: ");
            double toneladasCarga = Double.parseDouble(scanner.nextLine());
    
            CaminhaoTipo tipo = null;
            boolean tipoValido = false;
            while(!tipoValido) {
            	System.out.println("Qual tipo do Caminhão: TRUCK / BITRUCK / CARRETA: ");
            	String tipoCaminhao = scanner.nextLine().toLowerCase();
            	
            	try {
            		tipo = CaminhaoTipo.valueOf(tipoCaminhao.toUpperCase());
            		tipoValido = true;
            	}catch(IllegalArgumentException e) {
            		System.out.println("Tipo Inválido, Por vaor insira um tipo válido: TRUCK / BITRUCK / CARRETA");
            	}
            }
    
            caminhaoMudar.setMarca(marca);
            caminhaoMudar.setModelo(modelo);
            caminhaoMudar.setCor(cor);
            caminhaoMudar.setAno(ano);
            caminhaoMudar.setValorVenda(valor);
            caminhaoMudar.setToneladasCarga(toneladasCarga);
            caminhaoMudar.setTipo(tipo);
    
            caminhaoSql.atualizar(caminhaoMudar);
            System.out.println("\nCaminhão Alterado com Sucesso.");
        } catch (CaminhaoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um Erro Inesperado: " + e.getMessage());
        }
    }
    
    public static void buscarCaminhao() {
        System.out.println("Digite a Placa do Caminhão que você deseja Buscar: ");
        String placa = scanner.nextLine();
        Caminhao caminhao = new Caminhao();
        caminhao.setPlaca(placa);
    
        try {
            Caminhao encontrarCaminhao = caminhaoSql.buscarPorPlaca(caminhao);
    
            if (encontrarCaminhao == null) {
                throw new CaminhaoNaoEncontradoException("O caminhão com a placa " + placa + " não foi encontrado");
            }
        } catch (CaminhaoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um Erro Inesperado: " + e.getMessage());
        }
    }
        
    public static void listarCaminhoesDisponiveis() {
        ArrayList<Caminhao> caminhoes = caminhaoSql.listarCaminhoes();
        if (caminhoes.isEmpty()) {
            System.out.println("\nNenhum Caminhão Disponível para Venda.");
        } else {
            for (Caminhao c : caminhoes) {
                System.out.println(c);
            }
        }
    }
    

    public static void exibirMenuProprietarios() {
        System.out.println("\n### MENU-PROPRIETÁRIOS ###");
        System.out.println("");
        System.out.println("1. Cadastrar Proprietário");
        System.out.println("2. Remover Proprietário");
        System.out.println("3. Atualizar Proprietário");
        System.out.println("4. Buscar Proprietário");
        System.out.println("5. Listar Proprietários");
        System.out.println("0. Sair");
    }
    
    
    public static void cadastrarProprietario() throws Exception {
        Proprietario proprietario = new Proprietario();
        System.out.println("Cadastrando Novo Proprietário no Sistema: ");
        System.out.println("Nome: ");
        proprietario.setNome(scanner.nextLine());
        System.out.println("Idade: ");
        int idade = Integer.parseInt(scanner.nextLine());
        proprietario.setIdade(idade);
        System.out.println("CPF: ");
        proprietario.setCpf(scanner.nextLine());
        System.out.println("Telefone de Contato: ");
        proprietario.setTelefoneContato(scanner.next());
        System.out.println("Endereço: ");
        proprietario.setEndereco(scanner.nextLine());
        proprietario.setEndereco(scanner.nextLine());
    
        try {
            serviceProprietarioSQL.adicionarProprietario(proprietario);
            System.out.println("Proprietário Adicionado com Sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao Adicionar Proprietário! " + e.getMessage());
        }  	
    }
    
    public static void removerProprietario() {
        System.out.println("Digite o CPF do Proprietário que Deseja Remover do Sistema: ");
        String cpfDel = scanner.nextLine();
    
        try {
        	Proprietario delProprietarioSql = serviceProprietarioSQL.pesquisarPorprietario(cpfDel);
    
            if(delProprietarioSql ==null ){
                throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpfDel + " não foi encontrado.");
            }
            
            serviceProprietarioSQL.excluirProp(delProprietarioSql);
            System.out.println("Proprietário Removido com Sucesso.");
        } catch (ProprietarioNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    public static void atualizarProprietario() {
        System.out.println("Digite o CPF do Proprietário que você deseja Atualizar:");
        String cpf = scanner.nextLine();

        try {
            // Busca do proprietário no banco de dados
            Proprietario proprietarioMudarSQL = proprietarioSQL.pesquisarProprietarios(cpf);

            if (proprietarioMudarSQL == null) {
                throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
            }

            // Atualização dos dados do proprietário
            System.out.println("\nDigite o Novo Nome: ");
            String nome = scanner.nextLine();
            System.out.println("Digite a Nova Idade: ");
            int idade = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite o Novo Telefone de Contato: ");
            String telefoneContato = scanner.nextLine();
            System.out.println("Digite o Novo Endereço: ");
            String endereco = scanner.nextLine();

            // Atualizando o objeto Proprietario
            proprietarioMudarSQL.setNome(nome);
            proprietarioMudarSQL.setIdade(idade);
            proprietarioMudarSQL.setTelefoneContato(telefoneContato);
            proprietarioMudarSQL.setEndereco(endereco);

            // Persistindo as alterações no banco de dados
            proprietarioSQL.alterarProprietario(proprietarioMudarSQL);

            System.out.println("Proprietário Atualizado com Sucesso!");

        } catch (ProprietarioNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Erro: Idade inválida. Por favor, insira um número inteiro.");
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }

    public static void buscarProprietario() {
        System.out.println("Digite o CPF do Proprietário que você deseja Buscar:");
        String cpf = scanner.nextLine();
    
        try {
            Proprietario proprietarioBuscarSql = serviceProprietarioSQL.pesquisarPorprietario(cpf);
            
            if(proprietarioBuscarSql == null){
                throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
            }
    
            System.out.println("Proprietário Encontrado: " + proprietarioBuscarSql.toString());

        } catch (ProprietarioNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
        }
    }
    
    public static void listarProprietarios() throws SQLException {
        ArrayList<Proprietario> proprietariosSql = serviceProprietarioSQL.listarTodos();
        if(proprietariosSql.isEmpty()){
            System.out.println("Não há Proprietários Cadastrados.");
        }else{
            for(Proprietario p : proprietariosSql){
                System.out.println(p);
            }
        }
    }
    
    
    public static void exibirMenuVendas() {
        System.out.println("\n### MENU-VENDAS ###");
        System.out.println("");
        System.out.println("1. Registrar Venda");
        System.out.println("2. Remover Venda");
        System.out.println("3. Atualizar Venda");
        System.out.println("4. Buscar Venda");
        System.out.println("5. Listar Vendas");
        System.out.println("0. Sair");
    }
    
    
    public static void exibirMenuVendaVeiculos() {
        System.out.println("\n### VENDA VEICULOS ###");
        System.out.println("");
        System.out.println("1. Vender Carro");
        System.out.println("2. Vender Moto");
        System.out.println("3. Vender Caminhão");
        System.out.println("0. Sair");
    }
    
    
    public static void realizarVendaCarro() {
        System.out.println("Digite o CPF do Proprietário: ");
        String cpf = scanner.nextLine();

        try {
            Proprietario proprietario = proprietarioSQL.pesquisarProprietarios(cpf);

            if (proprietario == null) {
                throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
            }

            // Verificar se a lista de veículos já está inicializada
            if (proprietario.getVeiculos() == null) {
                proprietario.setVeiculos(new ArrayList<Veiculo>());
            }

            System.out.println("Digite a Placa do Carro: ");
            String placa = scanner.nextLine();
            Carro carro = new Carro();
            carro.setPlaca(placa);

            // Buscar o carro
            carro = carroSql.buscarPorPlaca(carro); // O método deve retornar o carro encontrado ou lançar exceção
            if (carro == null) {
                throw new CarroNaoEncontradoException("Carro com a placa " + placa + " não encontrado.");
            }

            // Adicionar o carro ao proprietário
            proprietario.adicionarVeiculo(carro);

            // Salvar o veículo na venda
            proprietarioSQL.salvarVeiculo(proprietario.getCpf(), carro, "CARRO");

            System.out.println("Carro vendido com sucesso!");

        } catch (ProprietarioNaoEncontradoException | CarroNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao realizar a venda: " + e.getMessage());
        }
    }

    public static void realizarVendaMoto() {
        System.out.println("Digite o CPF do Proprietário: ");
        String cpf = scanner.nextLine();

        try {
            Proprietario proprietario = proprietarioSQL.pesquisarProprietarios(cpf);

            if (proprietario == null) {
                throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
            }

            // Verificar se a lista de veículos já está inicializada
            if (proprietario.getVeiculos() == null) {
                proprietario.setVeiculos(new ArrayList<Veiculo>());
            }

            System.out.println("Digite a Placa da Moto: ");
            String placa = scanner.nextLine();
            Moto moto = new Moto();
            moto.setPlaca(placa);

            // Buscar a moto
            moto = motoSql.buscarPorPlaca(moto); // O método deve retornar a moto encontrada ou lançar exceção
            if (moto == null) {
                throw new MotoNaoEncontradaException("Moto com a placa " + placa + " não encontrada.");
            }

            // Adicionar a moto ao proprietário
            proprietario.adicionarVeiculo(moto);

            // Salvar a moto na venda
            proprietarioSQL.salvarVeiculo(proprietario.getCpf(), moto, "MOTO");

            System.out.println("Moto vendida com sucesso!");

        } catch (ProprietarioNaoEncontradoException | MotoNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao realizar a venda: " + e.getMessage());
        }
    }

    public static void realizarVendaCaminhao() {
        System.out.println("Digite o CPF do Proprietário: ");
        String cpf = scanner.nextLine();

        try {
            Proprietario proprietario = proprietarioSQL.pesquisarProprietarios(cpf);

            if (proprietario == null) {
                throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
            }

            // Verificar se a lista de veículos já está inicializada
            if (proprietario.getVeiculos() == null) {
                proprietario.setVeiculos(new ArrayList<Veiculo>());
            }

            System.out.println("Digite a Placa do Caminhão: ");
            String placa = scanner.nextLine();
            Caminhao caminhao = new Caminhao();
            caminhao.setPlaca(placa);

            // Buscar o caminhão
            caminhao = caminhaoSql.buscarPorPlaca(caminhao); // O método deve retornar o caminhão encontrado ou lançar exceção
            if (caminhao == null) {
                throw new CaminhaoNaoEncontradoException("Caminhão com a placa " + placa + " não encontrado.");
            }

            // Adicionar o caminhão ao proprietário
            proprietario.adicionarVeiculo(caminhao);

            // Salvar o caminhão na venda
            proprietarioSQL.salvarVeiculo(proprietario.getCpf(), caminhao, "CAMINHAO");

            System.out.println("Caminhão vendido com sucesso!");

        } catch (ProprietarioNaoEncontradoException | CaminhaoNaoEncontradoException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Ocorreu um erro inesperado ao realizar a venda: " + e.getMessage());
        }
    }

    public static void removerVenda() {
        System.out.println("Digite o número da Venda a ser removida: ");
        int numVenda = Integer.parseInt(scanner.nextLine());

        try {
            // Remover todos os registros associados à venda
            proprietarioSQL.removerVeiculosDaVenda(numVenda);

            System.out.println("Venda e veículos associados removidos com sucesso!");

        } catch (SQLException e) {
            System.out.println("Erro ao remover a venda: " + e.getMessage());
        }
    }

    public static void atualizarVenda() {
        System.out.println("Digite o número da Venda a ser atualizada: ");
        int numVenda = Integer.parseInt(scanner.nextLine());

        try {
            // Buscar os registros da tabela venda_veiculo pelo número da venda
            List<Map<String, String>> registros = proprietarioSQL.buscarRegistrosPorNumVenda(numVenda);

            if (registros.isEmpty()) {
                throw new VendaNaoEncontradaException("Venda com o número " + numVenda + " não foi encontrada.");
            }

            // Buscar o CPF atual do proprietário
            String cpfAtual = registros.get(0).get("proprietario_cpf");

            // Mostrar CPF atual do proprietário
            System.out.println("CPF atual do proprietário: " + cpfAtual);
            System.out.println("Digite o CPF do novo proprietário (ou pressione Enter para manter o atual): ");
            String cpfNovo = scanner.nextLine().trim();

            // Usar o CPF atual se nenhum novo CPF for informado
            if (cpfNovo.isEmpty()) {
                cpfNovo = cpfAtual;
            }

            // Verificar se o novo proprietário existe
            Proprietario novoProprietario = proprietarioSQL.pesquisarProprietarios(cpfNovo);
            if (novoProprietario == null) {
                throw new Exception("Proprietário com CPF " + cpfNovo + " não encontrado.");
            }

            // Atualizar o proprietário na tabela venda_veiculo
            proprietarioSQL.atualizarProprietarioVenda(numVenda, cpfNovo);

            // Agora, vamos verificar se o veículo também precisa ser atualizado
            System.out.println("Veículos vendidos na venda " + numVenda + ":");

            // Exibir veículos atuais
            for (Map<String, String> registro : registros) {
                String placaAtual = registro.get("veiculo_placa");
                String tipoAtual = registro.get("veiculo_tipo");

                System.out.println("Veículo atual: " + placaAtual + " (" + tipoAtual + ")");

                // Perguntar se o veículo também deve ser alterado
                System.out.println("Deseja alterar esse veículo? (Digite 'sim' para alterar ou 'não' para manter): ");
                String resposta = scanner.nextLine().trim().toLowerCase();

                if (resposta.equals("sim")) {
                    // Solicitar nova placa e tipo
                    System.out.println("Digite a nova placa do veículo (ou pressione Enter para manter a atual): ");
                    String novaPlaca = scanner.nextLine().trim();
                    if (novaPlaca.isEmpty()) {
                        novaPlaca = placaAtual; // Manter a placa atual se não for informada uma nova
                    }

                    System.out.println("Digite o novo tipo do veículo (CARRO, MOTO, CAMINHAO, ou pressione Enter para manter o atual): ");
                    String novoTipo = scanner.nextLine().trim();
                    if (novoTipo.isEmpty()) {
                        novoTipo = tipoAtual; // Manter o tipo atual se não for informado um novo
                    }

                    // Atualizar veículo na tabela de vendas
                    proprietarioSQL.atualizarVeiculoNaVenda(numVenda, placaAtual, novaPlaca, novoTipo);
                    System.out.println("Veículo atualizado com sucesso.");
                }
            }

            System.out.println("Venda atualizada com sucesso!");

        } catch (VendaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao atualizar venda: " + e.getMessage());
        }
    }

    
    public static void buscarVenda() {
        System.out.println("Digite o número da Venda: ");
        int numVenda = Integer.parseInt(scanner.nextLine());

        try {
            // Buscar os registros da tabela venda_veiculo relacionados ao número da venda
            List<Map<String, String>> registros = proprietarioSQL.buscarRegistrosPorNumVenda(numVenda);

            if (registros.isEmpty()) {
                throw new VendaNaoEncontradaException("Venda com o número " + numVenda + " não foi encontrada.");
            }

            // Extrair o CPF do proprietário
            String cpfProprietario = registros.get(0).get("proprietario_cpf");
            Proprietario proprietario = proprietarioSQL.pesquisarProprietarios(cpfProprietario);
            if (proprietario == null) {
                throw new SQLException("Proprietário com CPF " + cpfProprietario + " não encontrado.");
            }

            // Exibir informações da venda
            System.out.println("Venda Número: " + numVenda + " - Proprietário: " + proprietario.getNome());
            System.out.println("Veículos Vendidos:");

            // Buscar e exibir informações de cada veículo
            for (Map<String, String> registro : registros) {
                String placa = registro.get("veiculo_placa");
                String tipo = registro.get("veiculo_tipo");

                Veiculo veiculo;
                if (tipo.equalsIgnoreCase("CARRO")) {
                    veiculo = carroSql.buscarPorPlaca(new Carro(placa));
                } else if (tipo.equalsIgnoreCase("MOTO")) {
                    veiculo = motoSql.buscarPorPlaca(new Moto(placa));
                } else if (tipo.equalsIgnoreCase("CAMINHAO")) {
                    veiculo = caminhaoSql.buscarPorPlaca(new Caminhao(placa));
                } else {
                    System.out.println(" - Tipo de veículo desconhecido: " + tipo);
                    continue;
                }

                if (veiculo != null) {
                    System.out.println(" - " + veiculo.getPlaca() + " (" + veiculo.getClass().getSimpleName() + ")");
                } else {
                    System.out.println(" - Veículo com placa " + placa + " não encontrado na tabela de " + tipo.toLowerCase() + "s.");
                }
            }

        } catch (VendaNaoEncontradaException e) {
            System.out.println("Erro: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro ao buscar venda: " + e.getMessage());
        }
    }
    
    public static void listarVendas() {
        try {
            // Buscar todos os registros da tabela venda_veiculo
            List<Map<String, String>> registros = proprietarioSQL.listarRegistrosVenda();

            if (registros.isEmpty()) {
                System.out.println("Nenhuma venda registrada.");
                return;
            }

            // Agrupar registros por número de venda
            Map<Integer, List<Map<String, String>>> vendasAgrupadas = registros.stream()
                .collect(Collectors.groupingBy(registro -> Integer.parseInt(registro.get("num_venda"))));

            // Iterar sobre cada grupo de vendas
            for (Map.Entry<Integer, List<Map<String, String>>> entradaVenda : vendasAgrupadas.entrySet()) {
                int numVenda = entradaVenda.getKey();
                List<Map<String, String>> detalhesVenda = entradaVenda.getValue();

                // Buscar o proprietário pelo CPF do primeiro registro da venda
                String cpfProprietario = detalhesVenda.get(0).get("proprietario_cpf");
                Proprietario proprietario = proprietarioSQL.pesquisarProprietarios(cpfProprietario);
                if (proprietario == null) {
                    System.out.println("Erro: Proprietário com CPF " + cpfProprietario + " não encontrado para a venda número " + numVenda + ".");
                    continue;
                }

                // Exibir informações da venda
                System.out.println("Venda Número: " + numVenda + " - Proprietário: " + proprietario.getNome());
                System.out.println("Veículos Vendidos:");

                // Buscar e exibir informações dos veículos associados à venda
                for (Map<String, String> detalhe : detalhesVenda) {
                    String placa = detalhe.get("veiculo_placa");
                    String tipo = detalhe.get("veiculo_tipo");

                    Veiculo veiculo;
                    if (tipo.equalsIgnoreCase("CARRO")) {
                        veiculo = carroSql.buscarPorPlaca(new Carro(placa));
                    } else if (tipo.equalsIgnoreCase("MOTO")) {
                        veiculo = motoSql.buscarPorPlaca(new Moto(placa));
                    } else if (tipo.equalsIgnoreCase("CAMINHAO")) {
                        veiculo = caminhaoSql.buscarPorPlaca(new Caminhao(placa));
                    } else {
                        System.out.println(" - Tipo de veículo desconhecido: " + tipo);
                        continue;
                    }

                    if (veiculo != null) {
                        System.out.println(" - " + veiculo.getPlaca() + " (" + veiculo.getClass().getSimpleName() + ")");
                    } else {
                        System.out.println(" - Veículo com placa " + placa + " não encontrado na tabela de " + tipo.toLowerCase() + "s.");
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Erro ao listar vendas: " + e.getMessage());
        }
    }

}


