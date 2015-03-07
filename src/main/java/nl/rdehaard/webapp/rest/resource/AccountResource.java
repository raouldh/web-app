package nl.rdehaard.webapp.rest.resource;

import nl.rdehaard.webapp.core.model.entities.Account;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountResource extends ResourceSupport {
	private String name;

	private String password;

	private Long rid;

	public Long getRid() {
		return rid;
	}

	public void setRid(Long rid) {
		this.rid = rid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@JsonIgnore
	public String getPassword() {
		return password;
	}

	@JsonProperty
	public void setPassword(String password) {
		this.password = password;
	}

	public Account toAccount() {
		Account account = new Account();
		account.setName(name);
		account.setPassword(password);
		return account;
	}
}
