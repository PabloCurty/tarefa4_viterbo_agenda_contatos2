package model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
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
	
	@OneToMany(mappedBy="agenda", cascade={CascadeType.ALL})
	@OrderBy
	private Set<Contato> contatos;

	public Agenda(long id, Usuario id_usuario, Set<Contato> contatos) {
		super();
		this.id = id;
		//TODO fix no banco
		this.usuario = usuario;
		this.contatos = contatos;
	}
	
	public Agenda(long id, Usuario usuario) {
		super();
		this.id = id;
		this.usuario = usuario;
	}

	public Agenda() {
		super();
	}
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Set<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}

}
