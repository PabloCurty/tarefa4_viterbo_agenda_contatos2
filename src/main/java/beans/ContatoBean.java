package beans;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;
import javax.faces.view.ViewScoped;

//ViewScope
//As soon as the user navigates to a different page, the bean goes out of scope.

@ManagedBean(name = "contatoBean")
@ViewScoped
public class ContatoBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String nome;
	private String email;
	private String endereco;
	private String telefone;
	boolean ativo;
	
	public ContatoBean(String nome, String email, String endereco, String telefone) {
		super();
		//this.id = id;
		this.nome = nome;
		this.email = email;
		this.endereco = endereco;
		this.telefone = telefone;
		this.ativo = true;
	}
	
	public ContatoBean(String nome, String telefone) {
		super();
		this.nome = nome;
		this.telefone = telefone;
		this.ativo = true;
	}
	
	public ContatoBean()
	{
		
	};
	
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
