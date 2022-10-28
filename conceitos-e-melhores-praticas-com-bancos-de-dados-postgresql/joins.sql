
SELECT COUNT(1) FROM banco; --151
SELECT COUNT(1) FROM agencia; --296

-- 296
SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero;

SELECT COUNT(DISTINCT banco.numero)
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero;

SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
FROM banco
LEFT JOIN agencia ON agencia.banco_numero = banco.numero;

SELECT agencia.numero, agencia.nome, banco.numero, banco.nome
FROM agencia
RIGHT JOIN banco ON banco.numero = agencia.banco_numero;

SELECT agencia.numero, agencia.nome, banco.numero, banco.nome
FROM agencia
LEFT JOIN banco ON banco.numero = agencia.banco_numero;


SELECT banco.numero, banco.nome, agencia.numero, agencia.nome
FROM banco
FULL JOIN agencia ON agencia.banco_numero = banco.numero;




CREATE TABLE IF NOT EXISTS teste_a (
	id SERIAL PRIMARY KEY,
	valor VARCHAR(10)
);

CREATE TABLE IF NOT EXISTS teste_b (
	id SERIAL PRIMARY KEY,
	valor VARCHAR(10)
);

INSERT INTO teste_a (valor) values ('teste1');
INSERT INTO teste_a (valor) values ('teste2');
INSERT INTO teste_a (valor) values ('teste3');
INSERT INTO teste_a (valor) values ('teste4');

INSERT INTO teste_b (valor) values ('teste_a');
INSERT INTO teste_b (valor) values ('teste_b');
INSERT INTO teste_b (valor) values ('teste_c');
INSERT INTO teste_b (valor) values ('teste_d');

SELECT tbla.valor, tblb.valor
FROM teste_a tbla
CROSS JOIN teste_b tblb;

DROP TABLE IF EXISTS teste_a;
DROP TABLE IF EXISTS teste_b;


SELECT	banco.nome,
		agencia.nome,
		conta_corrente.numero,
		conta_corrente.digito,
		cliente.nome
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero
JOIN conta_corrente
	-- ON conta_corrente.banco_numero = agencia.banco_numero
	ON conta_corrente.banco_numero = banco.numero
	AND conta_corrente.agencia_numero = agencia.numero
JOIN cliente ON cliente.numero = conta_corrente.cliente_numero;


SELECT
banco.nome as banco_nome,
agencia.nome as agencia_nome,
conta_corrente.numero as conta_corrente_numero,
conta_corrente.digito as conta_corrente_digito,
cliente.nome as cliente_nome,
cliente_transacoes.valor as cliente_transacoes_valor,
tipo_transacao.nome as tipo_transacao_nome
FROM banco
JOIN agencia ON agencia.banco_numero = banco.numero
JOIN conta_corrente	
	ON conta_corrente.banco_numero = banco.numero
	AND conta_corrente.agencia_numero = agencia.numero
JOIN cliente ON cliente.numero = conta_corrente.cliente_numero
JOIN cliente_transacoes
	ON cliente_transacoes.banco_numero = banco.numero
	AND cliente_transacoes.agencia_numero = agencia.numero
	AND cliente_transacoes.conta_corrente_numero = conta_corrente.numero
	AND cliente_transacoes.conta_corrente_digito = conta_corrente.digito
	AND cliente_transacoes.cliente_numero = cliente.numero
JOIN tipo_transacao ON tipo_transacao.id = cliente_transacoes.tipo_transacao_id
WHERE cliente.nome ILIKE '%verónica%'
ORDER BY conta_corrente.numero, conta_corrente.digito;










