/**
 *
 */
package com.example.demo.security.principle;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import com.example.demo.model.UserInfo;

@Component
public class PrincipalImpl implements Principal
{

	@Override
	public UserInfo getUserInfo()
	{
		return (UserInfo) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

}
