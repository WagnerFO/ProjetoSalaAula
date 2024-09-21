package View;

import java.util.ArrayList;
import java.util.Scanner;

import Entidades.*;
import Entidades.Enum.*;
import IRepositorio.*;
import IService.*;
import Repositorio.*;
import Service.*;

public class MainApp {
    private static repositorioProprietarioInterface repositorioProprietario = new RepositorioProprietario();
    private static repositorioCarroInterface repositorioCarro = new RepositorioCarro();
    private static repositorioMotoInterface repositorioMoto = new RepositorioMoto();
    private static repositorioCaminhaoInterface repositorioCaminhao = new RepositorioCaminhao();
    private static repositorioVendaInterface repositorioVenda = new RepositorioVenda();

    private static serviceProprietarioInterface serviceProprietario = new ServiceProprietario(repositorioProprietario);
    private static serviceCarroInterface serviceCarro = new ServiceCarro(repositorioCarro);
    private static serviceMotoInterface serviceMoto = new ServiceMoto(repositorioMoto);
    private static serviceCaminhaoInterface serviceCaminhao = new ServiceCaminhao(repositorioCaminhao);
    private static serviceVendaInterface serviceVenda = new ServiceVenda(repositorioVenda);
   
    
    private static Scanner scanner = new Scanner (System.in);
    
    public static void main(String[] args) throws Exception {

        Proprietario proprietario = new Proprietario("Maria Silva", 28, "98765432100", "11987654321", "Rua B, 45");

        // Exibir informações do proprietário
        System.out.println("Proprietário:");
        System.out.println("Nome: " + proprietario.getNome());
        System.out.println("Idade: " + proprietario.getIdade());
        System.out.println("CPF: " + proprietario.getCpf());
        System.out.println("Telefone: " + proprietario.getTelefoneContato());
        System.out.println("Endereço: " + proprietario.getEndereco());        

        // Instanciando um novo caminhão
        Caminhao caminhão = new Caminhao("Mercedes", "Actros", "Branco", 2022, "ABC-1234", 250000.0, 15, CaminhaoTipo.truck); 
        System.out.println("Caminhão:");
        System.out.println("Marca: " + caminhão.getMarca());
        System.out.println("Modelo: " + caminhão.getModelo());
        System.out.println("Cor: " + caminhão.getCor());
        System.out.println("Ano: " + caminhão.getAno());
        System.out.println("Placa: " + caminhão.getPlaca());
        System.out.println("Valor de Venda: " + caminhão.getValorVenda());
        System.out.println("Toneladas de Carga: " + caminhão.getToneladasCarga()); // Método getToneladasCarga deve existir na classe Caminhao

        // Instanciando um novo carro
        Carro carro = new Carro("Fiat", "Palio", "Preto", 2020, "XYZ-1234", 50000.0, 4, CarroTipo.sedan);
        System.out.println("\nCarro:");
        System.out.println("Marca: " + carro.getMarca());
        System.out.println("Modelo: " + carro.getModelo());
        System.out.println("Cor: " + carro.getCor());
        System.out.println("Ano: " + carro.getAno());
        System.out.println("Placa: " + carro.getPlaca());
        System.out.println("Valor de Venda: " + carro.getValorVenda());
        System.out.println("Quantidade de Portas: " + carro.getQuantPortas());

        // Instanciando uma nova moto
        Moto moto = new Moto("Honda", "CBR", "Vermelha", 2021, "ABC-5678", 30000.0, 600, MotoTipo.urbana);
        System.out.println("\nMoto:");
        System.out.println("Marca: " + moto.getMarca());
        System.out.println("Modelo: " + moto.getModelo());
        System.out.println("Cor: " + moto.getCor());
        System.out.println("Ano: " + moto.getAno());
        System.out.println("Placa: " + moto.getPlaca());
        System.out.println("Valor de Venda: " + moto.getValorVenda());
        System.out.println("Cilindradas: " + moto.getCilindradas()); // Método getCilindradas deve existir na classe Moto

        Venda venda = new Venda(proprietario);


        venda.vendaVeiculo(carro);
        venda.vendaVeiculo(moto);
        venda.vendaVeiculo(caminhão);
        
        serviceVenda.realizarVenda(venda);
        
        // Buscar veículo por placa na venda
        Veiculo veiculoBuscado = serviceVenda.buscarVeiculoNaVenda(venda.getId(), "XYZ-1234");
        if (veiculoBuscado != null) {
            System.out.println("Veículo encontrado: " + veiculoBuscado.toString());
        } else {
            System.out.println("Veículo não encontrado.");
        }
        
        
        
        boolean sairMP = false;
        while (!sairMP) {
        exibirMenuPrincipal();
        int opcaoMP = scanner.nextInt();
        scanner.nextLine(); // Consumir nova linha
        switch (opcaoMP) {
            case 1:
            boolean sairMV = false;
            while (!sairMV) {
            exibirMenuVeiculo();
            int opcaoMV = scanner.nextInt();
            scanner.nextLine(); // Consumir nova linha
            switch (opcaoMV) {
                case 1:
                    boolean sairCarro = false;
                    while (!sairCarro) {
                        exibirMenuPrincipal();
                        int opcaoCarro = scanner.nextInt();
                        scanner.nextLine(); // Consumir nova linha
                        switch (opcaoCarro) {
                            case 1:
                                cadastrarCarro();
                                break;
                            case 2:
                                removerCarro();
                                break;
                            case 3:
                                atualizarCarro();
                                break;
                            case 4:
                                buscarCarro();
                                break;
                            case 5: 
                                ListarCarrosDisponiveis();
                                break;
                            case 6:
                                ListarCarrosVendidos();
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
                        scanner.nextLine(); // Consumir nova linha
                        switch (opcaoMoto) {
                            case 1:
                                cadastrarCaminhao();
                                break;
                            case 2:
                                removerCaminhao();
                                break;
                            case 3:
                                atualizarCaminhao();
                                break;
                            case 4:
                                buscarCaminhao();
                                break;
                            case 5:
                                listarCaminhoesDisponiveis();
                                break;
                            case 6:
                                listarCaminhoesVendidos();
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
                        scanner.nextLine(); // Consumir nova linha
                        switch (opcaoCaminhao) {
                            case 1:
                                cadastrarCaminhao();
                                break;
                            case 2:
                                removerCaminhao();
                                break;
                            case 3:
                                atualizarCaminhao();
                                break;
                            case 4:
                                buscarCaminhao();
                                break;
                            case 5:
                                listarCaminhoesDisponiveis();
                                break;
                            case 6:
                                listarCaminhoesVendidos();
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
                boolean sairMC = false;
                while (!sairMC) {
                    exibirMenuClientes();
                    int opcaoMC = scanner.nextInt();
                    scanner.nextLine(); // Consumir nova linha
                    switch (opcaoMC) {
                        case 1:
                        cadastrarCliente();
                        break;
                    case 2:
                        removerCliente();
                        break;
                    case 3:
                        atualizarCliente();
                        break;
                    case 4:
                        buscarCliente();
                        break;
                    case 5:
                        listarClientes();
                        break;
                    case 0:
                        sairMC = true;
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
                scanner.nextLine(); // Consumir nova linha
                switch (opcaoVenda) {
                    case 1:
                        registrarVenda();
                        break;
                    case 2:
                        removerVenda();
                        break;
                    case 3:
                        atualizarVenda();
                        break;
                    case 4:
                        buscarVenda();
                        break;
                    case 5:
                        listarVendas();
                        break;
                    case 0:
                        sairVenda = true;
                        break;
                    default:
                        System.out.println("Opção inválida! Tente Novamente.");
                        break;
                }
            }

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
        System.out.println("0. Voltar");
    }

    public static void exibirMenuCarro(){
        System.out.println("\n### MENU-CARROS ###");
        System.out.println("");
        System.out.println("1. Adicionar Carro");
        System.out.println("2. Remover Carro");
        System.out.println("3. Atualizar Carro");
        System.out.println("4. Buscar Carro");
        System.out.println("5. Listar Carros disponivéis");
        System.out.println("6. Listar Carros vendidos");
        System.out.println("0. Voltar");
    }

    public static void cadastrarCarro() throws Exception{
        Carro carro = new Carro();
        System.out.println("Cadastrando Novo Carro no Sistema: ");
        System.out.println("Marca: ");
        carro.setMarca(scanner.nextLine());
        System.out.println("Modelo: ");
        carro.setModelo(scanner.nextLine());
        System.out.println("Cor: ");
        carro.setCor(scanner.nextLine());
        System.out.println(""); 
        System.out.println("Ano: ");
        carro.setAno(scanner.nextInt());
        System.out.println("Placa: ");
        carro.setPlaca(scanner.nextLine());
        System.out.println("");
        System.out.println("Valor do Carro: ");
        carro.setValorVenda(scanner.nextDouble());
        System.out.println("");
        System.out.println("Quantidade de Portas: ");
        carro.setQuantPortas(scanner.nextInt());
        System.out.println("");

            CarroTipo tipo = null;
            boolean tipoValido=false;

            while (!tipoValido) {
                System.out.println("Qual Tipo do Carro: Hatch / Sedan / SUV / Sport: ");
                String tipoCarro = scanner.nextLine().toLowerCase();
                
                try{
                    tipo = CarroTipo.valueOf(tipoCarro);
                    tipoValido = true;
                }catch(IllegalArgumentException e){
                    System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Hatch, Sedan, SUV, Sport). ");
                }
            }

            carro.setTipo(tipo);
        
        try{
            serviceCarro.cadastrarCarro(carro);
            System.out.println("Carro Adicionado com Sucesso! ");
        }catch(Exception e){
            System.out.println("Erro ao Adicionar carro! "+e.getMessage());
        }
    }

    public static void removerCarro(){
        System.out.println("Digite a Placa do Carro que Deseja Remover");
        String placaDel = scanner.nextLine();
        Carro deletarCarro = serviceCarro.buscarCarro(placaDel);
        if(placaDel !=null){
            serviceCarro.removerCarro(deletarCarro);
            System.out.println("Carro Removido com Sucesso!");
        }
        else{
            System.err.println("Carro não encontrado!");
        }
    }

    public static void atualizarCarro() throws Exception{
        System.out.println("Digite a Placa do Veiculo que você deseja Atualizar");
        String placa = scanner.nextLine();
        Carro  carroMudar = serviceCarro.buscarCarro(placa);
        if(carroMudar!=null){
            System.out.println("Digite a Nova Marca: ");
            String marca = scanner.nextLine();
            System.out.println("Digite o Novo Modelo: ");
            String modelo = scanner.nextLine();
            System.out.println("Digite a Nova Cor: ");
            String cor = scanner.nextLine();
            System.out.println("Digite o Novo Ano: ");
            int ano = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite a Nova Placa: ");
            String placaCarro = scanner.nextLine();
            System.out.println("Digite o Novo Valor: ");
            double valor = Double.parseDouble(scanner.nextLine());
            System.out.println("Digite a Quantidade de Portas: ");
            int qntPorta = Integer.parseInt(scanner.nextLine());
            System.out.println("Qual Tipo do Carro: Hatch / Sedan / SUV / Sport: ");
            
            CarroTipo tipo = null;
            boolean tipoValido=false;

            while (!tipoValido) {
                System.out.println("Qual Tipo do Carro: Hatch / Sedan / SUV / Sport: ");
                String tipoCarro = scanner.nextLine().toLowerCase();
                
                try{
                    tipo = CarroTipo.valueOf(tipoCarro);
                    tipoValido = true;
                }catch(IllegalArgumentException e){
                    System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Hatch, Sedan, SUV, Sport). ");
                }
            }

            carroMudar.setMarca(marca);
            carroMudar.setModelo(modelo);
            carroMudar.setCor(cor);
            carroMudar.setAno(ano);
            carroMudar.setPlaca(placaCarro);
            carroMudar.setValorVenda(valor);
            carroMudar.setQuantPortas(qntPorta);
            carroMudar.setTipo(tipo);

            serviceCarro.alterarCarro(carroMudar);
            System.out.println("Carro Alterado com Sucesso.");
        }else{
            System.out.println("Carro não encotrado.");
        }
    }

    public static void buscarCarro(){
        System.out.println("Digite a Placa do Veiculo que você deseja Atualizar");
        String placa = scanner.nextLine();
        Carro encontrarCarro = serviceCarro.buscarCarro(placa);
        if(encontrarCarro!= null){
            System.out.println(encontrarCarro);
        }
        else{
            System.out.println("Carro não encontrado.");
        }
    }
    
    public static void ListarCarrosDisponiveis(){
        ArrayList<Carro> carros = serviceCarro.verCarrosDisp();  
        if(carros.isEmpty()){
            System.out.println("Nenhum Carro Disponivel para Venda.");
        }else{
            for(Carro c : carros){
                System.out.println(c);
            }
        }
    }

    public static void ListarCarrosVendidos(){
        ArrayList<Carro> carros = serviceCarro.verCarrosVend();  
        if(carros.isEmpty()){
            System.out.println("Nenhum Carro Disponivel para Venda.");
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
        System.out.println("5. Listar Motos disponíveis");
        System.out.println("6. Listar Motos vendidas");
        System.out.println("0. Voltar");
    }

    public static void cadastrarMoto() throws Exception {
        Moto moto = new Moto();
        System.out.println("Cadastrando Nova Moto no Sistema: ");
        System.out.println("Marca: ");
        moto.setMarca(scanner.nextLine());
        System.out.println("Modelo: ");
        moto.setModelo(scanner.nextLine());
        System.out.println("Cor: ");
        moto.setCor(scanner.nextLine());
        System.out.println("Ano: ");
        moto.setAno(scanner.nextInt());
        scanner.nextLine(); 
        System.out.println("Placa: ");
        moto.setPlaca(scanner.nextLine());
        System.out.println("Valor da Moto: ");
        moto.setValorVenda(scanner.nextDouble());
        System.out.println("Cilindradas: ");
        moto.setCilindradas(scanner.nextInt());
        scanner.nextLine(); 
        System.out.println("Qual Tipo da Moto: Trillha / Urbana / Sport: ");
        
        MotoTipo tipo = null;
        boolean tipoValido = false;
        
        while (!tipoValido) {
            System.out.println("Qual Tipo da Moto: Trilha / Urbana / Sport: ");
            String tipoMoto = scanner.nextLine().toLowerCase();
        
            try {
                tipo = MotoTipo.valueOf(tipoMoto);
                tipoValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Trilha, Urbana, Sport). ");
            }
        }
        
        moto.setTipo(tipo);

        try {
            serviceMoto.cadastrarMoto(moto);
            System.out.println("Moto Adicionada com Sucesso! ");
        } catch (Exception e) {
            System.out.println("Erro ao Adicionar Moto! " + e.getMessage());
        }
    }
    
    public static void removerMoto() {
        System.out.println("Digite a Placa da Moto que Deseja Remover");
        String placaDel = scanner.nextLine();
        Moto deletarMoto = serviceMoto.buscarMoto(placaDel);
        if (deletarMoto != null) {
            serviceMoto.removerMoto(deletarMoto);
            System.out.println("Moto Removida com Sucesso!");
        } else {
            System.err.println("Moto não encontrada!");
        }
    }
    
    public static void atualizarMoto() throws Exception {
        System.out.println("Digite a Placa da Moto que você deseja Atualizar");
        String placa = scanner.nextLine();
        Moto motoMudar = serviceMoto.buscarMoto(placa);
        if (motoMudar != null) {
            System.out.println("Digite a Nova Marca: ");
            String marca = scanner.nextLine();
            System.out.println("Digite o Novo Modelo: ");
            String modelo = scanner.nextLine();
            System.out.println("Digite a Nova Cor: ");
            String cor = scanner.nextLine();
            System.out.println("Digite o Novo Ano: ");
            int ano = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite a Nova Placa: ");
            String placaMoto = scanner.nextLine();
            System.out.println("Digite o Novo Valor: ");
            double valor = Double.parseDouble(scanner.nextLine());
            System.out.println("Digite as Cilindradas: ");
            int cilindradas = Integer.parseInt(scanner.nextLine());
            
            MotoTipo tipo = null;
            boolean tipoValido = false;

            while (!tipoValido) {
                System.out.println("Qual Tipo da Moto: Trilha / Urbana / Sport: ");
                String tipoMoto = scanner.nextLine().toLowerCase();
            
                try {
                    tipo = MotoTipo.valueOf(tipoMoto);
                    tipoValido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Trilha, Urbana, Sport). ");
                }
            }
                        
            motoMudar.setMarca(marca);
            motoMudar.setModelo(modelo);
            motoMudar.setCor(cor);
            motoMudar.setAno(ano);
            motoMudar.setPlaca(placaMoto);
            motoMudar.setValorVenda(valor);
            motoMudar.setCilindradas(cilindradas);
            motoMudar.setTipo(tipo);
    
            serviceMoto.alterarMoto(motoMudar);
            System.out.println("Moto Alterada com Sucesso.");
        } else {
            System.out.println("Moto não encontrada.");
        }
    }
    
    public static void buscarMoto() {
        System.out.println("Digite a Placa da Moto que você deseja Buscar");
        String placa = scanner.nextLine();
        Moto encontrarMoto = serviceMoto.buscarMoto(placa);
        if (encontrarMoto != null) {
            System.out.println(encontrarMoto);
        } else {
            System.out.println("Moto não encontrada.");
        }
    }
    
    public static void listarMotosDisponiveis() {
        ArrayList<Moto> motos = serviceMoto.verMotosDisp();
        if (motos.isEmpty()) {
            System.out.println("Nenhuma Moto Disponível para Venda.");
        } else {
            for (Moto m : motos) {
                System.out.println(m);
            }
        }
    }
    
    public static void listarMotosVendidas() {
        ArrayList<Moto> motos = serviceMoto.verMotosVend();
        if (motos.isEmpty()) {
            System.out.println("Nenhuma Moto Vendida.");
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
        System.out.println("5. Listar Caminhões disponíveis");
        System.out.println("6. Listar Caminhões vendidos");
        System.out.println("0. Voltar");
    }

    public static void cadastrarCaminhao() throws Exception {
        Caminhao caminhao = new Caminhao();
        System.out.println("Cadastrando Novo Caminhão no Sistema: ");
        System.out.println("Marca: ");
        caminhao.setMarca(scanner.nextLine());
        System.out.println("Modelo: ");
        caminhao.setModelo(scanner.nextLine());
        System.out.println("Cor: ");
        caminhao.setCor(scanner.nextLine());
        System.out.println("Ano: ");
        caminhao.setAno(scanner.nextInt());
        scanner.nextLine();  
        System.out.println("Placa: ");
        caminhao.setPlaca(scanner.nextLine());
        System.out.println("Valor do Caminhão: ");
        caminhao.setValorVenda(scanner.nextDouble());
        System.out.println("Toneladas de Carga: ");
        caminhao.setToneladasCarga(scanner.nextDouble());
        scanner.nextLine();

        CaminhaoTipo tipo = null;
        boolean tipoValido = false;
        
        while (!tipoValido) {
            System.out.println("Qual Tipo do Caminhão: Truck / Bitruck / Carreta: ");
            String tipoCaminhao = scanner.nextLine().toLowerCase();
        
            try {
                tipo = CaminhaoTipo.valueOf(tipoCaminhao);
                tipoValido = true;
            } catch (IllegalArgumentException e) {
                System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Truck, Bitruck, Carreta). ");
            }
        }

        caminhao.setTipo(tipo);
    
        try {
            serviceCaminhao.cadastrarCaminhao(caminhao);
            System.out.println("Caminhão Adicionado com Sucesso! ");
        } catch (Exception e) {
            System.out.println("Erro ao Adicionar Caminhão! " + e.getMessage());
        }
    }
    
    public static void removerCaminhao() {
        System.out.println("Digite a Placa do Caminhão que Deseja Remover");
        String placaDel = scanner.nextLine();
        Caminhao deletarCaminhao = serviceCaminhao.buscarCaminhao(placaDel);
        if (deletarCaminhao != null) {
            serviceCaminhao.removerCaminhao(deletarCaminhao);
            System.out.println("Caminhão Removido com Sucesso!");
        } else {
            System.err.println("Caminhão não encontrado!");
        }
    }
    
    public static void atualizarCaminhao() throws Exception {
        System.out.println("Digite a Placa do Caminhão que você deseja Atualizar");
        String placa = scanner.nextLine();
        Caminhao caminhaoMudar = serviceCaminhao.buscarCaminhao(placa);
        if (caminhaoMudar != null) {
            System.out.println("Digite a Nova Marca: ");
            String marca = scanner.nextLine();
            System.out.println("Digite o Novo Modelo: ");
            String modelo = scanner.nextLine();
            System.out.println("Digite a Nova Cor: ");
            String cor = scanner.nextLine();
            System.out.println("Digite o Novo Ano: ");
            int ano = Integer.parseInt(scanner.nextLine());
            System.out.println("Digite a Nova Placa: ");
            String placaCaminhao = scanner.nextLine();
            System.out.println("Digite o Novo Valor: ");
            double valor = Double.parseDouble(scanner.nextLine());
            System.out.println("Digite as Toneladas de Carga: ");
            double toneladasCarga = Double.parseDouble(scanner.nextLine());

            CaminhaoTipo tipo = null;
            boolean tipoValido = false;
            
            while (!tipoValido) {
                System.out.println("Qual Tipo do Caminhão: Truck / Bitruck / Carreta: ");
                String tipoCaminhao = scanner.nextLine().toLowerCase();
            
                try {
                    tipo = CaminhaoTipo.valueOf(tipoCaminhao);
                    tipoValido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Truck, Bitruck, Carreta). ");
                }
            }
    
            caminhaoMudar.setMarca(marca);
            caminhaoMudar.setModelo(modelo);
            caminhaoMudar.setCor(cor);
            caminhaoMudar.setAno(ano);
            caminhaoMudar.setPlaca(placaCaminhao);
            caminhaoMudar.setValorVenda(valor);
            caminhaoMudar.setToneladasCarga(toneladasCarga);
            caminhaoMudar.setTipo(tipo);

            serviceCaminhao.alterarCaminhao(caminhaoMudar);

            System.out.println("Caminhão Alterado com Sucesso.");
        } else {
            System.out.println("Caminhão não encontrado.");
        }
    }
    
    public static void buscarCaminhao() {
        System.out.println("Digite a Placa do Caminhão que você deseja Buscar");
        String placa = scanner.nextLine();
        Caminhao encontrarCaminhao = serviceCaminhao.buscarCaminhao(placa);
        if (encontrarCaminhao != null) {
            System.out.println(encontrarCaminhao);
        } else {
            System.out.println("Caminhão não encontrado.");
        }
    }
    
    public static void listarCaminhoesDisponiveis() {
        ArrayList<Caminhao> caminhoes = serviceCaminhao.verCaminhoesDisp();
        if (caminhoes.isEmpty()) {
            System.out.println("Nenhum Caminhão Disponível para Venda.");
        } else {
            for (Caminhao c : caminhoes) {
                System.out.println(c);
            }
        }
    }
    
    public static void listarCaminhoesVendidos() {
        ArrayList<Caminhao> caminhoes = serviceCaminhao.verCaminhoesVend();
        if (caminhoes.isEmpty()) {
            System.out.println("Nenhum Caminhão Vendido.");
        } else {
            for (Caminhao c : caminhoes) {
                System.out.println(c);
            }
        }
    }
    

    public static void exibirMenuClientes() {
        System.out.println("\n### MENU-CLIENTES ###");
        System.out.println("");
        System.out.println("1. Cadastrar Cliente");
        System.out.println("2. Remover Cliente");
        System.out.println("3. Atualizar Cliente");
        System.out.println("4. Buscar Cliente");
        System.out.println("5. Listar Clientes");
        System.out.println("0. Sair");
    }
    
    public static void cadastrarCliente() throws Exception {
        Proprietario proprietario = new Proprietario();
        System.out.println("Cadastrando Novo Proprietário no Sistema: ");
        System.out.println("Nome: ");
        proprietario.setNome(scanner.nextLine());
        System.out.println("Idade: ");
        proprietario.setIdade(scanner.nextInt());
        System.out.println("CPF: ");
        proprietario.setCpf(scanner.nextLine());
        System.out.println("Telefone de Contato: ");
        proprietario.setTelefoneContato(scanner.next());
        System.out.println("Endereço: ");
        proprietario.setEndereco(scanner.nextLine());
        proprietario.setEndereco(scanner.nextLine()); 

        try {
            serviceProprietario.cadastrarProprietario(proprietario);
                System.out.println("Proprietário Adicionado com Sucesso!");
            } catch (Exception e) {
                System.out.println("Erro ao Adicionar Proprietário! " + e.getMessage());
            }
        }
    
    public static void removerCliente() {
        System.out.println("Digite o CPF do Cliente que Deseja Remover do Sistema: ");
        
    }
    
    public static void atualizarCliente() {
        // Lógica para atualizar um cliente
    }
    
    public static void buscarCliente() {
        // Lógica para buscar um cliente
    }
    
    public static void listarClientes() {
        // Lógica para listar todos os clientes
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

    
    public static void registrarVenda() {
        // Lógica para registrar uma venda
    }
    
    public static void removerVenda() {
        // Lógica para remover uma venda
    }
    
    public static void atualizarVenda() {
        // Lógica para atualizar uma venda
    }
    
    public static void buscarVenda() {
        // Lógica para buscar uma venda
    }
    
    public static void listarVendas() {
        // Lógica para listar todas as vendas
    }
    

}

