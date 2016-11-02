package dao;

import java.util.Collection;

import beans.ContatoBean;
import model.Agenda;

public interface AgendaDao {
	
	public Collection<? extends ContatoBean> pegaContatosDaAgenda(Agenda agenda);

	public Agenda pegaAgenda(long id);

}
