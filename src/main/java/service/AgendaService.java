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
			//inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			contatos = agendaDao.pegaContatosDaAgenda(agenda);

			// commitar a transa��o
			JPAUtil.commitTransaction();
			
			return contatos;
		} 
		catch(InfraestruturaException e){	
			try{	
				// se der erro na transa��o volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui n�o propaga pois � em decorrencia do primeiro
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
			//inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			Agenda agenda = agendaDao.pegaAgenda(id);

			// commitar a transa��o
			JPAUtil.commitTransaction();
			
			return agenda;
		} 
		catch(InfraestruturaException e){	
			try{	
				// se der erro na transa��o volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui n�o propaga pois � em decorrencia do primeiro
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
