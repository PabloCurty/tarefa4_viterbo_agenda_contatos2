package beans;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;

import controller.ControleUsuario;
import exception.UsuarioExistenteException;

@ManagedBean(name = "usuarioBean")
@RequestScoped
public class UsuarioBean {
	
	private long id;
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
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String cadastraUsuario(){
		LoginBean loginBean = null; 
		try {
			ControleUsuario controleCadastroUsuario = new ControleUsuario();
			String acao = controleCadastroUsuario.cadastraUsuario(this);
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
	
	public String cleanUsuario(){
		this.nome = null;
		this.email = null;
		this.password = null;
		this.username = null;
		//TODO verificar se eh necessario
		//FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("loginBean", loginBean);
		return "cadastraUsuario.xhtml";
	}
}
