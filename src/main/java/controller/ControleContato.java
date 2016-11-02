package controller;

import beans.ContatoBean;
import exception.UsuarioExistenteException;
import model.Agenda;
import model.Contato;
import service.AgendaService;
import service.ContatoService;

public class ControleContato {

	public String cadastraContato(ContatoBean contatoBean, long idAgenda) {
		
		try {
			Contato contato = new Contato(contatoBean.getNome(), 
										  contatoBean.getEmail(), 
										  contatoBean.getLogradouro(), 
										  contatoBean.getComplemento(), 
										  contatoBean.getBairro(), 
										  contatoBean.getCidade(), 
										  contatoBean.getUf(), 
										  contatoBean.getCep(), 
										  contatoBean.getTelefone(), 
										  contatoBean.getCelular(), 
										  contatoBean.getOperadora(), 
										  contatoBean.getDdi(), 
										  contatoBean.getDdd());
			AgendaService agendaService = new AgendaService();
			Agenda agenda = agendaService.getAgenda(idAgenda);
			contato.setAgenda(agenda);
			ContatoService contatoService = new ContatoService();
			Contato cont = contatoService.cadastraContato(contato);
			contatoBean.setId(cont.getId());
			return "success";
		} catch (Exception e) {
			throw new UsuarioExistenteException("Usuario já existe no banco");
		}
	}
	
	public String removeContato(ContatoBean contatoBean)
	{
		try{
			Contato contato = new Contato(
					  contatoBean.getId(), 
					  contatoBean.getNome(), 
					  contatoBean.getEmail(), 
					  contatoBean.getLogradouro(), 
					  contatoBean.getComplemento(), 
					  contatoBean.getBairro(), 
					  contatoBean.getCidade(), 
					  contatoBean.getUf(), 
					  contatoBean.getCep(), 
					  contatoBean.getTelefone(), 
					  contatoBean.getCelular(), 
					  contatoBean.getOperadora(), 
					  contatoBean.getDdi(), 
					  contatoBean.getDdd(),
					  contatoBean.getAgenda());
			ContatoService contatoService = new ContatoService();
			contatoService.removeContato(contato);
			return "success";
		} catch (Exception e) {
			throw new UsuarioExistenteException("Erro ao remover");
		}
	}
	
	public String updateContato(ContatoBean contatoBean)
	{
		try{
			Contato contato = new Contato(
					  contatoBean.getId(), 
					  contatoBean.getNome(), 
					  contatoBean.getEmail(), 
					  contatoBean.getLogradouro(), 
					  contatoBean.getComplemento(), 
					  contatoBean.getBairro(), 
					  contatoBean.getCidade(), 
					  contatoBean.getUf(), 
					  contatoBean.getCep(), 
					  contatoBean.getTelefone(), 
					  contatoBean.getCelular(), 
					  contatoBean.getOperadora(), 
					  contatoBean.getDdi(), 
					  contatoBean.getDdd(),
					  contatoBean.getAgenda());
			ContatoService contatoService = new ContatoService();
			contatoService.updateContato(contato);
			return "success";
		} catch (Exception e) {
			throw new UsuarioExistenteException("Erro ao remover");
		}
	}
}
