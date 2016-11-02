package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

import model.Agenda;

//ViewScope
//As soon as the user navigates to a different page, the bean goes out of scope.

@ManagedBean(name = "contatoBean")
@ViewScoped
public class ContatoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	
	/* ENDERECO */
	private String logradouro;
	private String complemento;
	private String bairro;
	private String cidade;
	private String uf;
	private String cep;
	
	/* TELEFONE */
	private String telefone;
	private String celular;
	private String operadora;
	private String ddi;
	private String ddd;
	
	private Agenda agenda;
	
	/* CONTROLE */
	//controla se deve ser editavel na tela
	boolean editavel;

	public ContatoBean(Long id, String nome, String email, String logradouro, String complemento, String bairro,
			String cidade, String uf, String cep, String telefone, String celular, String operadora, String ddi,
			String ddd, Agenda agenda) {
		super();
		this.id = id;
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
		this.setAgenda(agenda);
		this.editavel = false;
	}

	public ContatoBean(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.editavel = false;
	}
	
	public ContatoBean()
	{
		
	};
	

	public boolean isEditavel() {
		return editavel;
	}

	public void setEditavel(boolean editavel) {
		this.editavel = editavel;
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
	
	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
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
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
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
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public int compare(ContatoBean o2) {
		String s1 = this.getNome();
        String s2 = o2.getNome();
        return s1.toLowerCase().compareTo(s2.toLowerCase());
	}

	public Agenda getAgenda() {
		return agenda;
	}

	public void setAgenda(Agenda agenda) {
		this.agenda = agenda;
	} 
	
}
