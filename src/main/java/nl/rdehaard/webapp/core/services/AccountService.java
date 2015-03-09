package nl.rdehaard.webapp.core.services;

import nl.rdehaard.webapp.core.model.entities.Account;
import nl.rdehaard.webapp.core.model.entities.Blog;
import nl.rdehaard.webapp.core.services.util.AccountList;
import nl.rdehaard.webapp.core.services.util.BlogList;

public interface AccountService {
	Account findAccount(Long id);

	Account createAccount(Account data);

	Blog createBlog(Long accountId, Blog data);

	BlogList findBlogsByAccount(Long accountId);

	AccountList findAllAccounts();

	Account findByAccountName(String name);
}
