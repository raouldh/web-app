package nl.rdehaard.webapp.rest.resource.asm;

import java.util.List;

import nl.rdehaard.webapp.core.services.util.AccountList;
import nl.rdehaard.webapp.rest.mvc.AccountController;
import nl.rdehaard.webapp.rest.resource.AccountListResource;
import nl.rdehaard.webapp.rest.resource.AccountResource;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;

public class AccountListResourceAsm extends
		ResourceAssemblerSupport<AccountList, AccountListResource> {
	public AccountListResourceAsm() {
		super(AccountController.class, AccountListResource.class);
	}

	@Override
	public AccountListResource toResource(AccountList accountList) {
		List<AccountResource> resList = new AccountResourceAsm()
				.toResources(accountList.getAccounts());
		AccountListResource finalRes = new AccountListResource();
		finalRes.setAccounts(resList);
		return finalRes;
	}
}