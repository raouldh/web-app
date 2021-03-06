package nl.rdehaard.webapp.core.services.util;

import java.util.ArrayList;
import java.util.List;

import nl.rdehaard.webapp.core.model.entities.Account;

public class AccountList {
	private List<Account> accounts = new ArrayList<Account>();

	public AccountList(List<Account> list) {
		this.accounts = list;
	}

	public List<Account> getAccounts() {
		return accounts;
	}

	public void setAccounts(List<Account> accounts) {
		this.accounts = accounts;
	}
}