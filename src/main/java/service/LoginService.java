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
			//inicia a transção no JPA
			JPAUtil.beginTransaction();
			// chama método inclui do DAO
			long numero = loginDao.pegaLogin(usuario, password);

			// commitar a transação
			JPAUtil.commitTransaction();
			
			return numero;
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
