package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controller.ControleLogin;

/**
 TODO apos insert de contato, login nao aparece mais em index
 **/
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String password;
	private Long id;
	
	private final String message = "Entre com usuário e senha para acessar seus contatos";
	
	public String getMessage() {
		return message;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String login(){
		try {
			ControleLogin controleLogin = new ControleLogin();
			String str = controleLogin.login(this);
			FacesContext.getCurrentInstance().getExternalContext().getFlash().put("id", getId());
			return str;
		} catch (Exception e) {
			return "failure";
		}
		
	}

	public String cleanLogin()
	{
		this.password = null;
		this.usuario = null;
		this.id = null;
		//TODO verificar se eh necessario
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginBean", loginBean);
		return "login.xhtml";
	}
	
}
