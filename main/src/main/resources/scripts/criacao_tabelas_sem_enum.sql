

CREATE TYPE visibilidade AS ENUM ('ATIVO', 'INATIVO');
CREATE TYPE status_atualizacao AS ENUM ('ATUALIZADO', 'DESATUALIZADO');

CREATE TABLE aplicacao.USUARIO(
                                  ID_USUARIO UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                  NOME_USUARIO VARCHAR(120) NOT NULL,
                                  EMAIL VARCHAR(120) NOT NULL,
                                  DATA_NASCIMENTO DATE NOT NULL,
                                  CPF_CNPJ VARCHAR(18) NOT NULL,
                                  FK_ID_PLANO UUID,
                                  FK_ID_CARDAPIO SERIAL,
                                  SENHA VARCHAR(21) NOT NULL
);

CREATE TABLE aplicacao.PLANO(
                                ID_PLANO UUID PRIMARY KEY DEFAULT gen_random_uuid(),
                                NOME_PLANO VARCHAR(16) NOT NULL,
                                DESCRICAO_PLANO VARCHAR(230) NOT NULL,
                                VALOR_PLANO NUMERIC CHECK ( VALOR_PLANO >=0 ) NOT NULL,
                                ESTADO_PLANO VARCHAR(7) NOT NULL,
                                FK_ID_USUARIO UUID
);

CREATE TABLE aplicacao.CARDAPIO_EMPRESA(
                                           ID_CARDAPIO SERIAL PRIMARY KEY ,
                                           NOME_EMPRESA VARCHAR(26),
                                           DESCRICAO_EMPRESA VARCHAR(120),
                                           ESTADO_ATUALIZACAO VARCHAR(13),
                                           ULTIMA_ATUALIZACAO DATE,
                                           LINK_PAGINA VARCHAR(120),
                                           FK_ID_USUARIO UUID,
                                           FK_ID_CATEGORIA SERIAL
);

CREATE TABLE aplicacao.PRODUTO(
                                  ID_PRODUTO SERIAL PRIMARY KEY,
                                  NOME_PRODUTO VARCHAR(36) NOT NULL,
                                  DESCRICAO_PRODUTO VARCHAR(240) NOT NULL,
                                  ESTADO_PRODUTO VARCHAR(7) NOT NULL ,
                                  PRECO_PRODUTO NUMERIC CHECK ( PRECO_PRODUTO >=0 ) NOT NULL,
                                  FK_ID_CATEGORIA SERIAL
);

CREATE TABLE aplicacao.CARDAPIO_PRODUTO (
                                            FK_ID_PRODUTO SERIAL,
                                            FK_ID_CARDAPIO SERIAL,
                                            FOREIGN KEY (FK_ID_PRODUTO) REFERENCES aplicacao.PRODUTO(ID_PRODUTO),
                                            FOREIGN KEY (FK_ID_CARDAPIO) REFERENCES aplicacao.CARDAPIO_EMPRESA(ID_CARDAPIO)
);


CREATE TABLE aplicacao.CATEGORIA(
                                    ID_CATEGORIA SERIAL PRIMARY KEY,
                                    NOME_CATEGORIA VARCHAR(120) NOT NULL,
                                    VISIBILIDADE_CATEGORIA  VARCHAR(7) NOT NULL ,
                                    FK_ID_PRODUTO SERIAL null
);

--CONSTRAINTS USUARIO
ALTER TABLE aplicacao.USUARIO ADD CONSTRAINT FK_ID_PLANO FOREIGN KEY (FK_ID_PLANO) REFERENCES aplicacao.PLANO(ID_PLANO);
ALTER TABLE aplicacao.USUARIO ADD CONSTRAINT FK_ID_CARDAPIO FOREIGN KEY (FK_ID_CARDAPIO) REFERENCES aplicacao.CARDAPIO_EMPRESA(ID_CARDAPIO);
--CONSTRAINTS PLANO
ALTER TABLE aplicacao.PLANO ADD CONSTRAINT FK_ID_USUARIO FOREIGN KEY (FK_ID_USUARIO) REFERENCES aplicacao.USUARIO(ID_USUARIO);
--CONSTRAINTS CARDAPIO
ALTER TABLE aplicacao.CARDAPIO_EMPRESA ADD CONSTRAINT FK_ID_USUARIO FOREIGN KEY (FK_ID_USUARIO) REFERENCES aplicacao.USUARIO(ID_USUARIO);
ALTER TABLE aplicacao.CARDAPIO_EMPRESA ADD CONSTRAINT FK_ID_CATEGORIA FOREIGN KEY (FK_ID_CATEGORIA) REFERENCES aplicacao.CATEGORIA(ID_CATEGORIA);
--CONSTRAINTS PRODUTO
ALTER TABLE aplicacao.PRODUTO ADD CONSTRAINT FK_ID_CATEGORIA FOREIGN KEY (FK_ID_CATEGORIA) REFERENCES aplicacao.CATEGORIA(ID_CATEGORIA);
--CONTRAINTS CATEGORIA
ALTER TABLE aplicacao.CATEGORIA ADD CONSTRAINT FK_ID_PRODUTO FOREIGN KEY (FK_ID_PRODUTO) REFERENCES aplicacao.PRODUTO(ID_PRODUTO);