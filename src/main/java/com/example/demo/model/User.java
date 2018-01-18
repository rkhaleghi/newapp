/**
 *
 */
package com.example.demo.model;

import java.util.Collection;
import java.util.Collections;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 * @author RezaKhaleghi
 *
 */
@Table
@Entity
public class User implements UserDetails
{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String firstName;
	private String lastName;
	private String email;
	private String password;
	private String username;
	private boolean enabled;
	private Authority authority;

	public User(Integer id, String firstName, String lastName, String email)
	{
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}

	public User(String username, String password, boolean enabled)
	{
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}

	public User()
	{
	}

	public Integer getId()
	{
		return id;
	}

	public void setId(Integer id)
	{
		this.id = id;
	}

	public String getFirstName()
	{
		return firstName;
	}

	public void setFirstName(String firstName)
	{
		this.firstName = firstName;
	}

	public String getLastName()
	{
		return lastName;
	}

	public void setLastName(String lastName)
	{
		this.lastName = lastName;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public Authority getAuthority()
	{
		return authority;
	}

	public void setAuthority(Authority authority)
	{
		this.authority = authority;
	}


	public Collection<? extends GrantedAuthority> getAuthorities()
	{
		return Collections.singleton(() -> authority.getAuthority());
	}

	public String getPassword()
	{
		return password;
	}

	public String getUsername()
	{
		return username;
	}

	public boolean isAccountNonExpired()
	{
		return true;
	}

	public boolean isAccountNonLocked()
	{
		return true;
	}

	public boolean isCredentialsNonExpired()
	{
		return true;
	}

	public boolean isEnabled()
	{
		return true;
	}

}

/* ---------------------------------------------------------------------*
 * This software is the confidential and proprietary
 * information of Lhasa Limited
 * Granary Wharf House, 2 Canal Wharf, Leeds, LS11 5PS
 * ---
 * No part of this confidential information shall be disclosed
 * and it shall be used only in accordance with the terms of a
 * written license agreement entered into by holder of the information
 * with LHASA Ltd.
 * --------------------------------------------------------------------- */