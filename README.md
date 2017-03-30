GScrum
======

Novo projeto de gerenciamento de atividades em sprints.

Feito com:

+ Java 1.7
+ SpringMVC
+ JDBC com DAO
+ JSP e JSTL

OBS
===

Nao versionar codigos compilados, temporarios ou especificos de alguma IDE. Por exemplo:
- a pasta build ou settings do eclipse.
- os arquivos .project ou .classpath do eclipse.
- o arquivo nb-configuration.xml do netbeans.
- a pasta target do maven.

Esses arquivos nao precisam serem versionados, e podem dar problema entre IDEs distintas nos desenvolvedores da equipe.

Usar encodding UTF-8 em todos os arquivos.

PARA EXECUTAR
=============

NetBeans:

+ Indique para a IDE abrir a pasta raiz do projeto (a que contem o arquivo pom.xml).
+ Clique com o botão direito e escolha "Limpar e Construir". Neste momento o maven irá através da internet aos seus repositórios baixar os jars.
+ Ao final com sucesso, peça para Executar com o Tomcat.
