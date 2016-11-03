package controller;

import beans.ContatoBean;
import exception.UsuarioExistenteException;
import model.Agenda;
import model.Contato;
import service.ContatoService;

public class ControleContato {
	
	private static final ControleContato controleContato = new ControleContato();
	
	private ControleContato()
	{
		
	}
	
	public static ControleContato getInstance()
	{
		return controleContato;
	}

	public String cadastraContato(ContatoBean contatoBean, Agenda agenda) {
		
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
			contato.setAgenda(agenda);
			ContatoService contatoService = new ContatoService();
			Contato cont = contatoService.cadastraContato(contato);
			contatoBean.setId(cont.getId());
			return "success";
		} catch (Exception e) {
			throw new UsuarioExistenteException("Usuario já existe no banco");
		}
	}
	
	public String removeContato(ContatoBean contatoBean, Agenda agenda)
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
					  agenda);
			//Contato contato = getContato(contatoBean);
			
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
