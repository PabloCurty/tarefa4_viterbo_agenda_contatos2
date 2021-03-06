package model;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "USUARIO", uniqueConstraints = @UniqueConstraint(columnNames = {"ID_USUARIO", "username"}))
@SequenceGenerator(name = "SEQUENCIA_USUARIO", sequenceName = "SEQ_USUARIO", allocationSize = 1)
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;

	/*------------- atributos do objeto ------------- */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCIA_USUARIO")
	@Column(name = "ID_USUARIO")
	private long id_usuario;
	@Column(name = "NOME", nullable = false)
	private String nome_usuario;
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	/*TODO ver como coloca username unique*/
	@Column(name = "USERNAME", nullable = false, unique = true)
	private String username;
	@Column(name = "PASSWORD", nullable = false)
	private String password;

	/**
	 * Sobre os par�metros da anota��o @OneToOne:
	 *
	 * �cascade� � define a��es automatizadas no relacionamento, ex.: Ao apagar
	 * um USU�RIO, apagar tamb�m uma AGENDA. 
	 * 
	 * �optional� � voc� n�o ser� obrigado a ter uma AGENDA ao persistir um
	 * USU�RIO, ou seja, voc� n�o tem que criar um AGENDA para satisfazer essa
	 * condi��o (voc� poder� buscar o USU�RIO no banco de dados, mas
	 * Usuario.getAgenda() ter� null como resposta). Com o valor igual a false,
	 * ao se cadastrar um USU�RIO, � obrigat�ria a presen�a de uma AGENDA. Pode
	 * ser uma AGENDA rec�m ainda n�o persistido. 
	 * 
	 * �fetch� � o valor padr�o � EAGER.
	 * Ou seja, ao carregar o USU�RIO j� ser� feita a consulta relacionada a
	 * AGENDA de modo autom�tico. 
	 * 
	 * �orphanRemoval� � define que uma entidade dependente, caso n�o tenha
	 * relacionamento, ser� removida do banco de dados (em nosso modelo, AGENDA
	 * depende de USU�RIO). Caso exista uma AGENDA sem USUARIO, essa AGENDA ser�
	 * removida.
	 * 
	 * 
	 * // @JoinColumn(name=�USER_ID�, nullable=false) � define qual � a coluna mapeada 
	 * para fazer a uni�o na consulta. � indicado o nome da coluna atrav�s do par�metro 
	 * �name� e que esse campo n�o pode ser nulo pelo par�metro �nullable�.
	 * 
	 * @PrimaryKeyJoinColumn � essa anota��o indica ao JPA que, para encontrar um objeto 
	 * AGENDA basta procurar um registro com o mesmo ID do USUARIO. Ou seja, indica que 
	 * uma AGENDA vai ter o mesmo ID que seu USUARIO.
	 * 
	 */

	@OneToOne(cascade = CascadeType.ALL, optional = true, fetch = FetchType.EAGER, orphanRemoval = true)
	// @JoinColumn(name=�AGENDA_ID�, nullable=false)
	@PrimaryKeyJoinColumn
	private Agenda agenda;

	/*------------- construtor ------------- */
	
	

	public Usuario(long idUsusario, String nome, String email, String username, String password, Agenda agenda) {
		super();
		this.id_usuario = idUsusario;
		this.nome_usuario = nome;
		this.email = email;
		this.username = username;
		this.password = password;
		this.agenda = agenda;
	}
	
	public Usuario() {
		super();
	}

	public Usuario(String nome_usuario, String email, String username, String password, Agenda agenda) {
		super();
		this.nome_usuario = nome_usuario;
		this.email = email;
		this.username = username;
		this.password = password;
		this.agenda = agenda;
	}

	/*------------- get and set ------------- */
	

	public String getUsername() {
		return username;
	}

	public long getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(long id_usuario) {
		this.id_usuario = id_usuario;
	}

	public String getNome_usuario() {
		return nome_usuario;
	}

	public void setNome_usuario(String nome_usuario) {
		this.nome_usuario = nome_usuario;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
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
