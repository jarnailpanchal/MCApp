package com.market.connect.controller;

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
import com.market.connect.dto.RoleDto;
import com.market.connect.service.RoleService;
import com.market.connect.util.ResponseBuilder;

import ch.qos.logback.core.boolex.EvaluationException;

@RestController
@RequestMapping(value = "/role")
public class RoleController {

	@Autowired
	private RoleService roleService;

	// to save the category
	@PostMapping("/save")
	public RoleDto saveCategory(@Valid @RequestBody RoleDto roleDto) throws EvaluationException {
		return roleService.save(roleDto);
	}

	@PostMapping(path = "/getAll")
	public Response<Page<RoleDto>> getAllCategory(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("sort") String sort) {
		Response<Page<RoleDto>> finalResposne = null;
		Page<RoleDto> response = null;
		try {
			response = roleService.searchRoles(page, size, sort);
			finalResposne = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
			} catch (Exception e) {
				finalResposne = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
						e.getMessage(), response);
			}
		return finalResposne;
	}
}
