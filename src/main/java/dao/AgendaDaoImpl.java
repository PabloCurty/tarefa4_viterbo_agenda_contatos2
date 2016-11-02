package dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import beans.ContatoBean;
import exception.InfraestruturaException;
import model.Agenda;
import util.JPAUtil;

public class AgendaDaoImpl implements AgendaDao {

	@Override
	public Collection<? extends ContatoBean> pegaContatosDaAgenda(Agenda agenda) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("select a from Contato as a where a.agenda = :agenda");
			query.setParameter("agenda", agenda);
			Collection<? extends ContatoBean> contatos = query.getResultList();
			return contatos;
		} catch (RuntimeException e) {
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
	}

	@Override
	public Agenda pegaAgenda(long id) {
		try {
			EntityManager em = JPAUtil.getEntityManager();
			Query query = em.createQuery("select a from Agenda as a where a.id = :id");
			query.setParameter("id", id);
			List<Agenda> agendas = query.getResultList();
			return agendas.get(0);
		} catch (RuntimeException e) {
			// propaga exceção de infraestrutura
			throw new InfraestruturaException(e);
		}
	}

}
