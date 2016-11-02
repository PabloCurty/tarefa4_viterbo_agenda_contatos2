package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controller.ControleAgenda;
import controller.ControleContato;
import model.Contato;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "agendaBean")
@SessionScoped
public class AgendaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<ContatoBean> contatos = new ArrayList<ContatoBean>();
	
	long id;
	
	//TODO remover apos ter persistencia
	@PostConstruct
    public void init(){
		
		id = (long) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
		
		ControleAgenda controleContatos = new ControleAgenda();

		@SuppressWarnings("unchecked")
		List<Contato> contatosModel =  (List<Contato>) controleContatos.getContatosDaAgenda(id);
		
		List<ContatoBean> contatosBean = processarContatos(contatosModel);
		
		if(!contatos.isEmpty())
		{
			contatos.clear();
		}
		contatos.addAll(contatosBean);
		
    }
	
	private List<ContatoBean> processarContatos(List<Contato> contatosModel)
	{
		List<ContatoBean> contatosBean = new ArrayList<ContatoBean>();
		for(Contato contato : contatosModel)
		{
			ContatoBean contatoBean = new ContatoBean(
					  contato.getId(), 
					  contato.getNome(), 
					  contato.getEmail(), 
					  contato.getLogradouro(), 
					  contato.getComplemento(), 
					  contato.getBairro(), 
					  contato.getCidade(), 
					  contato.getUf(), 
					  contato.getCep(), 
					  contato.getTelefone(), 
					  contato.getCelular(), 
					  contato.getOperadora(), 
					  contato.getDdi(), 
					  contato.getDdd(),
					  contato.getAgenda());
			contatosBean.add(contatoBean);
		}
		return contatosBean;
	}

	public List<ContatoBean> getContatos() {
		return this.contatos;
	}

	public void setContatos(List<ContatoBean> contatos) {
		this.contatos = contatos;
	}
	

	public String cadastra(ContatoBean contatoBean)
	{
		ControleContato controleContato = new ControleContato();
		String string = controleContato.cadastraContato(contatoBean, this.id);

		if(string.equals("success")){
			contatos.add(contatoBean);
			return "index.xhtml";
		}else{
			return "erroCadastro.xhtml";
		}
		
	}
	
	public String updateAction() {

		ControleContato controleContato = new ControleContato();
		
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
					System.out.println("Reinicializar opera��o");
				}
			}
		}
		//return to current page
		return null;

	}

	public String editAction(ContatoBean contato) {
		contato.setEditavel(true);
		return null;
	}
	
	public String removeAction(ContatoBean contato) {
		
		ControleContato controleContato = new ControleContato();
		
		Iterator<ContatoBean> iter = this.contatos.iterator();
		
		while (iter.hasNext()) {
		    ContatoBean contato_ = iter.next();
	
		    if (contato_.equals(contato))
			{
		    	try{
			    	controleContato.removeContato(contato);
			    	iter.remove();
		    	}
		    	catch(Exception e)
		    	{
		    		System.out.println("Reinicializar opera��o");
		    	}
			}
		}
		return null;
	}

}
