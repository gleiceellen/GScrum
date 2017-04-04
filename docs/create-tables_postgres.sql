DROP TABLE IF EXISTS pessoa;
CREATE TABLE pessoa (
  idPessoa SERIAL NOT NULL,
  nomePessoa varchar(255) DEFAULT NULL,
  telefonePessoa varchar(255) DEFAULT NULL,
  emailPessoa varchar(255) DEFAULT NULL,
  qualificacaoPessoa varchar(255) DEFAULT NULL,
  PRIMARY KEY (idPessoa)
);

DROP TABLE IF EXISTS projeto;
CREATE TABLE projeto (
  idProjeto SERIAL NOT NULL  ,
  descricaoProjeto varchar(255) DEFAULT NULL,
  nomeProjeto varchar(255) DEFAULT NULL,
  PRIMARY KEY (idProjeto)
);

DROP TABLE IF EXISTS membros;
CREATE TABLE membros (
  idMembro SERIAL NOT NULL  ,
  idPessoa bigint NOT NULL,
  idProjeto bigint DEFAULT NULL,
  PRIMARY KEY (idMembro),
  CONSTRAINT id_fk_membros_pessoa FOREIGN KEY (idPessoa) REFERENCES pessoa (idPessoa),
  CONSTRAINT id_fk_membros_projeto FOREIGN KEY (idProjeto) REFERENCES projeto (idProjeto)
);

DROP TABLE IF EXISTS sprints;
CREATE TABLE sprints (
  idSprint SERIAL NOT NULL  ,
  productBacklog varchar(255) DEFAULT NULL,
  estadoSprint varchar(255) DEFAULT NULL,
  dtInicioSprint varchar(255) DEFAULT NULL,
  dtFimSprint varchar(255) DEFAULT NULL,
  idProjeto bigint DEFAULT NULL,
  PRIMARY KEY (idSprint),
  CONSTRAINT id_fk_sprints_projeto FOREIGN KEY (idProjeto) REFERENCES projeto (idProjeto)
);

DROP TABLE IF EXISTS tarefa;
CREATE TABLE tarefa (
  idTarefa SERIAL NOT NULL  ,
  descricao varchar(255) DEFAULT NULL,
  finalizado boolean DEFAULT NULL,
  dataFinalizacao date DEFAULT NULL,
  idSprint bigint DEFAULT NULL,
  idPessoa bigint DEFAULT NULL,
  PRIMARY KEY (idTarefa),
  CONSTRAINT id_fk_tarefa_pessoa FOREIGN KEY (idPessoa) REFERENCES pessoa (idPessoa),
  CONSTRAINT id_fk_tarefa_sprint FOREIGN KEY (idSprint) REFERENCES sprints (idSprint)
);

DROP TABLE IF EXISTS usuario;
CREATE TABLE usuario (
  login varchar(255) NOT NULL,
  senha varchar(255) DEFAULT NULL,
  PRIMARY KEY (login)
);

INSERT INTO pessoa VALUES 
(8,'marcelo','45645','marcelo@gmail','analista'),
(9,'joao guilherme','488845','joagui@gmail','gerente'),
(10,'joao batista','9988845','joaobatista@gmail','design'),
(11,'Celine','685999','celine@gmail.com','developer'),
(13,'Mateus','65225','mateus@gmail.com','chefe');

INSERT INTO projeto VALUES 
(1,'sdfa','ga'),
(2,'Para de chorar','Joao Gui'),
(3,'vai dar certo','tente novamente');

INSERT INTO sprints VALUES (1,'cadastros','iniciado','','',NULL);

INSERT INTO tarefa VALUES 
(1,' \r\n                \r\n                \r\n                       Aprender spring\r\n     \r\n            \r\n            \r\n            ',false,'2017-03-28',NULL,NULL),
(2,' \r\n                \r\n               Aprender JSF\r\n        \r\n        \r\n            \r\n            \r\n            ',false,'2017-03-28',NULL,NULL),
(3,' \r\n                       Criar Diagrama de Classes\r\n       \r\n        \r\n            ',false,'2017-03-28',NULL,NULL),
(4,'                Criar Diagrama de Sequencia\r\n     \r\n        ',false,'2017-03-28',NULL,NULL),
(5,'                Desenvolver meu sistema\r\n     \r\n        ',true,'2017-03-28',NULL,NULL),
(6,'                Criar banco de dados\r\n        \r\n        ',true,'2017-03-28',NULL,NULL),
(7,'Criacao dos htmls',false,'2017-03-28',NULL,NULL),
(8,'Teste tamanho',false,'2017-03-28',NULL,NULL);
