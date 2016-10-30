package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "CONTATO")
@SequenceGenerator(name = "SEQUENCIA_CONTATO", sequenceName = "SEQ_CONTATO", allocationSize = 1)
public class Contato implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY, generator = "SEQUENCIA_CONTATO")
	@Column(name = "ID_CONTATO")
	private Long id;
	
	@Column(name = "NOME", nullable = false)
	private String nome;
	
	@Column(name = "EMAIL", nullable = false)
	private String email;
	
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="AGENDA_ID")
	private Agenda agenda;

	/* ENDERECO */
	@Column(name = "LOGRADOURO")
	private String logradouro;
	@Column(name = "COMPLEMENTO")
	private String complemento;
	@Column(name = "BAIRRO")
	private String bairro;
	@Column(name = "CIDADE")
	private String cidade;
	@Column(name = "UF")
	private String uf;
	@Column(name = "CEP")
	private String cep;

	/* TELEFONE */
	@Column(name = "TELEFONE")
	private String telefone;
	@Column(name = "CELULAR", nullable = false)
	private String celular;
	@Column(name = "OPERADORA")
	private String operadora;
	@Column(name = "DDI")
	private String ddi;
	@Column(name = "DDD")
	private String ddd;

	
	
	public Contato(Long id, String nome, String email, Agenda agenda, String logradouro, String complemento,
			String bairro, String cidade, String uf, String cep, String telefone, String celular, String operadora,
			String ddi, String ddd) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.agenda = agenda;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.celular = celular;
		this.operadora = operadora;
		this.ddi = ddi;
		this.ddd = ddd;
	}

	public Contato(String nome, String email, String logradouro, String complemento, String bairro, String cidade,
			String uf, String cep, String telefone, String celular, String operadora, String ddi, String ddd) {
		super();
		this.nome = nome;
		this.email = email;
		this.logradouro = logradouro;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.telefone = telefone;
		this.celular = celular;
		this.operadora = operadora;
		this.ddi = ddi;
		this.ddd = ddd;
	}
	
	public Contato() {
		super();
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getOperadora() {
		return operadora;
	}

	public void setOperadora(String operadora) {
		this.operadora = operadora;
	}

	public String getDdi() {
		return ddi;
	}

	public void setDdi(String ddi) {
		this.ddi = ddi;
	}

	public String getDdd() {
		return ddd;
	}

	public void setDdd(String ddd) {
		this.ddd = ddd;
	}

}
