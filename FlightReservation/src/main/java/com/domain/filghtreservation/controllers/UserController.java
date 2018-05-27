package com.domain.filghtreservation.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.domain.filghtreservation.entities.User;
import com.domain.filghtreservation.repos.UserRepositry;
import com.domain.filghtreservation.service.SecurityService;

@Controller
public class UserController {

	private static final Logger LOGGER=LoggerFactory.getLogger(UserController.class);
	
	
	@Autowired
	private UserRepositry userRepositry;
	
	@Autowired
	private SecurityService securityService;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@RequestMapping("/showregister")
	public String userRegistration() {
		return"login/registerUser";
	}
	
	@RequestMapping(value="/registerUser",method=RequestMethod.POST)
	public String register(@ModelAttribute("user")User user) {
	
		user.setPassword(encoder.encode(user.getPassword()));
		  userRepositry.save(user);
		
		return"login/login";
	}

	@RequestMapping("/showlogin")
	public String userLogin() {
		return"login/login";
	}
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public String login(@RequestParam("email") String email, @RequestParam("password") String password,ModelMap modelMap) {
		
		LOGGER.error("ERROR");
		LOGGER.warn("WARN");
		LOGGER.info("INFO");
		LOGGER.debug("DEBUG");
		LOGGER.trace("TRACE");
		
		boolean loginResponse = securityService.login(email, password);
		if(loginResponse) {
			return"findFlights";
		}else {
			modelMap.addAttribute("msg","Invalid User name and password!!!!");
		}
		return"login/login";
	}
	
}
