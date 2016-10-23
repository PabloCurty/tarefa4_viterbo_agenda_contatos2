package beans;

import java.io.Serializable;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import controller.ControleLogin;

/**
 * RequestScoped
 *Instanciado para cada requisição/resposta
 **/
@ManagedBean(name = "loginBean")
@SessionScoped
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String password;
	
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

	public String login(){
		ControleLogin cl = new ControleLogin();
		cl.login(usuario, password);
		/*if (usuario.equals("pablo") && password.equals("123456")) {
			return "success";
		}else{
			return "failure";
		}*/
		return "success";
	}

}
