package service;

import dao.FabricaDeDAOs;
import dao.LoginDao;
import exception.InfraestruturaException;
import model.Usuario;
import util.JPAUtil;

public class LoginService {

	private static LoginDao loginDao = FabricaDeDAOs.getDAO(LoginDao.class);
	
	Usuario usuario = new Usuario();
	
	public Usuario autentica(String username){
		
		try
		{	
			//inicia a transção no JPA
			JPAUtil.beginTransaction();
			// chama método inclui do DAO
			usuario = loginDao.pegaLogin(username);

			// commitar a transação
			JPAUtil.commitTransaction();
			
			return usuario;
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
