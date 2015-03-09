package nl.rdehaard.webapp.core.repositories;

import java.util.List;

import nl.rdehaard.webapp.core.model.entities.Account;

public interface AccountRepo {
	List<Account> findAllAccounts();

	Account findAccount(Long id);

	Account findAccountByName(String name);

	Account createAccount(Account data);
}
