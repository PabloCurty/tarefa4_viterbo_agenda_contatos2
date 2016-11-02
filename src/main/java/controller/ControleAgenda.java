package controller;

import java.util.Collection;

import beans.ContatoBean;
import model.Agenda;
import service.AgendaService;

public class ControleAgenda {

	public Collection<? extends ContatoBean> pegaAgenda(long id){
		
		AgendaService agendaService = new AgendaService();
		Agenda agenda = agendaService.getAgenda(id);
		Collection<? extends ContatoBean> contatosBean = agendaService.getContatosDaAgenda(agenda);
		return contatosBean;
		
	}

}
