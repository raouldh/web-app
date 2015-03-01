package nl.rdehaard.webapp.core.services;

import nl.rdehaard.webapp.core.model.entities.Account;
import nl.rdehaard.webapp.core.model.entities.Blog;
import nl.rdehaard.webapp.core.services.util.AccountList;
import nl.rdehaard.webapp.core.services.util.BlogList;

public interface AccountService {
	public Account findAccount(Long id);

	public Account createAccount(Account data);

	public Blog createBlog(Long accountId, Blog data);

	public BlogList findBlogsByAccount(Long accountId);

	public AccountList findAllAccounts();

	public Account findByAccountName(String name);
}
