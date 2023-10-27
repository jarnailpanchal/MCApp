package com.market.connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.dto.UserDto;
import com.market.connect.mapper.PageableRequest;
import com.market.connect.service.UserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@GetMapping(value = "/all")
	public List<UserDto> getAllUsers() {

		return userService.findAll();
	}
	
	@GetMapping(path = "/getAllUsers")
	  public Page<UserDto> getAllAgentMessages(@RequestParam("page") int page,
	      @RequestParam("size") int size,
	      @RequestParam("sort") String sort) {

	    Page<UserDto> projects =
	    		userService.searchUsers( page, size, sort);
	    return projects;
	  }
}
