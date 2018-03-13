package com.example.demo.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.UserInfo;
import com.example.demo.security.principle.Principal;

@CrossOrigin("*")
@RestController
@RequestMapping(value = "/api/v1")
public class AuthController {

	@Autowired
	private Principal principal;

	@RequestMapping("/login")
	public UserInfo getUserInfo(){
		return principal.getUserInfo();

	}

}
