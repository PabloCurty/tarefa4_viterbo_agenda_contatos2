CREATE SCHEMA `agenda_contatos` ;

/*Rode a aplica��o, para criar as tabelas*/

/*Coloquei usuario como unique na m�o, mas j� alterei no modelo pra criar dessa forma*/
ALTER table usuario ADD UNIQUE (USERNAME);

