package beans;

import java.io.Serializable;
import java.util.List;
import java.util.Set;

import javax.enterprise.context.SessionScoped;
import javax.faces.bean.ManagedBean;

import model.Contato;

@ManagedBean(name = "agendaBean")
@SessionScoped
public class AgendaBean implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	Set<Contato> contatos;

	public Set<Contato> getContatos() {
		return contatos;
	}

	public void setContatos(Set<Contato> contatos) {
		this.contatos = contatos;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
