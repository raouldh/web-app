package nl.rdehaard.webapp.core.services.impl;

import nl.rdehaard.webapp.core.model.entities.Account;
import nl.rdehaard.webapp.core.model.entities.Blog;
import nl.rdehaard.webapp.core.repositories.AccountRepo;
import nl.rdehaard.webapp.core.repositories.BlogRepo;
import nl.rdehaard.webapp.core.services.AccountService;
import nl.rdehaard.webapp.core.services.exceptions.AccountDoesNotExistException;
import nl.rdehaard.webapp.core.services.exceptions.AccountExistsException;
import nl.rdehaard.webapp.core.services.exceptions.BlogExistsException;
import nl.rdehaard.webapp.core.services.util.AccountList;
import nl.rdehaard.webapp.core.services.util.BlogList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AccountServiceImpl implements AccountService {

	@Autowired
	private AccountRepo accountRepo;
	@Autowired
	private BlogRepo blogRepo;

	@Override
	public Account findAccount(Long id) {
		return accountRepo.findAccount(id);
	}

	@Override
	public Account createAccount(Account data) {
		Account account = accountRepo.findAccountByName(data.getName());
		if (account != null) {
			throw new AccountExistsException();
		}
		return accountRepo.createAccount(data);
	}

	@Override
	public Blog createBlog(Long accountId, Blog data) {
		Blog blogSameTitle = blogRepo.findBlogByTitle(data.getTitle());
		if (blogSameTitle != null) {
			throw new BlogExistsException();
		}
		Account account = accountRepo.findAccount(accountId);
		if (account == null) {
			throw new AccountDoesNotExistException();
		}
		Blog createdBlog = blogRepo.createBlog(data);
		createdBlog.setOwner(account);
		return createdBlog;
	}

	@Override
	public BlogList findBlogsByAccount(Long accountId) {
		Account account = accountRepo.findAccount(accountId);
		if (account == null) {
			throw new AccountDoesNotExistException();
		}
		return new BlogList(blogRepo.findBlogsByAccount(accountId));
	}

	@Override
	public AccountList findAllAccounts() {
		return new AccountList(accountRepo.findAllAccounts());
	}

	@Override
	public Account findByAccountName(String name) {
		return accountRepo.findAccountByName(name);
	}
}