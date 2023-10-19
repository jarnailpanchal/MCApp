package com.market.connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.user.entity.User;
import com.market.connect.user.service.UserService;

@RestController
@RequestMapping(value = "/market-connect")
public class MarketConnectProController {

	@Autowired
	private UserService userService;
	
	@GetMapping(value = "/hello")
	public User sayHello() {
		
		return userService.findUser();
	}
}
