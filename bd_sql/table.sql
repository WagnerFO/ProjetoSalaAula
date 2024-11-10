CREATE TABLE proprietarios(
	id INT NOT NULL AUTO_INCREMENT UNIQUE,
	nome VARCHAR(100) NOT NULL,
	idade INT NOT NULL,
	cpf VARCHAR(11) NOT NULL,
	telefoneContato VARCHAR(11) NOT NULL,
	endereco VARCHAR(250) NOT NULL,
	
	PRIMARY KEY(cpf),
	UNIQUE INDEX cpf (cpf ASC) VISIBLE
	);
	
	
CREATE TABLE carros(
	idCarro INT NOT NULL AUTO_INCREMENT UNIQUE,
	marca VARCHAR(45) NOT NULL,
	modelo VARCHAR(45) NOT NULL,
	cor VARCHAR(20) NOT NULL,
	ano YEAR NOT NULL,
	placa VARCHAR(8) NOT NULL,
	valorVenda DOUBLE(5,2) NOT NULL,
	quantPortas INT NOT NULL, 
	carroTipo ENUM('HATCH', 'SEDAN', 'SUV', 'SPORT'),
	
	PRIMARY KEY(placa),
	UNIQUE INDEX placa(placa ASC) VISIBLE
	);


CREATE TABLE motos(
	idMoto INT NOT NULL AUTO_INCREMENT UNIQUE,
	marca VARCHAR(45) NOT NULL,
	modelo VARCHAR(45) NULL NULL,
	cor VARCHAR(20) NOT NULL,
	ano YEAR NOT NULL,
	placa VARCHAR(8) NOT NULL,
	valorVenda DOUBLE(5,2) NOT NULL,
	cilindradas INT NOT NULL,
	motoTipo ENUM('URBANA', 'TRILHA', 'SPORT'),
	
	PRIMARY KEY (placa),
	UNIQUE INDEX (placa ASC)VISIBLE
	);


CREATE TABLE caminhoes(
	idCaminhao INT NOT NULL AUTO_INCREMENT UNIQUE,
	marca VARCHAR(45) NOT NULL,
	modelo VARCHAR(45) NULL NULL,
	cor VARCHAR(20) NOT NULL,
	ano YEAR NOT NULL,
	placa VARCHAR(8) NOT NULL,
	valorVenda DOUBLE(5,2) NOT NULL,
	toneladasCarga double(5,3) NOT NULL,
	caminhaoTipo ENUM('TRUCK', 'BITRUCK', 'CARRETA'),
	
	PRIMARY KEY (placa),
	UNIQUE INDEX (placa ASC)VISIBLE
	);
	
	
-- Criação da tabela venda_veiculo
CREATE TABLE venda_veiculo (
    id INT NOT NULL AUTO_INCREMENT,
    num_venda INT(4) NOT NULL,
    proprietario_cpf VARCHAR(11) NOT NULL,
    veiculo_placa VARCHAR(7) NOT NULL,
    
    PRIMARY KEY(num_venda),
    FOREIGN KEY(proprietario_cpf) REFERENCES proprietariosvenda_veiculo(cpf),
    FOREIGN KEY(veiculo_placa) REFERENCES carros(placa),
	FOREIGN KEY(veiculo_placa) REFERENCES motos(placa),
    FOREIGN KEY(veiculo_placa) REFERENCES caminhoes(placa),
    UNIQUE INDEX num_venda (num_venda ASC)  VISIBLE
);

-- Agora, o TRIGGER para gerar número aleatório antes de inserir na tabela venda_veiculo
DELIMITER //

CREATE TRIGGER before_insert_venda_veiculo
BEFORE INSERT ON venda_veiculo
FOR EACH ROW
BEGIN
    SET NEW.num_venda = FLOOR(1000 + (RAND() * 9000));  -- Gera número aleatório entre 1000 e 9999
END//

DELIMITER ;

