--DROP SCHEMA aplicacao CASCADE;
SELECT * FROM aplicacao.usuario;

SELECT * FROM aplicacao.PLANO;

SELECT * FROM aplicacao.CARGO;

SELECT * FROM aplicacao.EMPRESA;

SELECT * FROM aplicacao.CATEGORIA;

SELECT * FROM aplicacao.PRODUTO;


CREATE TABLE aplicacao.USUARIO(
	ID_USUARIO UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	NOME_USUARIO VARCHAR(120) NOT NULL,
	EMAIL VARCHAR(120) NOT NULL,
	SENHA VARCHAR(21) NOT NULL,
	DATA_NASCIMENTO DATE NOT NULL,
	CPF_CNPJ VARCHAR(18) NOT NULL,
	TIPO_CONTA VARCHAR(16),
	ID_CARGO UUID,
	ID_PLANO UUID
)

CREATE TABLE aplicacao.PLANO(
	ID_PLANO UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	NOME_PLANO VARCHAR(16) NOT NULL,
	DESCRICAO_PLANO VARCHAR(230),
	VALOR_PLANO INT NOT NULL,
	ESTADO_PLANO VISIBILIDADE DEFAULT('ativo'),
	ID_USUARIO UUID
)

CREATE TABLE aplicacao.CARGO(
	ID_CARGO UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	NOME_CARGO VARCHAR(16),
	ID_USUARIO UUID
)

CREATE TABLE aplicacao.EMPRESA(
	ID_EMPRESA UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	NOME_EMPRESA VARCHAR(26),
	DESCRICAO_EMPRESA VARCHAR(120),
	ESTADO_ATUALIZACAO ESTATUS_ATUALIZACAO default('atualizado') NOT NULL,
	ULTIMA_ATUALIZACAO DATE NOT NULL,
	LINK_PAGINA VARCHAR(120),
	ID_USUARIO UUID
)

CREATE TABLE aplicacao.PRODUTO(
	ID_PRODUTO UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	NOME_PRODUTO VARCHAR(36),
	DESCRICAO_PRODUTO VARCHAR(240),
	ESTADO_PRODUTO VISIBILIDADE DEFAULT('ativo') NOT NULL,
	PRECO_PRODUTO INT,
	ID_CATEGORIA UUID
)

CREATE TABLE aplicacao.CATEGORIA(
	ID_CATEGORIA UUID PRIMARY KEY DEFAULT gen_random_uuid(),
	NOME_CATEGORIA VARCHAR(120),
	VISIBILIDADE_CATEGORIA VISIBILIDADE DEFAULT('ativo') NOT NULL
)



-- Inserir usuários
INSERT INTO aplicacao.USUARIO (NOME_USUARIO, EMAIL, SENHA, DATA_NASCIMENTO, CPF_CNPJ, TIPO_CONTA, ID_CARGO, ID_PLANO)
VALUES
  ('João Silva', 'joao.silva@email.com', 'senha123', '1990-05-15', '123.456.789-00', 'Pessoal', NULL, NULL),
  ('Maria Oliveira', 'maria.oliveira@email.com', 'senha456', '1985-03-20', '987.654.321-00', 'Corporativo', NULL, NULL);

-- Inserir planos
INSERT INTO aplicacao.PLANO (NOME_PLANO, DESCRICAO_PLANO, VALOR_PLANO, ESTADO_PLANO, ID_USUARIO)
VALUES
  ('Plano Básico', 'Plano de acesso básico', 50, 'ativo', '1f82b62a-93ad-4b0b-9c11-22d6b83ac01f'), -- Exemplo de ID_USUARIO (UUID)
  ('Plano Premium', 'Plano completo com vantagens', 150, 'ativo', '6d5b7c19-704e-4090-bc87-6d1b7d3f1407'); -- Exemplo de ID_USUARIO (UUID)

-- Inserir cargos
INSERT INTO aplicacao.CARGO (NOME_CARGO, ID_USUARIO)
VALUES
  ('Gerente', '1f82b62a-93ad-4b0b-9c11-22d6b83ac01f'), -- Exemplo de ID_USUARIO (UUID)
  ('Assistente', '6d5b7c19-704e-4090-bc87-6d1b7d3f1407'); -- Exemplo de ID_USUARIO (UUID)

-- Inserir empresas
INSERT INTO aplicacao.EMPRESA (NOME_EMPRESA, DESCRICAO_EMPRESA, ESTADO_ATUALIZACAO, ULTIMA_ATUALIZACAO, LINK_PAGINA, ID_USUARIO)
VALUES
  ('Comida Rápida Ltda', 'Restaurante especializado em fast food', 'atualizado', '2025-03-25', 'https://comidarapida.com', '1f82b62a-93ad-4b0b-9c11-22d6b83ac01f'), -- Exemplo de ID_USUARIO (UUID)
  ('Sabor Caseiro', 'Restaurante de comida caseira', 'atualizado', '2025-03-25', 'https://saborcaseiro.com', '6d5b7c19-704e-4090-bc87-6d1b7d3f1407'); -- Exemplo de ID_USUARIO (UUID)

-- Inserir categorias
INSERT INTO aplicacao.CATEGORIA (NOME_CATEGORIA, VISIBILIDADE_CATEGORIA)
VALUES
  ('Fast Food', 'ativo'),
  ('Comida Caseira', 'ativo');

-- Inserir produtos
INSERT INTO aplicacao.PRODUTO (NOME_PRODUTO, DESCRICAO_PRODUTO, ESTADO_PRODUTO, PRECO_PRODUTO, ID_CATEGORIA)
VALUES
  ('Hambúrguer', 'Delicioso hambúrguer de carne com queijo, alface e molho especial', 'ativo', 20, 'c06f3d94-ef7e-4c1b-84a1-bb78ff7a2d2a'), -- Exemplo de ID_CATEGORIA (UUID)
  ('Batata Frita', 'Porção de batatas fritas crocantes', 'ativo', 10, 'c06f3d94-ef7e-4c1b-84a1-bb78ff7a2d2a'), -- Exemplo de ID_CATEGORIA (UUID)
  ('Feijão Tropeiro', 'Feijão tropeiro com arroz, carne de sol e farofa', 'ativo', 25, '42cfb90e-f995-4a24-9db8-998e82ff2ff0'), -- Exemplo de ID_CATEGORIA (UUID)
  ('Frango Assado', 'Frango assado ao forno com batatas', 'ativo', 30, '42cfb90e-f995-4a24-9db8-998e82ff2ff0'); -- Exemplo de ID_CATEGORIA (UUID)
