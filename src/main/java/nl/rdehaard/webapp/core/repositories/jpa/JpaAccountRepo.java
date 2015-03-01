package nl.rdehaard.webapp.core.repositories.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import nl.rdehaard.webapp.core.model.entities.Account;
import nl.rdehaard.webapp.core.repositories.AccountRepo;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class JpaAccountRepo implements AccountRepo {

	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Account> findAllAccounts() {
		Query query = em.createQuery("SELECT a FROM Account a");
		return query.getResultList();
	}

	@Override
	public Account findAccount(Long id) {
		return em.find(Account.class, id);
	}

	@Override
	public Account findAccountByName(String name) {
		Query query = em.createQuery("SELECT a FROM Account a WHERE a.name=?1");
		query.setParameter(1, name);
		List<Account> accounts = query.getResultList();
		if (accounts.size() == 0) {
			return null;
		} else {
			return accounts.get(0);
		}
	}

	@Override
	@Transactional
	public Account createAccount(Account data) {
		em.persist(data);
		return data;
	}
}
