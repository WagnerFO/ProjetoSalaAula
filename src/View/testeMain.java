package View;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import Entity.*;
import Entity.Enum.*;
import Exceptions.*;
import IRepositorio.*;
import IService.*;
import Repositorio.*;
import Service.*;

public class testeMain {
    
    private static IRepositorioProprietarioSQL proprietarioSQL = new  RepositorioProprietarioSQL();
    private static IRepositorioCarroSQL carroSql = new RepositorioCarroSQL();
    private static IRepositorioMotoSQL motoSql = new RepositorioMotoSQL();
    private static IRepositorioCaminhaoSQL caminhaoSql = new RepositorioCaminhaoSQL();

    private static Scanner scanner = new Scanner (System.in);
    
    public static void main(String[] args) {
    	
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
            					cadastrarVeiculo();
            					System.out.println("");
            					break;
            				case 2:
            					buscarVeiculo();
            					System.out.println("");
            					break;
            				case 3: 
            					atualizarVeiculo();
            					System.out.println("");
            					break;
            				case 4:
            					removerVeiculo();
            					System.out.println("");
            					break;
            				case 5:
            					listarTodosVeiculos();
            					System.out.println("");
            					break;
            				case 6:
            					boolean sairML = false;
                        		while (!sairML) {
                        			exibirMenuLista();
                        			int opcaoML = scanner.nextInt();
                        			scanner.nextLine(); 
                        			switch (opcaoML) {
                        				case 1:
                        					listarCarros();
                        					System.out.println("");
                        					break;
                        				case 2:
                        					listarMotos();
                        					System.out.println("");
                        					break;
                        				case 3: 
                        					listarCaminhoes();
                        					System.out.println("");
                        					break;
                        				case 0:
                        					sairML=true;
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
        System.out.println("1. Menu - Veiculos");
        System.out.println("2. MENU - Clientes");
        System.out.println("3. MENU - Vendas ");
        System.out.println("0. Sair");
        System.out.println("Escolha uma opção: ");
    }
    
    public static void exibirMenuVeiculo(){
        System.out.println("\n### MENU-VEICULOS ###"+"\n");
        System.out.println("1- Cadastar Veiculo: ");
        System.out.println("2. Buscar Veiculo ");
        System.out.println("3. Atualizar Veiculo");
        System.out.println("4. Remover Veiculo");
        System.out.println("5. Listar Todos Veiculos");
        System.out.println("6. Listar Apenas um Tipo Veiculo");
        System.out.println("0. Voltar"+"\n");
    }
    
    public static void exibirMenuLista(){
        System.out.println("\n### LISTAR VEICULOS ###"+"\n");
        System.out.println("1- Listar Carro: ");
        System.out.println("2. Listar Moto: ");
        System.out.println("3. Listar Caminhão");
        System.out.println("0. Voltar"+"\n");
    }
                
    	
    
    public static void cadastrarVeiculo() throws Exception {
        System.out.println("\nCadastrando Novo Veículo no Sistema: \n");

        // Perguntando qual tipo de veículo o usuário deseja cadastrar
        System.out.println("Escolha o tipo de veículo: Carro / Moto / Caminhão");
        String tipoVeiculo = scanner.nextLine().trim().toLowerCase();

        // Variável para armazenar o veículo a ser cadastrado
        Veiculo veiculo = null;

        if (tipoVeiculo.equals("carro")) {
            // Cadastro de Carro
            veiculo = new Carro(); // Tipo Carro
            System.out.println("Marca: ");
            veiculo.setMarca(scanner.nextLine());
            System.out.println("Modelo: ");
            veiculo.setModelo(scanner.nextLine());
            System.out.println("Cor: ");
            veiculo.setCor(scanner.nextLine());
            System.out.println("Ano: ");
            veiculo.setAno(Integer.parseInt(scanner.nextLine()));
            System.out.println("Placa: ");
            veiculo.setPlaca(scanner.nextLine());
            System.out.println("Valor do Carro: ");
            veiculo.setValorVenda(Double.parseDouble(scanner.nextLine()));
            System.out.println("Quantidade de Portas: ");
            ((Carro) veiculo).setQuantPortas(Integer.parseInt(scanner.nextLine())); // Atributo específico para Carro

            // Escolhendo o tipo de carro
            CarroTipo tipo = null;
            boolean tipoValido = false;
            while (!tipoValido) {
                System.out.println("Qual Tipo do Carro: Hatch / Sedan / SUV / Sport: ");
                String tipoCarro = scanner.nextLine().trim().toUpperCase();
                try {
                    tipo = CarroTipo.valueOf(tipoCarro);
                    tipoValido = true;
                } catch (IllegalArgumentException e) {
                    System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Hatch, Sedan, SUV, Sport).");
                }
            }
            veiculo.setTipo(tipo);

        } else if (tipoVeiculo.equals("moto")) {
            // Cadastro de Moto
            veiculo = new Moto(); // Tipo Moto
            System.out.println("Marca: ");
            veiculo.setMarca(scanner.nextLine());
            System.out.println("Modelo: ");
            veiculo.setModelo(scanner.nextLine());
            System.out.println("Cor: ");
            veiculo.setCor(scanner.nextLine());
            System.out.println("Ano: ");
            veiculo.setAno(Integer.parseInt(scanner.nextLine()));
            System.out.println("Placa: ");
            veiculo.setPlaca(scanner.nextLine());
            System.out.println("Valor da Moto: ");
            veiculo.setValorVenda(Double.parseDouble(scanner.nextLine()));
            System.out.println("Cilindrada: ");
            ((Moto) veiculo).setCilindradas(Integer.parseInt(scanner.nextLine())); // Atributo específico para Moto

            // Escolhendo o tipo de moto
            String tipoMoto = null;
            boolean tipoValido = false;
            while (!tipoValido) {
                System.out.println("Qual Tipo da Moto: Trilha / Urbana / Sport: ");
                tipoMoto = scanner.nextLine().trim();
                if (tipoMoto.equalsIgnoreCase("Trilha") || tipoMoto.equalsIgnoreCase("Urbana") || tipoMoto.equalsIgnoreCase("Sport")) {
                    tipoValido = true;
                } else {
                    System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Trilha, Urbana, Sport).");
                }
            }
            ((Moto) veiculo).setTipo(tipoMoto); // Define o tipo específico para Moto

        } else if (tipoVeiculo.equals("caminhão")) {
            // Cadastro de Caminhão
            veiculo = new Caminhao(); // Tipo Caminhão
            System.out.println("Marca: ");
            veiculo.setMarca(scanner.nextLine());
            System.out.println("Modelo: ");
            veiculo.setModelo(scanner.nextLine());
            System.out.println("Cor: ");
            veiculo.setCor(scanner.nextLine());
            System.out.println("Ano: ");
            veiculo.setAno(Integer.parseInt(scanner.nextLine()));
            System.out.println("Placa: ");
            veiculo.setPlaca(scanner.nextLine());
            System.out.println("Valor do Caminhão: ");
            veiculo.setValorVenda(Double.parseDouble(scanner.nextLine()));
            System.out.println("Toneladas de Carga: ");
            ((Caminhao) veiculo).setToneladasCarga(Double.parseDouble(scanner.nextLine())); // Atributo específico para Caminhão

            // Escolhendo o tipo de caminhão
            String tipoCaminhao = null;
            boolean tipoValido = false;
            while (!tipoValido) {
                System.out.println("Qual Tipo do Caminhão: Truck / Bitruck / Carreta: ");
                tipoCaminhao = scanner.nextLine().trim();
                if (tipoCaminhao.equalsIgnoreCase("Truck") || tipoCaminhao.equalsIgnoreCase("Bitruck") || tipoCaminhao.equalsIgnoreCase("Carreta")) {
                    tipoValido = true;
                } else {
                    System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Truck, Bitruck, Carreta).");
                }
            }
            ((Caminhao) veiculo).setTipo(tipoCaminhao); // Define o tipo específico para Caminhão

        } else {
            System.out.println("Tipo de veículo inválido! Por favor, escolha entre Carro, Moto ou Caminhão.");
            return; // Encerra a função caso o tipo seja inválido
        }

        // Salvar o veículo no banco
        try {
            if (veiculo instanceof Carro) {
                carroSql.salvar((Carro) veiculo); // Salvar Carro no banco
            } else if (veiculo instanceof Moto) {
                motoSql.salvar((Moto) veiculo); // Salvar Moto no banco
            } else if (veiculo instanceof Caminhao) {
                caminhaoSql.salvar((Caminhao) veiculo); // Salvar Caminhão no banco
            }
            System.out.println("Veículo Adicionado com Sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao Adicionar veículo: " + e.getMessage());
        }
    }


	
	public static void buscarVeiculo() throws Exception {
	    System.out.println("\nBuscando Veículo no Sistema: \n");

	    // Pergunta ao usuário qual tipo de veículo deseja buscar
	    System.out.println("Escolha o tipo de veículo: Carro / Moto / Caminhão");
	    String tipoVeiculo = scanner.nextLine().trim().toLowerCase();

	    // Pergunta pela placa do veículo
	    System.out.println("Digite a Placa do Veículo que você deseja Buscar:");
	    String placa = scanner.nextLine().trim();

	    // Variável para armazenar o veículo encontrado
	    Veiculo veiculo = null;

	    if (tipoVeiculo.equals("carro")) {
	        // Buscar Carro no banco de dados
	        veiculo = carroSql.buscarPorPlaca(placa);  // Método que busca carro pela placa
	        if (veiculo != null) {
	            // Exibe os dados do carro encontrado
	            Carro carro = (Carro) veiculo;
	            System.out.println("Carro Encontrado: ");
	            System.out.println("ID: " + carro.getId());  // Exibindo o ID do veículo
	            System.out.println("Marca: " + carro.getMarca());
	            System.out.println("Modelo: " + carro.getModelo());
	            System.out.println("Cor: " + carro.getCor());
	            System.out.println("Ano: " + carro.getAno());
	            System.out.println("Placa: " + carro.getPlaca());
	            System.out.println("Valor de Venda: " + carro.getValorVenda());
	            System.out.println("Quantidade de Portas: " + carro.getQuantPortas());
	            System.out.println("Tipo: " + carro.getTipo());
	        }

	    } else if (tipoVeiculo.equals("moto")) {
	        // Buscar Moto no banco de dados
	        veiculo = motoSql.buscarPorPlaca(placa);  // Método que busca moto pela placa
	        if (veiculo != null) {
	            // Exibe os dados da moto encontrada
	            Moto moto = (Moto) veiculo;
	            System.out.println("Moto Encontrada: ");
	            System.out.println("ID: " + moto.getId());  // Exibindo o ID do veículo
	            System.out.println("Marca: " + moto.getMarca());
	            System.out.println("Modelo: " + moto.getModelo());
	            System.out.println("Cor: " + moto.getCor());
	            System.out.println("Ano: " + moto.getAno());
	            System.out.println("Placa: " + moto.getPlaca());
	            System.out.println("Valor de Venda: " + moto.getValorVenda());
	            System.out.println("Cilindrada: " + moto.getCilindrada());
	        }

	    } else if (tipoVeiculo.equals("caminhão")) {
	        // Buscar Caminhão no banco de dados
	        veiculo = caminhaoSql.buscarPorPlaca(placa);  // Método que busca caminhão pela placa
	        if (veiculo != null) {
	            // Exibe os dados do caminhão encontrado
	            Caminhao caminhao = (Caminhao) veiculo;
	            System.out.println("Caminhão Encontrado: ");
	            System.out.println("ID: " + caminhao.getId());  // Exibindo o ID do veículo
	            System.out.println("Marca: " + caminhao.getMarca());
	            System.out.println("Modelo: " + caminhao.getModelo());
	            System.out.println("Cor: " + caminhao.getCor());
	            System.out.println("Ano: " + caminhao.getAno());
	            System.out.println("Placa: " + caminhao.getPlaca());
	            System.out.println("Valor de Venda: " + caminhao.getValorVenda());
	            System.out.println("Toneladas de Carga: " + caminhao.getToneladasCarga());
	        }

	    } else {
	        System.out.println("Tipo de veículo inválido! Por favor, escolha entre Carro, Moto ou Caminhão.");
	        return;  // Encerra a função caso o tipo seja inválido
	    }

	    if (veiculo == null) {
	        System.out.println("Veículo com a placa " + placa + " não encontrado.");
	    }
	}
	public static void atualizarVeiculo() throws Exception {
	    System.out.println("\nAtualizando Veículo no Sistema: \n");

	    // Pergunta ao usuário qual tipo de veículo deseja atualizar
	    System.out.println("Escolha o tipo de veículo: Carro / Moto / Caminhão");
	    String tipoVeiculo = scanner.nextLine().trim().toLowerCase();

	    // Pergunta pelo ID do veículo para atualização
	    System.out.println("Digite o ID do Veículo que você deseja Atualizar:");
	    int id = Integer.parseInt(scanner.nextLine().trim());

	    // Variável para armazenar o veículo encontrado
	    Veiculo veiculo = null;

	    if (tipoVeiculo.equals("carro")) {
	        // Buscar Carro no banco de dados pelo ID
	        veiculo = carroSql.buscarPorId(id);  // Método que busca carro pelo ID
	        if (veiculo != null) {
	            Carro carro = (Carro) veiculo;

	            // Exibindo os dados atuais do carro
	            System.out.println("Carro Encontrado: ");
	            System.out.println("ID: " + carro.getId());
	            System.out.println("Marca: " + carro.getMarca());
	            System.out.println("Modelo: " + carro.getModelo());
	            System.out.println("Cor: " + carro.getCor());
	            System.out.println("Ano: " + carro.getAno());
	            System.out.println("Placa: " + carro.getPlaca());
	            System.out.println("Valor de Venda: " + carro.getValorVenda());
	            System.out.println("Quantidade de Portas: " + carro.getQuantPortas());
	            System.out.println("Tipo: " + carro.getTipo());

	            // Atualizando os dados
	            System.out.println("\nDigite a Nova Marca: ");
	            carro.setMarca(scanner.nextLine());
	            System.out.println("Digite o Novo Modelo: ");
	            carro.setModelo(scanner.nextLine());
	            System.out.println("Digite a Nova Cor: ");
	            carro.setCor(scanner.nextLine());
	            System.out.println("Digite o Novo Ano: ");
	            carro.setAno(Integer.parseInt(scanner.nextLine()));
	            System.out.println("Digite o Novo Valor de Venda: ");
	            carro.setValorVenda(Double.parseDouble(scanner.nextLine()));
	            System.out.println("Digite a Nova Quantidade de Portas: ");
	            carro.setQuantPortas(Integer.parseInt(scanner.nextLine()));

	            // Atualizando o tipo do carro
	            CarroTipo tipo = null;
	            boolean tipoValido = false;
	            while (!tipoValido) {
	                System.out.println("Qual Tipo do Carro: Hatch / Sedan / SUV / Sport: ");
	                String tipoCarro = scanner.nextLine().trim().toUpperCase();
	                try {
	                    tipo = CarroTipo.valueOf(tipoCarro);  // Tenta converter a string para o enum
	                    tipoValido = true;
	                } catch (IllegalArgumentException e) {
	                    System.out.println("Tipo Inválido, Por Favor Insira um Tipo Válido (Hatch, Sedan, SUV, Sport).");
	                }
	            }
	            carro.setTipo(tipo);

	            // Atualizando o carro no banco de dados
	            carroSql.atualizar(carro);  // Método de atualização diretamente no carroSql

	            System.out.println("\nCarro Atualizado com Sucesso!");
	        }

	    } else if (tipoVeiculo.equals("moto")) {
	        // Buscar Moto no banco de dados pelo ID
	        veiculo = motoSql.buscarPorId(id);  // Método que busca moto pelo ID
	        if (veiculo != null) {
	            Moto moto = (Moto) veiculo;

	            // Exibindo os dados atuais da moto
	            System.out.println("Moto Encontrada: ");
	            System.out.println("ID: " + moto.getId());
	            System.out.println("Marca: " + moto.getMarca());
	            System.out.println("Modelo: " + moto.getModelo());
	            System.out.println("Cor: " + moto.getCor());
	            System.out.println("Ano: " + moto.getAno());
	            System.out.println("Placa: " + moto.getPlaca());
	            System.out.println("Valor de Venda: " + moto.getValorVenda());
	            System.out.println("Cilindrada: " + moto.getCilindrada());

	            // Atualizando os dados
	            System.out.println("\nDigite a Nova Marca: ");
	            moto.setMarca(scanner.nextLine());
	            System.out.println("Digite o Novo Modelo: ");
	            moto.setModelo(scanner.nextLine());
	            System.out.println("Digite a Nova Cor: ");
	            moto.setCor(scanner.nextLine());
	            System.out.println("Digite o Novo Ano: ");
	            moto.setAno(Integer.parseInt(scanner.nextLine()));
	            System.out.println("Digite o Novo Valor de Venda: ");
	            moto.setValorVenda(Double.parseDouble(scanner.nextLine()));
	            System.out.println("Digite a Nova Cilindrada: ");
	            moto.setCilindradas(Integer.parseInt(scanner.nextLine()));

	            // Atualizando a moto no banco de dados
	            motoSql.atualizar(moto);  // Método de atualização diretamente no motoSql

	            System.out.println("\nMoto Atualizada com Sucesso!");
	        }

	    } else if (tipoVeiculo.equals("caminhão")) {
	        // Buscar Caminhão no banco de dados pelo ID
	        veiculo = caminhaoSql.buscarPorId(id);  // Método que busca caminhão pelo ID
	        if (veiculo != null) {
	            Caminhao caminhao = (Caminhao) veiculo;

	            // Exibindo os dados atuais do caminhão
	            System.out.println("Caminhão Encontrado: ");
	            System.out.println("ID: " + caminhao.getId());
	            System.out.println("Marca: " + caminhao.getMarca());
	            System.out.println("Modelo: " + caminhao.getModelo());
	            System.out.println("Cor: " + caminhao.getCor());
	            System.out.println("Ano: " + caminhao.getAno());
	            System.out.println("Placa: " + caminhao.getPlaca());
	            System.out.println("Valor de Venda: " + caminhao.getValorVenda());
	            System.out.println("Toneladas de Carga: " + caminhao.getToneladasCarga());

	            // Atualizando os dados
	            System.out.println("\nDigite a Nova Marca: ");
	            caminhao.setMarca(scanner.nextLine());
	            System.out.println("Digite o Novo Modelo: ");
	            caminhao.setModelo(scanner.nextLine());
	            System.out.println("Digite a Nova Cor: ");
	            caminhao.setCor(scanner.nextLine());
	            System.out.println("Digite o Novo Ano: ");
	            caminhao.setAno(Integer.parseInt(scanner.nextLine()));
	            System.out.println("Digite o Novo Valor de Venda: ");
	            caminhao.setValorVenda(Double.parseDouble(scanner.nextLine()));
	            System.out.println("Digite a Nova Quantidade de Toneladas de Carga: ");
	            caminhao.setToneladasCarga(Double.parseDouble(scanner.nextLine()));

	            // Atualizando o caminhão no banco de dados
	            caminhaoSql.atualizar(caminhao);  // Método de atualização diretamente no caminhaoSql

	            System.out.println("\nCaminhão Atualizado com Sucesso!");
	        }

	    } else {
	        System.out.println("Tipo de veículo inválido! Por favor, escolha entre Carro, Moto ou Caminhão.");
	        return;  // Encerra a função caso o tipo seja inválido
	    }

	    if (veiculo == null) {
	        System.out.println("Veículo com o ID " + id + " não encontrado.");
	    }
	}

	
	public static void removerVeiculo() throws Exception {
	    System.out.println("\nRemovendo Veículo do Sistema: \n");

	    // Pergunta ao usuário qual tipo de veículo deseja remover
	    System.out.println("Escolha o tipo de veículo: Carro / Moto / Caminhão");
	    String tipoVeiculo = scanner.nextLine().trim().toLowerCase();

	    // Pergunta pelo ID do veículo para remoção
	    System.out.println("Digite o ID do Veículo que você deseja Remover:");
	    int id = Integer.parseInt(scanner.nextLine().trim());

	    Veiculo veiculo = null;

	    if (tipoVeiculo.equals("carro")) {
	        // Buscar Carro no banco de dados pelo ID
	        veiculo = carroSql.buscarPorId(id);  // Método que busca carro pelo ID
	        if (veiculo != null) {
	            Carro carro = (Carro) veiculo;

	            // Exibindo os dados do carro que será removido
	            System.out.println("Carro Encontrado: ");
	            System.out.println("ID: " + carro.getId());
	            System.out.println("Marca: " + carro.getMarca());
	            System.out.println("Modelo: " + carro.getModelo());
	            System.out.println("Cor: " + carro.getCor());
	            System.out.println("Ano: " + carro.getAno());
	            System.out.println("Placa: " + carro.getPlaca());
	            System.out.println("Valor de Venda: " + carro.getValorVenda());
	            System.out.println("Quantidade de Portas: " + carro.getQuantPortas());
	            System.out.println("Tipo: " + carro.getTipo());

	            // Confirmando a remoção
	            System.out.println("\nDeseja realmente remover este Carro? (Sim/Não): ");
	            String confirmacao = scanner.nextLine().trim().toLowerCase();
	            if (confirmacao.equals("sim")) {
	                carroSql.remover(carro);  // Método de remoção diretamente no carroSql
	                System.out.println("Carro Removido com Sucesso!");
	            } else {
	                System.out.println("Remoção cancelada.");
	            }
	        } else {
	            System.out.println("Carro com o ID " + id + " não encontrado.");
	        }

	    } else if (tipoVeiculo.equals("moto")) {
	        // Buscar Moto no banco de dados pelo ID
	        veiculo = motoSql.buscarPorId(id);  // Método que busca moto pelo ID
	        if (veiculo != null) {
	            Moto moto = (Moto) veiculo;

	            // Exibindo os dados da moto que será removida
	            System.out.println("Moto Encontrada: ");
	            System.out.println("ID: " + moto.getId());
	            System.out.println("Marca: " + moto.getMarca());
	            System.out.println("Modelo: " + moto.getModelo());
	            System.out.println("Cor: " + moto.getCor());
	            System.out.println("Ano: " + moto.getAno());
	            System.out.println("Placa: " + moto.getPlaca());
	            System.out.println("Valor de Venda: " + moto.getValorVenda());
	            System.out.println("Cilindrada: " + moto.getCilindrada());

	            // Confirmando a remoção
	            System.out.println("\nDeseja realmente remover esta Moto? (Sim/Não): ");
	            String confirmacao = scanner.nextLine().trim().toLowerCase();
	            if (confirmacao.equals("sim")) {
	                motoSql.remover(moto);  // Método de remoção diretamente no motoSql
	                System.out.println("Moto Removida com Sucesso!");
	            } else {
	                System.out.println("Remoção cancelada.");
	            }
	        } else {
	            System.out.println("Moto com o ID " + id + " não encontrada.");
	        }

	    } else if (tipoVeiculo.equals("caminhão")) {
	        // Buscar Caminhão no banco de dados pelo ID
	        veiculo = caminhaoSql.buscarPorId(id);  // Método que busca caminhão pelo ID
	        if (veiculo != null) {
	            Caminhao caminhao = (Caminhao) veiculo;

	            // Exibindo os dados do caminhão que será removido
	            System.out.println("Caminhão Encontrado: ");
	            System.out.println("ID: " + caminhao.getId());
	            System.out.println("Marca: " + caminhao.getMarca());
	            System.out.println("Modelo: " + caminhao.getModelo());
	            System.out.println("Cor: " + caminhao.getCor());
	            System.out.println("Ano: " + caminhao.getAno());
	            System.out.println("Placa: " + caminhao.getPlaca());
	            System.out.println("Valor de Venda: " + caminhao.getValorVenda());
	            System.out.println("Toneladas de Carga: " + caminhao.getToneladasCarga());

	            // Confirmando a remoção
	            System.out.println("\nDeseja realmente remover este Caminhão? (Sim/Não): ");
	            String confirmacao = scanner.nextLine().trim().toLowerCase();
	            if (confirmacao.equals("sim")) {
	                caminhaoSql.remover(caminhao);  // Método de remoção diretamente no caminhaoSql
	                System.out.println("Caminhão Removido com Sucesso!");
	            } else {
	                System.out.println("Remoção cancelada.");
	            }
	        } else {
	            System.out.println("Caminhão com o ID " + id + " não encontrado.");
	        }

	    } else {
	        System.out.println("Tipo de veículo inválido! Por favor, escolha entre Carro, Moto ou Caminhão.");
	        return;  // Encerra a função caso o tipo seja inválido
	    }
	}
	public static void listarTodosVeiculos() throws Exception {
	    System.out.println("\nListando Todos os Veículos: \n");

	    // Listando todos os carros
	    System.out.println("\nCarros:");
	    List<Carro> carros = carroSql.listarTodos(); // Método que retorna todos os carros
	    if (carros.isEmpty()) {
	        System.out.println("Nenhum carro encontrado.");
	    } else {
	        for (Carro carro : carros) {
	            System.out.println("ID: " + carro.getId());
	            System.out.println("Marca: " + carro.getMarca());
	            System.out.println("Modelo: " + carro.getModelo());
	            System.out.println("Cor: " + carro.getCor());
	            System.out.println("Ano: " + carro.getAno());
	            System.out.println("Placa: " + carro.getPlaca());
	            System.out.println("Valor de Venda: " + carro.getValorVenda());
	            System.out.println("Quantidade de Portas: " + carro.getQuantPortas());
	            System.out.println("Tipo: " + carro.getTipo());
	            System.out.println("-----------------------------------");
	        }
	    }

	    // Listando todas as motos
	    System.out.println("\nMotos:");
	    List<Moto> motos = motoSql.listarTodos(); // Método que retorna todas as motos
	    if (motos.isEmpty()) {
	        System.out.println("Nenhuma moto encontrada.");
	    } else {
	        for (Moto moto : motos) {
	            System.out.println("ID: " + moto.getId());
	            System.out.println("Marca: " + moto.getMarca());
	            System.out.println("Modelo: " + moto.getModelo());
	            System.out.println("Cor: " + moto.getCor());
	            System.out.println("Ano: " + moto.getAno());
	            System.out.println("Placa: " + moto.getPlaca());
	            System.out.println("Valor de Venda: " + moto.getValorVenda());
	            System.out.println("Cilindrada: " + moto.getCilindrada());
	            System.out.println("-----------------------------------");
	        }
	    }

	    // Listando todos os caminhões
	    System.out.println("\nCaminhões:");
	    List<Caminhao> caminhoes = caminhaoSql.listarTodos(); // Método que retorna todos os caminhões
	    if (caminhoes.isEmpty()) {
	        System.out.println("Nenhum caminhão encontrado.");
	    } else {
	        for (Caminhao caminhao : caminhoes) {
	            System.out.println("ID: " + caminhao.getId());
	            System.out.println("Marca: " + caminhao.getMarca());
	            System.out.println("Modelo: " + caminhao.getModelo());
	            System.out.println("Cor: " + caminhao.getCor());
	            System.out.println("Ano: " + caminhao.getAno());
	            System.out.println("Placa: " + caminhao.getPlaca());
	            System.out.println("Valor de Venda: " + caminhao.getValorVenda());
	            System.out.println("Toneladas de Carga: " + caminhao.getToneladasCarga());
	            System.out.println("-----------------------------------");
	        }
	    }
	}
	public static void listarCarros() throws Exception {
	    System.out.println("\nListando Todos os Carros: \n");

	    // Listando todos os carros
	    List<Carro> carros = carroSql.listarTodos(); // Método que retorna todos os carros
	    if (carros.isEmpty()) {
	        System.out.println("Nenhum carro encontrado.");
	    } else {
	        for (Carro carro : carros) {
	            System.out.println("ID: " + carro.getId());
	            System.out.println("Marca: " + carro.getMarca());
	            System.out.println("Modelo: " + carro.getModelo());
	            System.out.println("Cor: " + carro.getCor());
	            System.out.println("Ano: " + carro.getAno());
	            System.out.println("Placa: " + carro.getPlaca());
	            System.out.println("Valor de Venda: " + carro.getValorVenda());
	            System.out.println("Quantidade de Portas: " + carro.getQuantPortas());
	            System.out.println("Tipo: " + carro.getTipo());
	            System.out.println("-----------------------------------");
	        }
	    }
	}
	public static void listarMotos() throws Exception {
	    System.out.println("\nListando Todas as Motos: \n");

	    // Listando todas as motos
	    List<Moto> motos = motoSql.listarTodos(); // Método que retorna todas as motos
	    if (motos.isEmpty()) {
	        System.out.println("Nenhuma moto encontrada.");
	    } else {
	        for (Moto moto : motos) {
	            System.out.println("ID: " + moto.getId());
	            System.out.println("Marca: " + moto.getMarca());
	            System.out.println("Modelo: " + moto.getModelo());
	            System.out.println("Cor: " + moto.getCor());
	            System.out.println("Ano: " + moto.getAno());
	            System.out.println("Placa: " + moto.getPlaca());
	            System.out.println("Valor de Venda: " + moto.getValorVenda());
	            System.out.println("Cilindrada: " + moto.getCilindrada());
	            System.out.println("-----------------------------------");
	        }
	    }
	}
	public static void listarCaminhoes() throws Exception {
	    System.out.println("\nListando Todos os Caminhões: \n");

	    // Listando todos os caminhões
	    List<Caminhao> caminhoes = caminhaoSql.listarTodos(); // Método que retorna todos os caminhões
	    if (caminhoes.isEmpty()) {
	        System.out.println("Nenhum caminhão encontrado.");
	    } else {
	        for (Caminhao caminhao : caminhoes) {
	            System.out.println("ID: " + caminhao.getId());
	            System.out.println("Marca: " + caminhao.getMarca());
	            System.out.println("Modelo: " + caminhao.getModelo());
	            System.out.println("Cor: " + caminhao.getCor());
	            System.out.println("Ano: " + caminhao.getAno());
	            System.out.println("Placa: " + caminhao.getPlaca());
	            System.out.println("Valor de Venda: " + caminhao.getValorVenda());
	            System.out.println("Toneladas de Carga: " + caminhao.getToneladasCarga());
	            System.out.println("-----------------------------------");
	        }
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
                    serviceProprietario.cadastrarProprietario(proprietario);
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
                    //Proprietario delProprietario = serviceProprietario.buscarProprietario(cpfDel);
                    Proprietario delProprietarioSql = serviceProprietarioSQL.pesquisarPorprietario(cpfDel);
            
                    //if (delProprietario == null) {
                    //    throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpfDel + " não foi encontrado.");
                    //}
                    if(delProprietarioSql ==null ){
                        throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpfDel + " não foi encontrado.");
                    }
            
                    //serviceProprietario.removerProprietario(delProprietario);
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
                    //Proprietario proprietarioMudar = serviceProprietario.buscarProprietario(cpf);
                    Proprietario proprietarioMudarSQL = serviceProprietarioSQL.pesquisarPorprietario(cpf);
            
                    //if (proprietarioMudar == null) {
                    //    throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
                    //}
                    if(proprietarioMudarSQL == null){
                        throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
                    }
            
                    System.out.println("Digite o novo CPF: ");
                    String newCpf = scanner.nextLine();
                    System.out.println("Digite o Novo Nome: ");
                    String nome = scanner.nextLine();
                    System.out.println("Digite a Nova Idade: ");
                    int idade = Integer.parseInt(scanner.nextLine());
                    System.out.println("Digite o Novo Telefone de Contato: ");
                    String telefoneContato = scanner.nextLine();
                    System.out.println("Digite o Novo Endereço: ");
                    String endereco = scanner.nextLine();
            
                    
                    //proprietarioMudar.setNome(nome);
                    proprietarioMudarSQL.setNome(nome);
                    //proprietarioMudar.setIdade(idade);
                    proprietarioMudarSQL.setIdade(idade);
                    //proprietarioMudar.setTelefoneContato(telefoneContato);
                    proprietarioMudarSQL.setTelefoneContato(telefoneContato);
                    //proprietarioMudar.setEndereco(endereco);
                    proprietarioMudarSQL.setEndereco(endereco);
                    //proprietarioMudar.setCpf(newCpf);
                    proprietarioMudarSQL.setCpf(newCpf);
            
                    //serviceProprietario.atualizarProprietario(proprietarioMudar);
                    serviceProprietarioSQL.alterarProp(proprietarioMudarSQL, cpf);
            
                    System.out.println("Proprietário Atualizado com Sucesso!");
            
                } catch (ProprietarioNaoEncontradoException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                }
            }
            
            public static void buscarProprietario() {
                System.out.println("Digite o CPF do Proprietário que você deseja Buscar:");
                String cpf = scanner.nextLine();
            
                try {
                    //Proprietario proprietarioBuscar = serviceProprietario.buscarProprietario(cpf);
                    Proprietario proprietarioBuscarSql = serviceProprietarioSQL.pesquisarPorprietario(cpf);
            
                    //if (proprietarioBuscar == null) {
                    //    throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
                    //}
                    if(proprietarioBuscarSql == null){
                        throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
                    }
            
                    //System.out.println("Proprietário Encontrado: " + proprietarioBuscar.getNome());
                    System.out.println("Proprietário Encontrado: " + proprietarioBuscarSql.getNome());

                } catch (ProprietarioNaoEncontradoException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro inesperado: " + e.getMessage());
                }
            }
            
            public static void listarProprietarios() throws SQLException {
                /*ArrayList<Proprietario> proprietarios = serviceProprietario.verProprietario();
                if(proprietarios.isEmpty()){
                    System.out.println("Não há Proprietários Cadastrados.");
                } else {
                    for(Proprietario p : proprietarios){
                        System.out.println(p);
                    }
                }*/
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
                    Proprietario proprietario = serviceProprietario.buscarProprietario(cpf);
            
                    if (proprietario == null) {
                        throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
                    }
            
                    System.out.println("Digite a Placa do Carro: ");
                    String placa = scanner.nextLine();
            
                    Carro carro = serviceCarro.buscarCarro(placa); // Busca pelo carro
            
                    if (carro == null) {
                        throw new CarroNaoEncontradoException("Carro com a placa " + placa + " não foi encontrado.");
                    }
            
                    serviceVenda.venderCarro(placa, proprietario);
                    System.out.println("Carro vendido com sucesso!");
            
                } catch (ProprietarioNaoEncontradoException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (CarroNaoEncontradoException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro inesperado ao realizar a venda: " + e.getMessage());
                }
            }
            
            public static void realizarVendaMoto() {
                System.out.println("Digite o CPF do Proprietário: ");
                String cpf = scanner.nextLine();
            
                try {
                    Proprietario proprietario = serviceProprietario.buscarProprietario(cpf);
            
                    if (proprietario == null) {
                        throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
                    }
            
                    System.out.println("Digite a Placa da Moto: ");
                    String placa = scanner.nextLine();
            
                    Moto moto = serviceMoto.buscarMoto(placa); // Busca pela moto
            
                    if (moto == null) {
                        throw new MotoNaoEncontradaException("Moto com a placa " + placa + " não foi encontrada.");
                    }
            
                    serviceVenda.venderMoto(placa, proprietario);
                    System.out.println("Moto vendida com sucesso!");
            
                } catch (ProprietarioNaoEncontradoException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (MotoNaoEncontradaException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro inesperado ao realizar a venda: " + e.getMessage());
                }
            }
            
            public static void realizarVendaCaminhao() {
                System.out.println("Digite o CPF do Proprietário: ");
                String cpf = scanner.nextLine();
            
                try {
                    Proprietario proprietario = serviceProprietario.buscarProprietario(cpf);
            
                    if (proprietario == null) {
                        throw new ProprietarioNaoEncontradoException("Proprietário com o CPF " + cpf + " não foi encontrado.");
                    }
            
                    System.out.println("Digite a Placa do Caminhão: ");
                    String placa = scanner.nextLine();
            
                    Caminhao caminhao = serviceCaminhao.buscarCaminhao(placa); // Busca pelo caminhão
            
                    if (caminhao == null) {
                        throw new CaminhaoNaoEncontradoException("Caminhão com a placa " + placa + " não foi encontrado.");
                    }
            
                    serviceVenda.venderCaminhao(placa, proprietario);
                    System.out.println("Caminhão vendido com sucesso!");
            
                } catch (ProprietarioNaoEncontradoException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (CaminhaoNaoEncontradoException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Ocorreu um erro inesperado ao realizar a venda: " + e.getMessage());
                }
            }
            

            public static void removerVenda() {
                System.out.println("Digite o ID da Venda a ser removida: ");
                int id = Integer.parseInt(scanner.nextLine());
            
                try {
                    Venda venda = serviceVenda.buscarVendaPorId(id);
            
                    if (venda == null) {
                        throw new VendaNaoEncontradaException("Venda com o ID " + id + " não foi encontrada.");
                    }
            
                    serviceVenda.removerVenda(id);
                    System.out.println("Venda removida com sucesso!");
            
                } catch (VendaNaoEncontradaException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Erro ao remover venda: " + e.getMessage());
                }
            }
            
            public static void atualizarVenda() {
                System.out.println("Digite o ID da Venda a ser atualizada: ");
                int id = Integer.parseInt(scanner.nextLine());
            
                try {
                    Venda vendaExistente = serviceVenda.buscarVendaPorId(id);
            
                    if (vendaExistente == null) {
                        throw new VendaNaoEncontradaException("Venda com o ID " + id + " não foi encontrada.");
                    }
            
                    System.out.println("Digite o CPF do novo proprietário (ou mantenha o anterior): ");
                    String cpfNovo = scanner.nextLine();
                    Proprietario novoProprietario = serviceProprietario.buscarProprietario(cpfNovo);
            
                    vendaExistente.setProprietario(novoProprietario);
            
                    serviceVenda.atualizarVenda(id, vendaExistente);
                    System.out.println("Venda atualizada com sucesso!");
            
                } catch (VendaNaoEncontradaException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Erro ao atualizar venda: " + e.getMessage());
                }
            }
            
            public static void buscarVenda() {
                System.out.println("Digite o ID da Venda: ");
                int id = Integer.parseInt(scanner.nextLine());
            
                try {
                    Venda venda = serviceVenda.buscarVendaPorId(id);
            
                    if (venda == null) {
                        throw new VendaNaoEncontradaException("Venda com o ID " + id + " não foi encontrada.");
                    }
            
                    System.out.println("Venda ID: " + venda.getId() + " - Proprietário: " + venda.getProprietario().getNome());
                    System.out.println("Veículos Vendidos: ");
                    for (Veiculo veiculo : venda.getVeiculosVendidos()) {
                        System.out.println(" - " + veiculo.getPlaca() + " (" + veiculo.getClass().getSimpleName() + ")");
                    }
            
                } catch (VendaNaoEncontradaException e) {
                    System.out.println("Erro: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("Erro ao buscar venda: " + e.getMessage());
                }
            }
            
            
            public static void listarVendas() {
                List<Venda> vendas = serviceVenda.listarVendas();
                if (vendas.isEmpty()) {
                    System.out.println("Nenhuma venda registrada.");
                } else {
                    for (Venda venda : vendas) {
                        System.out.println("Venda ID: " + venda.getId() + " - Proprietário: " + venda.getProprietario().getNome());
                        System.out.println("Veículos Vendidos: ");
                        for (Veiculo veiculo : venda.getVeiculosVendidos()) {
                            System.out.println(" - " + veiculo.getPlaca() + " (" + veiculo.getClass().getSimpleName() + ")");
                        }
                    }
                }
            }    
        }

