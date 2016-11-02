package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-02T02:41:34.829-0200")
@StaticMetamodel(Contato.class)
public class Contato_ {
	public static volatile SingularAttribute<Contato, Long> id;
	public static volatile SingularAttribute<Contato, String> nome;
	public static volatile SingularAttribute<Contato, String> email;
	public static volatile SingularAttribute<Contato, Agenda> agenda;
	public static volatile SingularAttribute<Contato, String> logradouro;
	public static volatile SingularAttribute<Contato, String> complemento;
	public static volatile SingularAttribute<Contato, String> bairro;
	public static volatile SingularAttribute<Contato, String> cidade;
	public static volatile SingularAttribute<Contato, String> uf;
	public static volatile SingularAttribute<Contato, String> cep;
	public static volatile SingularAttribute<Contato, String> telefone;
	public static volatile SingularAttribute<Contato, String> celular;
	public static volatile SingularAttribute<Contato, String> operadora;
	public static volatile SingularAttribute<Contato, String> ddi;
	public static volatile SingularAttribute<Contato, String> ddd;
	public static volatile SingularAttribute<Contato, Boolean> editavel;
}
