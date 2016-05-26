DROP DATABASE IF EXISTS remapbd_web; 

CREATE DATABASE remapbd_web;

USE remapbd_web;

-- select * from tb_usuario;

 --  truncate tb_cliente; -- drop table tb_venda;
	
CREATE TABLE tb_cliente(
	id_cliente    SMALLINT UNSIGNED UNIQUE KEY AUTO_INCREMENT,
	nome_cliente  VARCHAR(100) NOT NULL ,
    fone_cliente  VARCHAR(12) NULL,
    CONSTRAINT pk_cliente PRIMARY KEY(id_cliente)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;


CREATE TABLE tb_produto(
	cod_produto    SMALLINT UNSIGNED AUTO_INCREMENT,
    nome_produto   VARCHAR(50) NOT NULL,
    preco          DECIMAL(10,2) NOT NULL,
    descricao      VARCHAR(200) NOT NULL,
    quantidade     SMALLINT NOT NULL,
    CONSTRAINT pk_produto PRIMARY KEY(cod_produto)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

CREATE TABLE tb_usuario(
	cod_usuario    SMALLINT UNSIGNED AUTO_INCREMENT,
	nome_usuario   VARCHAR(50) NOT NULL,
	senha_usuario  VARCHAR(30) NOT NULL,
	CONSTRAINT pk_usuario PRIMARY KEY(cod_usuario)
)ENGINE=InnoDB DEFAULT CHARSET=utf8;
 
 
 CREATE TABLE tb_venda(
	codigo_venda   SMALLINT UNSIGNED AUTO_INCREMENT,
    id_cliente     SMALLINT UNSIGNED NOT NULL,
    data_venda     DATETIME NOT NULL,
    CONSTRAINT pk_venda PRIMARY KEY(codigo_venda)
 )ENGINE = InnoDB DEFAULT CHARSET=utf8;
 
 ALTER TABLE tb_venda ADD CONSTRAINT fk_cliente FOREIGN KEY(id_cliente) REFERENCES tb_cliente(id_cliente);
 
 CREATE TABLE tb_itens_venda(
	codigo_venda     SMALLINT UNSIGNED NOT NULL,
    cod_produto      SMALLINT UNSIGNED NOT NULL,
    quantidade_item  SMALLINT UNSIGNED NOT NULL,
    CONSTRAINT pk_itens_venda PRIMARY KEY( codigo_venda , cod_produto )
 )ENGINE = InnoDB DEFAULT CHARSET=utf8;
 
 ALTER TABLE tb_itens_venda ADD CONSTRAINT fk_venda FOREIGN KEY(codigo_venda) REFERENCES tb_venda(codigo_venda); 

ALTER TABLE tb_itens_venda  ADD CONSTRAINT fk_produto FOREIGN KEY(cod_produto) REFERENCES tb_produto(cod_produto);

/*

use remapbd_web;
select * from tb_funcionario;

CREATE TABLE tb_funcionario (
	cod_funcionario INT UNSIGNED AUTO_INCREMENT ,
    nome_funcionario VARCHAR(100) NOT NULL,
    senha_funcionario VARCHAR(20) NOT NULL,
    ativo BOOLEAN NOT NULL,
    cargo_funcionario VARCHAR(30) NOT NULL,
    data_cadastro DATE,
    CONSTRAINT pk_funcionario  PRIMARY KEY(cod_funcionario) 
);

select * from tb_fornecedor;



CREATE TABLE tb_fornecedor(
	id_fornecedor   	SMALLINT UNIQUE KEY AUTO_INCREMENT,
	cnpj_fornecedor 	VARCHAR(18) NOT NULL,
    nome_fornecedor 	VARCHAR(60) NOT NULL,
    rua_fornecedor  	VARCHAR(60) NOT NULL,
    bairro_fornecedor 	VARCHAR(60) NOT NULL,
    cep_fornecedor      VARCHAR(18) NOT NULL,
    cidade_fornecedor   VARCHAR(60) NOT NULL,
    pais_fornecedor     VARCHAR(60) NOT NULL,
    data_cadastro DATE NOT NULL,
     -- porte_fornecedor varchar(10) ,
    -- fornec varchar (30), -- fornecimento ( o que o fornecedor irá nos fornecer )
    CONSTRAINT pk_fonrcedor PRIMARY KEY( cnpj_fornecedor ) 
);

use remapbd_web;

CREATE TABLE tb_produto(
	cod_produto   SMALLINT UNSIGNED AUTO_INCREMENT ,
    nome_produto  VARCHAR(30) NOT NULL,
    descricao_produto     VARCHAR(200) NOT NULL,
	quantidade_produto    SMALLINT NOT NULL,
    preco_venda   DOUBLE NOT NULL,
    preco_compra  DOUBLE NOT NULL,
   -- cnpj_fornecedor VARCHAR(18) NOT NULL,
    CONSTRAINT pk_produto PRIMARY KEY( cod_produto )
);

*/




USE remapbd_web;