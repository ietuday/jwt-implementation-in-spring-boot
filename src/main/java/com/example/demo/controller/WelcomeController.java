package com.example.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.aop.ThrowsAdvice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.AuthenticateRequest;
import com.example.demo.util.JwtUtil;




@RequestMapping("/api")
@RestController
public class WelcomeController {

	
	Logger log = LoggerFactory.getLogger(WelcomeController.class);
	
	
	
	
	@Autowired
	private JwtUtil jwtUtil;
	
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	
	
	@GetMapping("/hello")
	public String welcome() {
		log.debug("Request {}");
		return "Hello World";
	}
	
	
	
	@RequestMapping(method = RequestMethod.GET, value = "/api/javainuse")
	public String sayHello() {
		return "Swagger Hello World";
	}
	
	@PostMapping("/authenticate")
	public String generateToken(@RequestBody AuthenticateRequest authenticateRequest) throws  Exception{
		
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(authenticateRequest.getUserName(),authenticateRequest.getPassword()));
		}catch (Exception ex){
			
			throw new Exception("invalid user name and password");
		}
		return jwtUtil.generateToken(authenticateRequest.getUserName());
	}
	
	
	
}
