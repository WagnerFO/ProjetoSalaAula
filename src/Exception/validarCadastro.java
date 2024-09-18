package Exception;

import Entidades.Caminhao;
import Entidades.Carro;
import Entidades.Moto;
import Entidades.Proprietario;

public class validarCadastro {

    public static void validarProprietario(Proprietario proprietario)throws Exception{
        if(proprietario.getNome() == null || proprietario.getNome().trim().isEmpty()){
            throw new Exception("Nome do Proprietario é OBRIGATÓRIO!");
        }
        if(proprietario.getCpf() == null || proprietario.getCpf().trim().isEmpty()){
            throw new Exception("CPF do Proprietário é OBRIGATÓRIO!");
        }
        if(proprietario.getIdade() < 18 ) {
        	throw new Exception("Idade do Proprietário deve ser maior que 18 anos.");
        }
    }

    public static void validarCarro(Carro carro) throws Exception{
        if(carro.getModelo() == null || carro.getModelo().trim().isBlank()){
            throw new Exception("Modelo do carro é OBRIGATÓRIO!");
        }
        if(carro.getMarca() == null || carro.getMarca().trim().isEmpty()){
            throw new Exception("Marca do carro é OBRIGATÓRIO!");
        }
        if(carro.getCor() == null || carro.getCor().trim().isEmpty()){
            throw new Exception ("Cor do carro é OBRIGATÓRIA!");
        }
        if(carro.getProprietario() == null ){
            throw new Exception ("Carro deve possuir um proprietario! ");
        }
    }

    public static void validarMoto(Moto moto) throws Exception {
        if(moto.getModelo() == null || moto.getModelo().trim().isBlank()) {
            throw new Exception("Modelo da moto é OBRIGATÓRIO!");
        }
        if(moto.getMarca() == null || moto.getMarca().trim().isEmpty()) {
            throw new Exception("Marca da moto é OBRIGATÓRIA!");
        }
        if(moto.getCor() == null || moto.getCor().trim().isEmpty()) {
            throw new Exception ("Cor da moto é OBRIGATÓRIA!");
        }
        if(moto.getProprietario() == null) {
            throw new Exception ("Moto deve possuir um proprietário!");
        }
    }
    
    public static void validarCaminhao(Caminhao caminhao) throws Exception {
        if(caminhao.getModelo() == null || caminhao.getModelo().trim().isBlank()) {
            throw new Exception("Modelo do caminhão é OBRIGATÓRIO!");
        }
        if(caminhao.getMarca() == null || caminhao.getMarca().trim().isEmpty()) {
            throw new Exception("Marca do caminhão é OBRIGATÓRIA!");
        }
        if(caminhao.getCor() == null || caminhao.getCor().trim().isEmpty()) {
            throw new Exception ("Cor do caminhão é OBRIGATÓRIA!");
        }
        if(caminhao.getProprietario() == null) {
            throw new Exception ("Caminhão deve possuir um proprietário!");
        }
    }

}
