package dao;

import javax.persistence.EntityManager;

import exception.InfraestruturaException;
import model.Usuario;
import util.JPAUtil;

public class CadastroDaoImpl implements CadastroDao {

	@Override
	public long cadastraUsuario(Usuario umUsuario) {
		// TODO Auto-generated method stub
		try {
			EntityManager em = JPAUtil.getEntityManager();
			em.persist(umUsuario);

			return umUsuario.getId_usuario();
		} catch (RuntimeException e) {
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
	}

}
