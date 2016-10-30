CREATE SCHEMA `agenda_contatos` ;

/*Rode a aplicação, para criar as tabelas*/

/*Coloquei usuario como unique na mão, mas já alterei no modelo pra criar dessa forma*/
ALTER table usuario ADD UNIQUE (USERNAME);

