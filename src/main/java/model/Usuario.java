package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.OrderBy;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

//TODO discutir abaixo
//AgendaDono deve conter seu username e password para que o mesmo possa muda-lo caso queira
//Uma classe login talvez nao seja necessaria, uma vez que isso eh uma consulta ao banco

@Entity
@Table(name="USUARIO")
@SequenceGenerator(name="SEQUENCIA_USUARIO",
				   sequenceName="SEQ_USUARIO",
				   allocationSize=1)
public class Usuario implements Serializable{

	private static final long serialVersionUID = 1L;
		
	/*------------- atributos do objeto ------------- */
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY, generator="SEQUENCIA_USUARIO")
	@Column(name="ID_USUARIO")
	private long id_ususario;
	@Column(name="NOME_USUARIO", nullable=false)
	private String nome_usuario;
	@Column(name="EMAIL_USUARIO", nullable=false)
	private String email;
	@Column(name="USERNAME_USUARIO", nullable=false)
	private String username;
	@Column(name="PASSWORD_USUARIO", nullable=false)
	private String password;
	@OneToOne(fetch=FetchType.LAZY)
	@OrderBy
	private Agenda agenda;

	/*------------- construtor ------------- */
	
	public Usuario(long idUsusario, String nome, String email, String username, String password, Agenda agenda) {
		super();
		this.id_ususario = idUsusario;
		this.nome_usuario = nome;
		this.email = email;
		this.username = username;
		this.password = password;
		this.agenda = agenda;
	}
	
	/*------------- get and set ------------- */
	
	public long getIdUsusario() {
		return id_ususario;
	}

	public void setIdUsusario(long idUsusario) {
		this.id_ususario = idUsusario;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public String getNome() {
		return nome_usuario;
	}

	public void setNome(String nome) {
		this.nome_usuario = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
