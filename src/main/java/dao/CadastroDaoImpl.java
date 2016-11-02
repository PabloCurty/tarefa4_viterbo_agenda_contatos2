package dao;

import javax.persistence.EntityManager;

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
	public void removeContato(Contato umContato) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			
			em.remove(umContato);

		} catch (RuntimeException e) {
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
