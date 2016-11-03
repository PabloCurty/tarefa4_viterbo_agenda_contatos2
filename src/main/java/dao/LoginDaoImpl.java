package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import exception.InfraestruturaException;
import model.Usuario;
import util.JPAUtil;

public class LoginDaoImpl implements LoginDao{
	
	@Override
	public Usuario pegaLogin(String username) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("select u from Usuario as u where u.username = :username");
			query.setParameter("username", username);
			@SuppressWarnings("unchecked")
			List<Usuario> usuarios = query.getResultList();
			Usuario user = new Usuario();
			for (Usuario usuario : usuarios) {
				if(usuario.getUsername().equals(username)){
					user = usuario;
					break;
				}
			}
			
			return user;
		} catch (RuntimeException e) {
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
	}

}
