package nl.rdehaard.webapp.core.security;

import java.util.ArrayList;
import java.util.Collection;

import nl.rdehaard.webapp.core.model.entities.Account;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class AccountUserDetails implements UserDetails {
	private static final long serialVersionUID = 288136400106137011L;
	private final Account account;

	public AccountUserDetails(Account account) {
		this.account = account;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		GrantedAuthority authority = new GrantedAuthority() {
			private static final long serialVersionUID = -6238638377813915584L;

			@Override
			public String getAuthority() {
				return "USER";
			}
		};

		ArrayList<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(authority);
		return authorities;
	}

	@Override
	public String getPassword() {
		return account.getPassword();
	}

	@Override
	public String getUsername() {
		return account.getName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}
