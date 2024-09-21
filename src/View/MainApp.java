package View;

import java.util.ArrayList;
import java.util.Scanner;

import Entidades.Caminhao;
import Entidades.Carro;
import Entidades.Moto;
import Entidades.Proprietario;
import Entidades.Veiculo;
import Entidades.Venda;
import Entidades.Enum.CaminhaoTipo;
import Entidades.Enum.CarroTipo;
import Entidades.Enum.MotoTipo;
import IRepositorio.repositorioCaminhaoInterface;
import IRepositorio.repositorioCarroInterface;
import IRepositorio.repositorioMotoInterface;
import IRepositorio.repositorioProprietarioInterface;
import IRepositorio.repositorioVendaInterface;
import IService.serviceCaminhaoInterface;
import IService.serviceCarroInterface;
import IService.serviceMotoInterface;
import IService.serviceProprietarioInterface;
import IService.serviceVendaInterface;
import Repositorio.RepositorioCaminhao;
import Repositorio.RepositorioCarro;
import Repositorio.RepositorioMoto;
import Repositorio.RepositorioProprietario;
import Repositorio.RepositorioVenda;
import Service.ServiceCaminhao;
import Service.ServiceCarro;
import Service.ServiceMoto;
import Service.ServiceProprietario;
import Service.ServiceVenda;

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
    }

    boolean sair = false;
         while (!sair) {
             exibirMenuPrincipal();
             int opcao = scanner.nextInt();
             scanner.nextLine(); // Consumir nova linha

             switch (opcao) {
                 case 1:
                     boolean sairMV = false;
                     while (!sairMV) {
                         exibirMenuVeiculo();
                         int opcaoMV = scanner.nextInt();
                         scanner.nextLine(); // Consumir nova linha

                         switch (opcaoMV) {
                             case 1:
                                 exibirMenuCarro();
                                 break;
                             case 2:
                                 exibirMenuMoto();
                                 break;
                             case 3:
                                 exibirMenuCaminhao();
                                 break;
                             case 4:
                                 buscarPaciente();
                                 break;
                             case 5:
                                 listarPacientes();
                                 break;
                             case 6:
                                 sairMV = true;
                                 break;
                             default:
                                 System.out.println("Opção inválida! Tente novamente.");
                                 break;
                         }
                     }
                     break;

                 case 2:
                     boolean sairM = false;
                     while (!sairM) {
                         exibirMenuMedico();
                         int opcaoM = scanner.nextInt();
                         scanner.nextLine(); // Consumir nova linha

                         switch (opcaoM) {
                             case 1:
                                 adicionarMedico();
                                 break;
                             case 2:
                                 atualizarMedico();
                                 break;
                             case 3:
                                 removerMedico();
                                 break;
                             case 4:
                                 buscarMedico();
                                 break;
                             case 5:
                                 listarMedicos();
                                 break;
                             case 6:
                                 sairM = true;
                                 break;
                             default:
                                 System.out.println("Opção inválida! Tente novamente.");
                                 break;
                         }
                     }
                     break;
                 case 3:
                	 boolean sairC = false;
                     while (!sairC) {
                    	 exibirMenuConsulta();
                    	 int opcaoC = scanner.nextInt();
                    	 scanner.nextLine(); //Consumir nova linha
                    	 
                    	 switch(opcaoC) {
                    	 case 1:
                    		 marcarConsulta();
                    		 break;
                    	 case 2:
                    		 atualizarConsulta();
                    		 break;
                    	 case 3:
                    		 desmarcarConsulta();
                    		 break;
                    	 case 4:
                    		 buscarConsulta();
                    		 break;
                    	 case 5:
                    		 listarConsulta();
                    		 break;
                    	 case 6:
                    		 sairC = true;
                    		 break;
                    	 default:
                    		 System.out.println("Opção inválida! Tente Novamente.");
                    		 break;
                    	 }
                     }
                     break;
                 case 0:
                     sair = true;
                     break;

                 default:
                     System.out.println("Opção inválida! Tente novamente.");
                     break;
             }
         }
         scanner.close();
     }*/

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
        System.out.println("Qual Tipo do Carro: Hatch / Sedan / SUV / Sport: ");
        carro.setTipo();
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
            String tipo = scanner.nextLine();

            carroMudar.setMarca(marca);
            carroMudar.setModelo(modelo);
            carroMudar.setCor(cor);
            carroMudar.setAno(ano);
            carroMudar.setPlaca(placaCarro);
            carroMudar.setValorVenda(valor);
            carroMudar.setQuantPortas(qntPorta);
            carroMudar.setTipo();

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
        System.out.println("4. Listar Motos disponíveis");
        System.out.println("5. Buscar Moto");
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
        scanner.nextLine();  // Consumir nova linha
        System.out.println("Placa: ");
        moto.setPlaca(scanner.nextLine());
        System.out.println("Valor da Moto: ");
        moto.setValorVenda(scanner.nextDouble());
        System.out.println("Cilindradas: ");
        moto.setCilindradas(scanner.nextInt());
        scanner.nextLine();  // Consumir nova linha
        System.out.println("Qual Tipo da Moto: Trillha / Urbana / Sport: ");
        moto.setTipo();
    
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
            System.out.println("Qual Tipo da Moto: Scooter / Esportiva / Custom: ");
            String tipo = scanner.nextLine();
    
            motoMudar.setMarca(marca);
            motoMudar.setModelo(modelo);
            motoMudar.setCor(cor);
            motoMudar.setAno(ano);
            motoMudar.setPlaca(placaMoto);
            motoMudar.setValorVenda(valor);
            motoMudar.setCilindradas(cilindradas);
            motoMudar.setTipo();
    
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
        System.out.println("4. Listar Caminhões disponíveis");
        System.out.println("5. Buscar Caminhão");
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
        scanner.nextLine();  // Consumir nova linha
        System.out.println("Placa: ");
        caminhao.setPlaca(scanner.nextLine());
        System.out.println("Valor do Caminhão: ");
        caminhao.setValorVenda(scanner.nextDouble());
        System.out.println("Toneladas de Carga: ");
        caminhao.setToneladasCarga(scanner.nextDouble());
        scanner.nextLine();  // Consumir nova linha
    
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
    
            caminhaoMudar.setMarca(marca);
            caminhaoMudar.setModelo(modelo);
            caminhaoMudar.setCor(cor);
            caminhaoMudar.setAno(ano);
            caminhaoMudar.setPlaca(placaCaminhao);
            caminhaoMudar.setValorVenda(valor);
            caminhaoMudar.setToneladasCarga(toneladasCarga);
    
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
    



























}

