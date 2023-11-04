package com.market.connect.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.dto.RoleDto;
import com.market.connect.service.RoleService;

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

	@GetMapping(path = "/getAll")
	public Page<RoleDto> getAllCategory(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("sort") String sort) {
		Page<RoleDto> categories = roleService.searchRoles(page, size, sort);
		return categories;
	}

}
