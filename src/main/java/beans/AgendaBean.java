package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controller.ControleAgenda;
import controller.ControleContato;
import model.Agenda;
import model.Contato;
import service.AgendaService;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "agendaBean")
@SessionScoped
public class AgendaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<ContatoBean> contatos = new ArrayList<ContatoBean>();
	
	private Long id;
	
	private Agenda agenda;
	
	@PostConstruct
    public void init(){
		
		id = (Long) FacesContext.getCurrentInstance().getExternalContext().getFlash().get("id");
		
		AgendaService agendaService = new AgendaService();
		agenda = agendaService.getAgenda(id);
		
		ControleAgenda controleAgenda = new ControleAgenda();

		@SuppressWarnings("unchecked")
		List<Contato> contatosModel =  (List<Contato>) controleAgenda.getContatosDaAgenda(id);
		
		List<ContatoBean> contatosBean = processarContatos(contatosModel,agenda);
		
		if(!contatos.isEmpty())
		{
			contatos.clear();
		}
		contatos.addAll(contatosBean);
		
    }
	
	private List<ContatoBean> processarContatos(List<Contato> contatosModel, Agenda agenda)
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
					  this.agenda);
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
		ControleContato controleContato = ControleContato.getInstance();
		String string = controleContato.cadastraContato(contatoBean, this.agenda);

		if(string.equals("success")){
			contatos.add(contatoBean);
			return "index.xhtml";
		}else{
			return "erroCadastro.xhtml";
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

	public String editAction(ContatoBean contato) {
		contato.setEditavel(true);
		return null;
	}
	
	public String removeAction(ContatoBean contato) {
		
		ControleContato controleContato = ControleContato.getInstance();
		
		Iterator<ContatoBean> iter = this.contatos.iterator();
		
		while (iter.hasNext()) {
		    ContatoBean contato_ = iter.next();
	
		    if (contato_.equals(contato))
			{
		    	try{
			    	controleContato.removeContato(contato,this.agenda);
			    	iter.remove();
		    	}
		    	catch(Exception e)
		    	{
		    		System.out.println("Reinicializar operação");
		    	}
			}
		}
		return null;
	}

}
