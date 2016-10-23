package service;

import dao.FabricaDeDAOs;
import dao.LoginDao;
import exception.InfraestruturaException;
import util.JPAUtil;

public class LoginService {

	private static LoginDao loginDao = FabricaDeDAOs.getDAO(LoginDao.class);
	
	public long autentica(String usuario, String password){
		
		try
		{	
			//inicia a trans��o no JPA
			JPAUtil.beginTransaction();
			// chama m�todo inclui do DAO
			long numero = loginDao.pegaLogin(usuario, password);

			// commitar a transa��o
			JPAUtil.commitTransaction();
			
			return numero;
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
