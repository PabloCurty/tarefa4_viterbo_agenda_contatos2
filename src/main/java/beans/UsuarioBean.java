package beans;

import java.io.Serializable;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import controller.ControleCadastroUsuario;
import exception.UsuarioExistenteException;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String nome;
	private String email;
	private String username;
	private String password;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome_usuario) {
		this.nome = nome_usuario;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
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
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String cadastraUsuario(){
		LoginBean loginBean = null; 
		try {
			ControleCadastroUsuario ccu = new ControleCadastroUsuario();
			String acao = ccu.cadastraUsuario(this);
			FacesContext fc = FacesContext.getCurrentInstance();
			ELContext elContext;
		    if(fc!=null){
		    	elContext = fc.getELContext();
		         loginBean =(LoginBean) elContext.getELResolver().getValue(elContext, null, "loginBean");
		    }
			loginBean.setUsuario(username);
		    loginBean.setPassword(password);
		    
		    //elContext.getELResolver().setValue(elContext, loginBean, "loginBean");
		    
		    FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginBean", loginBean);
		    
		    return acao;
		} catch (UsuarioExistenteException e) {
			e.printStackTrace();
			return "failure";	
		} 
		
	}
}
