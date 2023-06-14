CREATE TABLE candidato (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(60),
    sexo CHAR,
    data_nasc DATE,
    cargo_pretendido VARCHAR(25),
    texto_curriculo VARCHAR(800)
);
