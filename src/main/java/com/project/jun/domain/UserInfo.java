package com.project.jun.domain;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserInfo implements UserDetails {
	private int user_no;
	private String user_id;
	private String user_password;
	private String user_auth;
	private Collection<GrantedAuthority> authorities;

	public UserInfo() {
	}

	public UserInfo(int user_no, String user_id, String user_password, String user_auth,
			Collection<GrantedAuthority> authorities) {
		super();
		this.user_no = user_no;
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_auth = user_auth;
		this.authorities = authorities;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> authorities = new HashSet<>();
		if ("ADMIN".equals(user_auth)) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + user_auth));
		}
		if ("USER".equals(user_auth)) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + user_auth));
		}
		return authorities;
	}

	@Override
	public String getPassword() {
		return user_password;
	}

	@Override
	public String getUsername() {
		return user_id;
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

	public int getUser_no() {
		return user_no;
	}

	public void setUser_no(int user_no) {
		this.user_no = user_no;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getUser_password() {
		return user_password;
	}

	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}

	public String getUser_auth() {
		return user_auth;
	}

	public void setUser_auth(String user_auth) {
		this.user_auth = user_auth;
	}

	public void setAuthorities(Collection<GrantedAuthority> authorities) {
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "UserInfo [user_no=" + user_no + ", user_id=" + user_id + ", user_password=" + user_password
				+ ", user_auth=" + user_auth + ", authorities=" + authorities + "]";
	}

}
