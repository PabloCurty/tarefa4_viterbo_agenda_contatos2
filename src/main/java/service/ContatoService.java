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
			// inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			Contato cont = cadastroDao.cadastraContato(contato);
			// commitar a transa��o
			JPAUtil.commitTransaction();

			return cont;
		} catch (InfraestruturaException e) {
			try {
				// se der erro na transa��o volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui n�o propaga pois � em decorrencia do
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
			// inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			cadastroDao.removeContato(contato);
			// commitar a transa��o
			JPAUtil.commitTransaction();

		} catch (InfraestruturaException e) {
			try {
				// se der erro na transa��o volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui n�o propaga pois � em decorrencia do
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
			// inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			Contato cont = cadastroDao.updateContato(contato);
			// commitar a transa��o
			JPAUtil.commitTransaction();

			return cont;
		} catch (InfraestruturaException e) {
			try {
				// se der erro na transa��o volto
				JPAUtil.rollbackTransaction();
			}
			// erro que ocorre aqui n�o propaga pois � em decorrencia do
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
