package dao;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TransactionRequiredException;

import exception.InfraestruturaException;
import model.Contato;
import model.Usuario;
import util.JPAUtil;

public class CadastroDaoImpl implements CadastroDao {

	@Override
	public Usuario cadastraUsuario(Usuario umUsuario) {
		// TODO Auto-generated method stub
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.persist(umUsuario);

			return umUsuario;
		} catch (RuntimeException e) {
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
	}

	@Override
	public Contato cadastraContato(Contato umContato) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.persist(umContato);

			return umContato;
		} catch (RuntimeException e) {
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
	}

	@Override
	public void removeContato(Contato contato) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			
			
			Query query = em.createQuery("select a from Contato as a where a.id = :id");
			query.setParameter("id", contato.getId());
			Contato contato_ = (Contato) query.getSingleResult();
			
			
			em.remove(contato_);

			//NAO FUNCIONA 
//			em.remove(contato);

		} catch (IllegalArgumentException e) {
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
		catch (TransactionRequiredException e)
		{
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
	}

	@Override
	public Contato updateContato(Contato contato) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			
			em.merge(contato);
			
			return contato;
		} catch (RuntimeException e) {
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
	}
}
