# Sistema de Gerenciamento de Veículos

## Descrição

Este projeto é um sistema de gerenciamento de veículos desenvolvido em Java, que oferece funcionalidades para o cadastro, remoção, busca, listagem, atualização e venda de carros, motos e caminhões. O sistema também permite a gestão de proprietários, possibilitando operações como cadastro, remoção e alteração de informações. Utilizando os princípios da programação orientada a objetos, o sistema é estruturado em classes, serviços, repositórios e exceções personalizadas.

## Funcionalidades

- **Cadastro de Proprietários**: Permite cadastrar, remover, buscar, listar e alterar informações de proprietários.
- **Cadastro de Veículos (Carros, Motos e Caminhões)**: 
  - Possibilita o cadastro, remoção, busca, listagem e alteração de informações de carros, motos e caminhões.
- **Operações de Venda**: Realiza a venda de veículos para proprietários.
- **Busca de Veículos por Diferentes Critérios**: Pesquisas baseadas em placa e outros atributos.
- **Tratamento de Exceções Personalizadas**: Exceções específicas como `CarroNaoEncontradoException`, `MotoNaoEncontradaException` e `CaminhaoNaoEncontradoException`, que gerenciam erros relacionados à busca de veículos.

## Estrutura do Projeto

### Classes Principais:

- **Veiculo**: Classe abstrata que define os atributos comuns dos veículos (id, marca, modelo, cor, ano, placa, valor de venda).
- **Carro**: Herda de `Veiculo` e inclui o atributo quantidade de portas.
- **Moto**: Herda de `Veiculo` e possui o atributo `cilindradas`.
- **Caminhao**: Herda de `Veiculo` e inclui o atributo `toneladasCarga`.
- **Pessoa**: Classe base que contém informações pessoais (nome, idade, CPF, telefone e endereço).
- **Proprietario**: Herda de `Pessoa` e possui atributos próprios, além de métodos relacionados à gestão de proprietários.

### Serviços:

- **ServiceCarro**, **ServiceMoto**, **ServiceCaminhao** e **ServiceProprietario**: Serviços responsáveis pelo cadastro, remoção, busca, listagem e atualização de veículos e proprietários.
- **ServiceVenda**: Serviço que gerencia a venda de veículos para proprietários.
  
### Repositórios:

Cada tipo de veículo e proprietário possui seu repositório específico, que armazena e gerencia as operações de dados. Os repositórios interagem com os serviços para realizar as funcionalidades do sistema.

### Exceções Personalizadas:

- **Exceções de Busca**: Como `CarroNaoEncontradoException`, `MotoNaoEncontradaException` e `CaminhaoNaoEncontradoException`, que são acionadas em caso de buscas sem resultados.

## Requisitos

- Java 8 ou superior
- IDE como IntelliJ IDEA, Eclipse ou qualquer editor de texto com suporte a Java


## Instrução de Excecução

1. Clone este repositório:
   ```bash
   git clone https://github.com/WagnerFO/ProjetoSalaAula
   ```