package com.example.demo.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.Principal;

@RestController
public class AuthController {


	@RequestMapping("/login")
	public Principal getUserInfo(Principal principal){
        return principal;
	}

}
