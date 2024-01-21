package com.market.connect.controller;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.Response;
import com.market.connect.dto.UserDto;
import com.market.connect.service.UserService;
import com.market.connect.util.ResponseBuilder;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	@Autowired
	private UserService userService;

	@PutMapping("/update")
	public Response<UserDto> updateUser(
			@RequestParam("userId") Long userId,
			@RequestParam("firstName") String firstName, 
			@RequestParam("lastName") String lastName , 
			@RequestParam("birthDate") Instant birthDate ,
			@RequestParam("file") MultipartFile file) {
		Response<UserDto> finalResponse = null;
		UserDto response = new UserDto();
		try {
			response = userService.updateUser(userId, firstName, lastName, birthDate, file);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
		} catch (Exception e) {
			finalResponse = ResponseBuilder.createResponse(false, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), response);
		}
		return finalResponse;
	}
	
	@PostMapping("/get/id")
	public Response<UserDto> getUserById(
			@RequestParam("userId") Long userId) {
		Response<UserDto> finalResponse = null;
		UserDto response = new UserDto();
		try {
			response = userService.getUserById(userId);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
		} catch (Exception e) {
			finalResponse = ResponseBuilder.createResponse(false, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), response);
		}
		return finalResponse;
	}

}
