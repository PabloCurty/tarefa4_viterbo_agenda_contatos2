package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.faces.bean.SessionScoped;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "agendaBean")
@SessionScoped
public class AgendaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private List<ContatoBean> contatos = new ArrayList<ContatoBean>();
	
	//TODO remover apos ter persistencia
	@PostConstruct
    public void init(){
		ContatoBean cont = new ContatoBean("Rodrigo Nunes", "1234-5678");
		//boolean so = contatos.add(cont);
		contatos.add(cont);
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
		//TODO
		//No caso de recarregar a tela, esta adicionando de novo
		//O que esta abaixo nao resolve
		if(!contatos.contains(contatoBean))
		{
			contatos.add(contato);
			Collections.sort(contatos, (a, b) -> a.compare(b));
		}
		else
		{
			return "errorCadastro.xhtml";
		}
		return "index.xhtml";
	}
	
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
	
	//TODO finish editaContato
	public String editaContato(ContatoBean contato)
	{
		return "editaContato.xhtml";
	}
}
