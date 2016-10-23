package login;

import java.io.Serializable;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "loginBean")
public class LoginBean implements Serializable {

	private static final long serialVersionUID = 1L;
	private String usuario;
	private String password;
	
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
		if (usuario.equals("pablo") && password.equals("123456")) {
			return "success";
		}else{
			return "failure";
		}
	}

}
