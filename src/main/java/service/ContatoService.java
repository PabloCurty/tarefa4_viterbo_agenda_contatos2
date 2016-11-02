package service;

import dao.CadastroDao;
import dao.FabricaDeDAOs;
import exception.InfraestruturaException;
import model.Contato;
import util.JPAUtil;

public class ContatoService {
	
	private static CadastroDao cadastroDao = FabricaDeDAOs.getDAO(CadastroDao.class);

	public Contato cadastraContato(Contato contato) {
		try {
			// inicia a transção no JPA
			JPAUtil.beginTransaction();
			// chama método inclui do DAO
			Contato cont = cadastroDao.cadastraContato(contato);
			// commitar a transação
			JPAUtil.commitTransaction();

			return cont;
		} catch (InfraestruturaException e) {
			try {
				// se der erro na transação volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui não propaga pois é em decorrencia do
			// primeiro
			catch (InfraestruturaException ie) {

			}
			// propago erro do primero
			throw e;
		} finally {
			// fechar o entity manager
			JPAUtil.closeEntityManager();
		}
	}
	
	public void removeContato(Contato contato) {
		try {
			// inicia a transção no JPA
			JPAUtil.beginTransaction();
			// chama método inclui do DAO
			cadastroDao.removeContato(contato);
			// commitar a transação
			JPAUtil.commitTransaction();

		} catch (InfraestruturaException e) {
			try {
				// se der erro na transação volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui não propaga pois é em decorrencia do
			// primeiro
			catch (InfraestruturaException ie) {

			}
			// propago erro do primero
			throw e;
		} finally {
			// fechar o entity manager
			JPAUtil.closeEntityManager();
		}
	}

	public Contato updateContato(Contato contato) {

		try {
			// inicia a transção no JPA
			JPAUtil.beginTransaction();
			// chama método inclui do DAO
			Contato cont = cadastroDao.updateContato(contato);
			// commitar a transação
			JPAUtil.commitTransaction();

			return cont;
		} catch (InfraestruturaException e) {
			try {
				// se der erro na transação volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui não propaga pois é em decorrencia do
			// primeiro
			catch (InfraestruturaException ie) {

			}
			// propago erro do primero
			throw e;
		} finally {
			// fechar o entity manager
			JPAUtil.closeEntityManager();
		}
	}
}
