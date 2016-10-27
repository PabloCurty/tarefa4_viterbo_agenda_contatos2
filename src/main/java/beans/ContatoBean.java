package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

@ManagedBean(name = "contatoBean")
@RequestScoped
public class ContatoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	public ContatoBean(Long id, String nome, String email, String endereco, String telefone, boolean ativo) {
		super();
		this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.ativo = ativo;
	}
	
	public ContatoBean(String nome, String telefone, boolean ativo) {
		this.nome = nome;
		this.telefone = telefone;
		this.ativo = ativo;
	}
	
	public ContatoBean()
	{
		
	};

	private String email;
	private String endereco;
	private String telefone;
	boolean ativo;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	public boolean isAtivo() {
		return ativo;
	}
	public void setAtivo(boolean ativo) {
		this.ativo = ativo;
	}
	public String getEndereco() {
		return endereco;
	}
	public void setEndereco(String endereco) {
		this.endereco = endereco;
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
	
}
