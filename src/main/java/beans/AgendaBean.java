package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import controller.ControleAgenda;
import controller.ControlrCadastraContato;

import javax.annotation.PostConstruct;
import javax.enterprise.inject.spi.Bean;
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

		List<ContatoBean> conts =  (List<ContatoBean>) controleContatos.pegaAgenda(id);
		
		contatos.removeAll(conts);
		contatos.addAll(conts);
		
    }

	public List<ContatoBean> getContatos() {
		return this.contatos;
	}

	public void setContatos(List<ContatoBean> contatos) {
		this.contatos = contatos;
	}
	

	public String cadastra(ContatoBean contatoBean)
	{
		ControlrCadastraContato controleCadastraContato = new ControlrCadastraContato();
		String string = controleCadastraContato.cadastraContato(contatoBean, id);

		if(string.equals("success")){
			return "index.xhtml";
		}else{
			return "erroCadastro.xhtml";
		}
		
	}
	
	public String saveAction() {

		//get all existing value but set "editable" to false
		for (ContatoBean contato : contatos){
			contato.setEditavel(false);
		}
		//return to current page
		return null;

	}

	public String editAction(ContatoBean contato) {
		contato.setEditavel(true);
		return null;
	}
	
	public String removeAction(ContatoBean contato) {
		Iterator<ContatoBean> iter = this.contatos.iterator();
		
		while (iter.hasNext()) {
		    ContatoBean contato_ = iter.next();
	
		    if (contato_.equals(contato))
			{
		    	iter.remove();
			}
		}
		return null;
	}

}
