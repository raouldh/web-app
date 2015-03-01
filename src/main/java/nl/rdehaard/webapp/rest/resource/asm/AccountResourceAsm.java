package nl.rdehaard.webapp.rest.resource.asm;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;
import nl.rdehaard.webapp.core.model.entities.Account;
import nl.rdehaard.webapp.rest.mvc.AccountController;
import nl.rdehaard.webapp.rest.resource.AccountResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class AccountResourceAsm extends
		ResourceAssemblerSupport<Account, AccountResource> {
	public AccountResourceAsm() {
		super(AccountController.class, AccountResource.class);
	}

	@Override
	public AccountResource toResource(Account account) {
		AccountResource res = new AccountResource();
		res.setName(account.getName());
		res.setPassword(account.getPassword());
		res.add(linkTo(
				methodOn(AccountController.class).getAccount(account.getId()))
				.withSelfRel());
		res.add(linkTo(
				methodOn(AccountController.class).findAllBlogs(account.getId()))
				.withRel("blogs"));
		return res;
	}
}
