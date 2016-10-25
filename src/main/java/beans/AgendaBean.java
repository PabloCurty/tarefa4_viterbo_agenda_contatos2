package beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.Contato;

@ManagedBean(name = "agendaBean")
@SessionScoped
public class AgendaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	List<Contato> contatos = new ArrayList<Contato>();

	public List<Contato> getContatos() {
		Contato cont = new Contato("", "", "", "", "", "", "Rodrigo Nunes", "", "", "");
		this.contatos.add(cont);
		return this.contatos;
	}

	public void setContatos(List<Contato> contatos) {
		this.contatos = contatos;
	}
	
}
