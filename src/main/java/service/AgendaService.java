package service;

import java.util.Collection;

import beans.ContatoBean;
import dao.AgendaDao;
import dao.FabricaDeDAOs;
import exception.InfraestruturaException;
import model.Agenda;
import model.Contato;
import util.JPAUtil;

public class AgendaService {

	private static AgendaDao agendaDao = FabricaDeDAOs.getDAO(AgendaDao.class);
	
	public Collection<? extends Contato> getContatosDaAgenda(Agenda agenda) {
		try
		{	
			Collection<? extends Contato> contatos;
			//inicia a transção no JPA
			JPAUtil.beginTransaction();
			// chama método inclui do DAO
			contatos = agendaDao.pegaContatosDaAgenda(agenda);

			// commitar a transação
			JPAUtil.commitTransaction();
			
			return contatos;
		} 
		catch(InfraestruturaException e){	
			try{	
				// se der erro na transação volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui não propaga pois é em decorrencia do primeiro
			catch(InfraestruturaException ie){
				
			}
			// propago erro do primero
		    throw e;
		}
		finally{
			// fechar o entity manager
			JPAUtil.closeEntityManager();
		}
	}

	public Agenda getAgenda(long id) {
		try
		{	
			//inicia a transção no JPA
			JPAUtil.beginTransaction();
			// chama método inclui do DAO
			Agenda agenda = agendaDao.pegaAgenda(id);

			// commitar a transação
			JPAUtil.commitTransaction();
			
			return agenda;
		} 
		catch(InfraestruturaException e){	
			try{	
				// se der erro na transação volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui não propaga pois é em decorrencia do primeiro
			catch(InfraestruturaException ie){
				
			}
			// propago erro do primero
		    throw e;
		}
		finally{
			// fechar o entity manager
			JPAUtil.closeEntityManager();
		}
	}

}
