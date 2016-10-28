package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.ViewScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "buscaBean")
@ViewScoped
public class BuscaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String texto;
	List<ContatoBean> contatos = new ArrayList<ContatoBean>();

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String busca(){
		AgendaBean agendaBean = null; 
		try {
			
			FacesContext fc = FacesContext.getCurrentInstance();
			ELContext elContext;
		    if(fc!=null){
		    	elContext = fc.getELContext();
		         agendaBean =(AgendaBean) elContext.getELResolver().getValue(elContext, null, "agendaBean");
		    }
		    
		    this.contatos = agendaBean.getContatos();
		    
		    //TODO logica para excluir da lista contatos que nao se adequem a busca
		    
		    return "busca.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			return "failure";	
		} 
		
	}
}
