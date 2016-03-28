DROP DATABASE IF EXISTS remapbd_web; 

CREATE DATABASE remapbd_web;

USE remapbd_web;

-- entidades ainda não estão de acordo com o sistema

CREATE TABLE tb_cliente(
	id_cliente    SMALLINT UNSIGNED UNIQUE KEY AUTO_INCREMENT,
	nome_cliente  VARCHAR(100) NOT NULL ,
    fone_cliente  VARCHAR(12) NULL,
    CONSTRAINT pk_cliente PRIMARY KEY(id_cliente)
);


CREATE TABLE tb_produto(
	cod_produto SMALLINT UNSIGNED AUTO_INCREMENT,
    nome_produto   VARCHAR(50) NOT NULL,
    preco          DECIMAL(10,2) NOT NULL,
    
    CONSTRAINT pk_produto PRIMARY KEY(cod_produto)
);


CREATE TABLE tb_usuario(
	cod_usuario    SMALLINT UNSIGNED AUTO_INCREMENT,
	nome_usuario   VARCHAR(50) NOT NULL,
	senha_usuario  VARCHAR(20) NOT NULL,
	CONSTRAINT pk_usuario PRIMARY KEY(cod_usuario)
);

show tables;

/*
	######   em desenvolvimento               #####
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
