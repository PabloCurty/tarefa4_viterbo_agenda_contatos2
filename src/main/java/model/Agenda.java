package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "AGENDA")
@SequenceGenerator(name = "SEQUENCIA_AGENDA", sequenceName = "SEQ_AGENDA", allocationSize = 1)
public class Agenda implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCIA_AGENDA")
	@Column(name = "ID_AGENDA")
	private long id;
	
	@Column(name = "USUARIO")
	private Usuario usuario;
	
	Set<Contato> contatos;

	public Agenda() {
		super();
	}
	
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getDono() {
		return usuario;
	}

	public void setDono(Usuario dono) {
		this.usuario = dono;
	}

	public Set<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}

}
