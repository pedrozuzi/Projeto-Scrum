drop database livrariadigital

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
cep varchar(8) not null,
uf varchar(2) not null,
cidade varchar(100) not null,
bairro varchar(100) not null,
rua varchar(100) not null,
numero int not null,
compl varchar(10),
tel varchar(11) not null,
cnpj varchar(14) not null,

--primary key(cnpj), --verificar
primary key(id)
)

create table livro(
id int not null identity,
idautor int not null,
ideditora int not null,
titulo varchar(30),
isbn decimal (13),
paginas int,
edicao int,
tipocapa varchar(10),
--info editora
ano decimal (4),
assunto varchar(40),
idioma varchar(40),
imagem varchar(max),
--resumo
--sumario
foreign key (idautor) references autor(id),
foreign key (ideditora) references editora(id),
primary key(id)
)

drop table livro
drop table editora
drop table autor

INSERT INTO autor VALUES ('George Orwell', '25/06/1903', '21/01/1950', 'Londres, Reino Unido')

INSERT INTO editora VALUES ('Companhia das Letras', '04532002' ,'SP','São Paulo','bairro', 'R. Bandeira Paulista', 702 ,'complement', '1137073500' , '55789390000112')

INSERT INTO livro VALUES (1,3,'1984',9780141182957,414,1,'brochura',1949,'ficção científica distópica','Português')

select* from livro
select * from autor
select * from editora
