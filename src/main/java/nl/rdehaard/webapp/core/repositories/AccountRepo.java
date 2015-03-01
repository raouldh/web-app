package nl.rdehaard.webapp.core.repositories;

import nl.rdehaard.webapp.core.model.entities.Account;
import nl.rdehaard.webapp.core.model.entities.Blog;

public interface AccountRepo {

	public Account findAccount(Long id);

	public Account createAccount(Account data);

	public Blog createBlog(Long accountId, Blog data);
}
