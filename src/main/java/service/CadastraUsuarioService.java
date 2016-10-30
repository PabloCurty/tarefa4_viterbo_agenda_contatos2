package service;

import dao.CadastroDao;
import dao.FabricaDeDAOs;
import exception.InfraestruturaException;
import model.Usuario;
import util.JPAUtil;

public class CadastraUsuarioService {
	
	private static CadastroDao cadastroDao = FabricaDeDAOs.getDAO(CadastroDao.class);
	
	public long cadastraUsuario(Usuario usuario){
			
			try
			{	
				//inicia a transção no JPA
				JPAUtil.beginTransaction();
				// chama método inclui do DAO
				long numero = cadastroDao.cadastraUsuario(usuario);
	
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
