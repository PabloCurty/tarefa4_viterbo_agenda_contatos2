package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import exception.InfraestruturaException;


public class JPAUtil {
	//todas as classes lidar procuando anota��o @entity criando crud para eles
		private static EntityManagerFactory emf;
		//cria obj com duas colunas (n�mero da thread, entityManager)
		private static final ThreadLocal<EntityManager> threadEntityManager = new ThreadLocal<EntityManager>();
		//cria obj com duas colunas (n�mero da thread, EntityTransaction)
		private static final ThreadLocal<EntityTransaction> threadTransaction = new ThreadLocal<EntityTransaction>();

		static 
		{	try{
				//vai em persistence.xml(desntro de resources) 
				//por causa desse set <property name="hibernate.archive.autodetection" value="class"/>
				// procura @entity em todas as classes do pacote
				/*
				 * No nosso caso s� tem na classe produto
				 *  @Entity
					@Table(name="PRODUTO")
					@SequenceGenerator(name="SEQUENCIA", 
			        sequenceName="SEQ_PRODUTO",
			        allocationSize=1)
					public class Produto
				 */
				// passa string do pacote onde vai procurar as classes
				emf = Persistence.createEntityManagerFactory("agendaContatos");
			}
			catch(Throwable e){	
				e.printStackTrace();
				System.out.println(">>>>>>>>>> Mensagem de erro: " + e.getMessage());
			}
		}
		// pode estar sendo executado em pipeline para threads diferentes
		public static void beginTransaction(){	
			//System.out.println("Vai criar transacao");
			// pega o id da thread corrente
			EntityTransaction tx = threadTransaction.get();
			try {
				// se n�o tem thread
				if (tx == null){
					// olhar m�todo abaixo getEntitymanager
					tx = getEntityManager().getTransaction();
					tx.begin();
					//seta a transa��o
					threadTransaction.set(tx);
					//System.out.println("Criou transacao");
				}
				else{	
					//System.out.println("Nao criou transacao");
				}
			} 
			catch (RuntimeException ex){	
				throw new InfraestruturaException(ex);
			}
		}
		//n�o tem transa��o cria o entityManager
		public static EntityManager getEntityManager(){	

			EntityManager s = threadEntityManager.get();
			// Abre uma nova Sess�o, se a thread ainda n�o possui uma.
			try{	
				if (s == null){	
					//cria o entity manager e a thread aponta pra ele
					s = emf.createEntityManager();
					threadEntityManager.set(s);
					//System.out.println("criou sessao");
				}
			} 
			catch (RuntimeException ex){	
				//propaga exce��o de infraestrutura
				throw new InfraestruturaException(ex);
			}
			return s;
		}

		public static void commitTransaction(){	
			// recupera e seta null primeiro pois se falhar j� colocou null 
			EntityTransaction tx = threadTransaction.get();
			try {
				threadTransaction.set(null);
				// est� ativo antes de commitar ou fazer o rollback
				if ( tx != null && tx.isActive()){	
					tx.commit();
					//System.out.println("Comitou transacao");
				}
			} 
			catch (RuntimeException ex) {	
				try	{	
					rollbackTransaction();
				}
				catch(RuntimeException e)
				{}
				
				throw new InfraestruturaException(ex);
			}
		}
		// se aconteceu rollback fecha entitymanager
		public static void rollbackTransaction(){	
			System.out.println("Vai efetuar rollback de transacao");
		    // recupera e seta null primeiro pois se falhar j� colocou null 
			EntityTransaction tx = threadTransaction.get();
			try{	
				threadTransaction.set(null);
				if ( tx != null && tx.isActive()){	
					tx.rollback();
				}
			} 
			catch (RuntimeException ex){	
				throw new InfraestruturaException(ex);
			} 
			finally{	
				closeEntityManager();
			}
		}
		// o close � importante pois os objetos podem ficar alocados no cache do entity manager
		// mesmo j� tendo sido deletados ou mudados
		// portanto fechamos o entity manager e criamos outro
		public static void closeEntityManager(){	
			//System.out.println("Vai fechar sess�o");

			try{	
				EntityManager s = threadEntityManager.get();
				threadEntityManager.set(null);
				if (s != null && s.isOpen()){	
					s.close();
					//System.out.println("Fechou a sess�o");
				}
				// tratar esquecimento de rollback(antes pode ter uma altera��o agendada, e outra falhou)
				EntityTransaction tx = threadTransaction.get();
				if ( tx != null && tx.isActive()){	
					rollbackTransaction();
					throw new RuntimeException("EntityManager sendo fechado " + "com transa��o ativa.");
				}
			} 	
			catch (RuntimeException ex){	
				throw new InfraestruturaException(ex);
			}
		}
}