package controller;

import java.util.Collection;

import model.Agenda;
import model.Contato;
import service.AgendaService;

public class ControleAgenda {

	public Collection<? extends Contato> getContatosDaAgenda(long id){
		
		AgendaService agendaService = new AgendaService();
		Agenda agenda = agendaService.getAgenda(id);
		Collection<? extends Contato> contatos = agendaService.getContatosDaAgenda(agenda);
		return contatos;
		
	}

}
