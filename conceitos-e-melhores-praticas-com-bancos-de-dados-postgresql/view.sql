SELECT numero, nome, ativo
FROM banco;

CREATE OR REPLACE VIEW vw_bancos AS (
	SELECT numero, nome, ativo
	FROM banco
);

SELECT numero, nome, ativo
FROM vw_bancos;


CREATE OR REPLACE VIEW vw_bancos_2 (banco_numero, banco_nome, banco_ativo) AS (
	SELECT numero, nome, ativo
	FROM banco
);

SELECT banco_numero, banco_nome, banco_ativo
FROM vw_bancos2;

INSERT INTO vw_bancos2 (banco_numero, banco_nome, banco_ativo)
VALUES (51, 'Banco Boa Ideia', TRUE);

SELECT banco_numero, banco_nome, banco_ativo
FROM vw_bancos_2
WHERE banco_numero = 51;

SELECT numero, nome, ativo
FROM banco
WHERE banco.numero = 51;

UPDATE vw_bancos_2
SET banco_ativo = FALSE
WHERE banco_numero = 51;

DELETE FROM vw_bancos_2
WHERE banco_numero = 51;



CREATE OR REPLACE TEMPORARY VIEW vw_agencia AS (
	SELECT nome FROM agencia
);

SELECT nome FROM vw_agencia;



CREATE OR REPLACE VIEW vw_bancos_ativos AS (
	SELECT numero, nome, ativo
	FROM banco
	WHERE ativo IS TRUE
--) WITH LOCAL CHECK OPTION;
) ;

-- Erro
INSERT INTO vw_bancos_ativos (numero, nome, ativo)
VALUES (51, 'Banco Boa Ideia', FALSE);

-- utilizar a view vw_bancos_ativos
CREATE OR REPLACE VIEW vw_bancos_com_a AS (
	SELECT numero, nome, ativo
	FROM vw_bancos_ativos
	WHERE nome ILIKE 'a%'
--) WITH LOCAL CHECK OPTION;
) WITH CASCADED CHECK OPTION;

SELECT numero, nome, ativo
FROM vw_bancos_com_a;

-- Erro começa com 'b'
INSERT INTO vw_bancos_com_a (numero, nome, ativo) VALUES (333, 'Beta Omega', TRUE);
-- Funciona começa com 'a'
INSERT INTO vw_bancos_com_a (numero, nome, ativo) VALUES (333, 'Alfa Omega', TRUE);
-- Erro ativo FALSE
-- Funciona sem o WITH LOCAL CHECK OPTION em vw_bancos_ativos
INSERT INTO vw_bancos_com_a (numero, nome, ativo) VALUES (331, 'Alfa Gama', FALSE);

-- valida ativo com CASCADED
INSERT INTO vw_bancos_com_a (numero, nome, ativo) VALUES (332, 'Alfa Gama Beta', FALSE);




--Recursive View

CREATE TABLE IF NOT EXISTS funcionarios (
	id SERIAL,
	nome VARCHAR(50),
	gerente INTEGER,
	PRIMARY KEY (id),
	FOREIGN KEY (gerente) REFERENCES funcionarios (id)
);

INSERT INTO funcionarios (nome, gerente) values ('Ancelmo', null);
INSERT INTO funcionarios (nome, gerente) values ('Beatriz', 1);
INSERT INTO funcionarios (nome, gerente) values ('Magno', 1);
INSERT INTO funcionarios (nome, gerente) values ('Cremilda', 2);
INSERT INTO funcionarios (nome, gerente) values ('Wagner', 4);

SELECT id, nome, gerente FROM funcionarios WHERE gerente IS NULL
UNION ALL
SELECT id, nome, gerente FROM funcionarios WHERE id = 999; -- apenas exemplo

CREATE OR REPLACE RECURSIVE VIEW vw_func (id, gerente, funcionario, gerente_nome) AS (
	SELECT f1.id, f1.gerente, f1.nome, f2.nome
	FROM funcionarios f1
	LEFT JOIN funcionarios f2 ON f2.id = f1.gerente
	WHERE f1.gerente IS NULL
		
	UNION ALL
	
	SELECT f1.id, f1.gerente, f1.nome, f2.nome
	FROM funcionarios f1
	JOIN vw_func ON vw_func.id = f1.gerente	
	LEFT JOIN funcionarios f2 ON f2.id = f1.gerente
);

SELECT id, gerente, funcionario, gerente_nome
FROM vw_func;



-- unique id for view
SELECT * FROM
( SELECT
    ROW_NUMBER() OVER (ORDER BY id ASC) AS ROW_NUMBER,
    id, nome, gerente
  FROM funcionarios
) myview_name;

