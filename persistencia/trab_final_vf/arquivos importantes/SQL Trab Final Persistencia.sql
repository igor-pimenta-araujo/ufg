CREATE TABLE Vacinas (
id serial PRIMARY KEY,
titulo varchar(60) NOT NULL,
descricao varchar(200) NOT NULL,
doses int NOT NULL,
periodicidade int NULL,
intervalo int NULL
);

CREATE TABLE Usuarios (
id serial PRIMARY KEY,
nome varchar(60) NOT NULL,
data_nascimento date NOT NULL,
sexo char(1) NOT NULL,
logradouro varchar(60) NULL,
numero int NULL,
setor varchar(40) NULL,
cidade varchar(40) NULL,
uf char(2) NOT NULL
);

CREATE TABLE Agendas (
id serial PRIMARY KEY,
data date NOT NULL,
hora time NOT NULL,
situacao INT NOT NULL,
vacina_id int NOT NULL,
FOREIGN KEY (vacina_id) REFERENCES Vacinas (id), 
usuario_id int NOT NULL,
FOREIGN KEY (usuario_id) REFERENCES Usuarios (id),
data_situacao date NULL,
observacoes varchar(200) NULL
);

CREATE TABLE Alergias (
id serial PRIMARY KEY,
nome varchar(40) NOT NULL
);

CREATE TABLE Usuarios_Alergias (
usuario_id int NOT NULL,
FOREIGN KEY (usuario_id) REFERENCES Usuarios (id),
alergia_id int NOT NULL,
FOREIGN KEY (alergia_id) REFERENCES Alergias (id)
);