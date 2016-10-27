package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "agendaBean")
@SessionScoped
public class AgendaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	ContatoBean cont = new ContatoBean("Rodrigo Nunes", "1234-5678", true);
	
	List<ContatoBean> contatos = new ArrayList<ContatoBean>();
	
	boolean so = contatos.add(cont);

	public List<ContatoBean> getContatos() {
		return this.contatos;
	}

	public void setContatos(List<ContatoBean> contatos) {
		this.contatos = contatos;
	}
	
	public String cadastra(ContatoBean contatoBean)
	{
		//TODO cadastrar
		return "index.xhtml";
	}
}
