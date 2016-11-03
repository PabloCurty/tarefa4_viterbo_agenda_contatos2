package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.el.ELContext;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controller.ControleContato;

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
		    
//		    if(this.tipo == null)
//		    {
//		    	this.tipo = "nome";
//		    }
		    
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
			if(tipo.equals("nome"))
			{
				if(contato.getNome().contains(this.texto))
				{
					this.contatos.add(contato);
				}
			}
			else
			if(tipo.equals("endereco"))
			{
				if(contato.getLogradouro().contains(this.texto))
				{
					this.contatos.add(contato);
				}
			}
			else
			if(tipo.equals("email"))
			{
				if(contato.getEmail().contains(this.texto))
				{
					this.contatos.add(contato);
				}
			}
			else
			if(tipo.equals("telefone"))
			{
				if(contato.getTelefone().contains(this.texto) || contato.getCelular().contains(this.texto))
				{
					this.contatos.add(contato);
				}
			}
		}
	}
	
	public String updateAction() {
		
		ControleContato controleContato = ControleContato.getInstance();
		
		//get all existing value but set "editable" to false
		for (ContatoBean contato : this.contatos){
			
			//se editavel, eh pq precisa ser atualizado
			if(contato.isEditavel())
			{
				//chamar update
				try
				{
					controleContato.updateContato(contato);
					contato.setEditavel(false);
				}
				catch (Exception e)
				{
					System.out.println("Reinicializar operação");
				}
			}
		}
		//return to current page
		return null;

	}
}
