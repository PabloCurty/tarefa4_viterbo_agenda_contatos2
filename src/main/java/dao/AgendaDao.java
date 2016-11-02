package dao;

import java.util.Collection;

import model.Agenda;
import model.Contato;

public interface AgendaDao {
	
	public Collection<? extends Contato> pegaContatosDaAgenda(Agenda agenda);

	public Agenda pegaAgenda(long id);

}
