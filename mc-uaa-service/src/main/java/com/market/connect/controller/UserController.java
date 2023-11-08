package com.market.connect.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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

	@PostMapping("/save")
	public UserDto saveCategory(@Valid @RequestBody UserDto userDto) throws Exception {
		return userService.save(userDto);
	}
	
	@PostMapping(path = "/get/users")
	  public Response<List<UserDto>> getAllAgentMessages(@RequestParam("category") String category) {
	    Response<List<UserDto>> finalResponse = null;
		List<UserDto> response = null;
		try {
			response = userService.searchUsers(category);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
			} catch (Exception e) {
				finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
						e.getMessage(), response);
			}
		return finalResponse;
	  }
}
