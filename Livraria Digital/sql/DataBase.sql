create database livrariadigital
go
use livrariadigital



create table autor(
id int not null identity,
nome varchar(100) not null,
datanasc date not null,
datafale date,
localmorte varchar(100),
--biografia
primary key(id)
)

create table editora(

id int not null identity,
nome varchar(100) not null,
endereco varchar(100) not null,
tel varchar(11) not null,
cnpj varchar(12) not null,

--primary key(cnpj), --verificar
primary key(id)
)

create table livro(
id int not null identity,
idautor int not null,
ideditora int not null,
titulo varchar(30),
isbn varchar(12),
paginas varchar(4),
edicao varchar(4),
tipocapa varchar(10),
--info editora
ano varchar(4),
assunto varchar(40),
idioma varchar(40),
--resumo
--sumario
foreign key (idautor) references autor(id),
foreign key (ideditora) references editora(id),
primary key(id)
)

INSERT INTO autor VALUES 'George Orwell', '25/06/1903', '21/01/1950', 'Londres, Reino Unido'

INSERT INTO editora VALUES 'Companhia das Letras', 'R. Bandeira Paulista, 702, São Paulo - SP, 04532-002', '1137073500' , '55789390000112'