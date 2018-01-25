package com.example.demo.Controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {


	@RequestMapping("/login")
	public Principal getUserInfo(Principal principal){
        return principal;
	}

}
