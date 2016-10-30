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
				//inicia a trans��o no JPA
				JPAUtil.beginTransaction();
				// chama m�todo inclui do DAO
				long numero = cadastroDao.cadastraUsuario(usuario);
	
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
