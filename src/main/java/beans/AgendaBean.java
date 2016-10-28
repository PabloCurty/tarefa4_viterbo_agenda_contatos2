package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "agendaBean")
@SessionScoped
public class AgendaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	List<ContatoBean> contatos = new ArrayList<ContatoBean>();
	
	//TODO remover
	@PostConstruct
    public void init(){
		ContatoBean cont = new ContatoBean("Rodrigo Nunes", "1234-5678");
		boolean so = contatos.add(cont);
    }

	public List<ContatoBean> getContatos() {
		return this.contatos;
	}

	public void setContatos(List<ContatoBean> contatos) {
		this.contatos = contatos;
	}
	
	public String cadastra(ContatoBean contatoBean)
	{
		ContatoBean contato = contatoBean;
		contato.setAtivo(true);
		contatos.add(contato);
		return "index.xhtml";
	}
	/*
	public String remove()
	{
		//Remover de uma lista sendo iterada dah merda
		List<ContatoBean> contatos_ = new ArrayList<ContatoBean>();
		contatos_ =	this.getContatos();
		for(ContatoBean contato : contatos_)
		{
			if (!contato.isAtivo())
			{
				contatos_.remove(contato);
			}
		}
		this.setContatos(contatos_);
		return "index.xhtml";
	}
	*/
	
	public String remove()
	{
		Iterator<ContatoBean> iter = this.contatos.iterator();
	
		while (iter.hasNext()) {
		    ContatoBean contato = iter.next();
	
		    if (!contato.isAtivo())
			{
		    	iter.remove();
			}
		}
		return "index.xhtml";
	}
}
