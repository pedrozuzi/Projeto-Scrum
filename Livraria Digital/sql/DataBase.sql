use master
go
drop database livrariadigital
----------Query Estrutura das Tabelas--------------
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
cep varchar(9) not null,
uf varchar(2) not null,
cidade varchar(100) not null,
bairro varchar(100) not null,
rua varchar(100) not null,
numero int not null,
compl varchar(10),
tel varchar(14) not null,
cnpj varchar(18) not null,

--primary key(cnpj), --verificar
primary key(id)
)


create table categoria(
id int not null identity,
nome varchar(30),
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
preco decimal(7,2),
--resumo
--sumario
foreign key (idautor) references autor(id),
foreign key (ideditora) references editora(id),
primary key(id)
)

create table livrocategoria(
idlivro int not null,
idcategoria int not null,
foreign key (idlivro) references livro(id),
foreign key (idcategoria) references categoria(id),
)


--------------Inserts de Teste--------------------

INSERT INTO autor VALUES ('George Orwell', '25/06/1903', '21/01/1950', 'Londres, Reino Unido')

INSERT INTO editora VALUES ('Companhia das Letras', '04532002' ,'SP','São Paulo','bairro', 'R. Bandeira Paulista', 702 ,'complement', '1137073500' , '55789390000112')

INSERT INTO livro VALUES (1,1,'1984',9780141182957,414,1,'brochura',1949,'ficÃ§Ã£o cientÃ­fica distÃ³pica','PortuguÃªs','1984.jpg', 129.99),
(1,1,'aaaa',9780141182957,414,1,'brochura',1949,'ficÃ§Ã£o cientÃ­fica distÃ³pica','PortuguÃªs','1984.jpg',59.99),
(1,1,'bbb',9780141182957,414,1,'brochura',1949,'ficÃ§Ã£o cientÃ­fica distÃ³pica','PortuguÃªs','1984.jpg',25.00),
(1,1,'ccc',9780141182957,414,1,'brochura',1949,'ficÃ§Ã£o cientÃ­fica distÃ³pica','PortuguÃªs','1984.jpg',10.90),
(1,1,'ddd',9780141182957,414,1,'brochura',1949,'ficÃ§Ã£o cientÃ­fica distÃ³pica','PortuguÃªs','1984.jpg',99.99)

--
select* from livro
select * from autor
select * from editora

truncate table livro

-------------------------
Pesquisa de livros a partir de autor
--------------------------
create view v_livrocategoria
as
select liv.id, liv.titulo
from livro liv
inner join autor aut
on liv.idautor = aut.id
where aut.id = 1
group by liv.id, liv.titulo
-------------------------
Pesquisa de livros a partir da editora
-------------------------
select liv.id, liv.titulo
from livro liv
inner join editora ed
on liv.ideditora = ed.id
where ed.id = 1
order by ed.id
-------------------------
Pesquisa de livros a partir da categoria
-------------------------
select liv.id, liv.titulo
from livro liv
inner join livrocategoria lc
on liv.id = lc.idlivro
inner join categoria cat
on cat.id = lc.idcategoria
group by liv.id, liv.titulo
order by liv.id
-------------------------
Pesquisa de livros a partir do título
-------------------------
select * from livros where titulo like %''%
-------------------------
select id, nome, CONVERT(CHAR(10),datanasc,103) AS datanasc, CONVERT(CHAR(10),datafale,103) AS datafale, localmorte FROM autor