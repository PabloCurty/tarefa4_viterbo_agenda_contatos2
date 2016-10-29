package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

@ManagedBean(name = "buscaBean")
@SessionScoped
public class BuscaBean implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private String texto;
	private String tipo;
	private List<ContatoBean> contatos = new ArrayList<ContatoBean>();

	public List<ContatoBean> getContatos() {
		return contatos;
	}

	public void setContatos(List<ContatoBean> contatos) {
		this.contatos = contatos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	public String busca(){
		AgendaBean agendaBean = null; 
		if(!this.contatos.isEmpty())
		{
			this.contatos.clear();
		}
		
		try {
			
			FacesContext fc = FacesContext.getCurrentInstance();
			ELContext elContext;
		    if(fc!=null){
		    	elContext = fc.getELContext();
		         agendaBean =(AgendaBean) elContext.getELResolver().getValue(elContext, null, "agendaBean");
		    }
		    
		    obtemContatosBusca(agendaBean);	
		    	
		    this.texto = "";
		    
		    return "busca.xhtml";
		} catch (Exception e) {
			e.printStackTrace();
			return "erroBusca.xhtml";	
		} 
		
	}

	private void obtemContatosBusca(AgendaBean agendaBean) {
		List<ContatoBean> agendaBeanContatos  = agendaBean.getContatos();
		
		for(ContatoBean contato : agendaBeanContatos)
		{
			if(contato.getNome().contains(this.texto) && this.tipo.equals("nome"))
			{
				this.contatos.add(contato);
			}
			else if((contato.getLogradouro().contains(this.texto) || contato.getBairro().contains(this.texto)
					|| contato.getCidade().contains(this.texto) || contato.getUf().contains(this.texto)) 
					&& this.tipo.equals("endereco"))
			{
				this.contatos.add(contato);
			}
			else if(contato.getEmail().contains(this.texto) && this.tipo.equals("email"))
			{
				this.contatos.add(contato);
			}
			else if((contato.getTelefone().contains(this.texto) || contato.getCelular().contains(this.texto)
					|| this.texto.contains(contato.getTelefone()) || this.texto.contains(contato.getCelular()) 
					) && this.tipo.equals("telefone"))
			{
				this.contatos.add(contato);
			}
		}
	}
	
	public String saveAction() {

		//get all existing value but set "editable" to false
		for (ContatoBean contato : contatos){
			contato.setEditavel(false);
		}
		
		//TODO todos os contatos que eu editar no busca tem que se refletir em agendaBean
		//Caso a ideia do pablo de sempre buscar da base seja seguida, isso nao sera problema
		
		//return to current page
		return null;

	}
}
