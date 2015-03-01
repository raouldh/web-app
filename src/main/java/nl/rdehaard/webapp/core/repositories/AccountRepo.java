package nl.rdehaard.webapp.core.repositories;

import java.util.List;

import nl.rdehaard.webapp.core.model.entities.Account;

public interface AccountRepo {
	public List<Account> findAllAccounts();

	public Account findAccount(Long id);

	public Account findAccountByName(String name);

	public Account createAccount(Account data);
}
