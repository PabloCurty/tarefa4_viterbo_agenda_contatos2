package controller;

import java.util.Collection;

import model.Agenda;
import model.Contato;
import service.AgendaService;

public class ControleAgenda {

	public Collection<? extends Contato> pegaAgenda(long id){
		
		AgendaService agendaService = new AgendaService();
		Agenda agenda = agendaService.getAgenda(id);
		Collection<? extends Contato> contatosBean = agendaService.getContatosDaAgenda(agenda);
		return contatosBean;
		
	}

}
