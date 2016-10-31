package beans;

import java.io.Serializable;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

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
	
	private final String message = "Entre com usu�rio e senha para acessar seus contatos";
	
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

	public String login(){
		try {
			ControleLogin controleLogin = new ControleLogin();
			return controleLogin.login(usuario, password);
		} catch (Exception e) {
			return "failure";
		}
		
	}

	public String cleanLogin()
	{
		this.password = null;
		this.usuario = null;
		//TODO verificar se eh necessario
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginBean", loginBean);
		return "login.xhtml";
	}
	
}
