package model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2016-11-02T00:31:31.581-0200")
@StaticMetamodel(Agenda.class)
public class Agenda_ {
	public static volatile SingularAttribute<Agenda, Long> id;
	public static volatile SingularAttribute<Agenda, Usuario> usuario;
	public static volatile SetAttribute<Agenda, Contato> contatos;
}
