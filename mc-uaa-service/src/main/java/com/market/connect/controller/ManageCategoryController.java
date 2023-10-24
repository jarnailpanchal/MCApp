package com.market.connect.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.dto.ManageCategoryDto;
import com.market.connect.service.ManageCategoryService;

@RestController
@RequestMapping(value = "/category")
public class ManageCategoryController {

	@Autowired
	private ManageCategoryService manageCategoryService;

	// to save the category
	@PostMapping("/save")
	public ManageCategoryDto saveCategory(@Valid @RequestBody ManageCategoryDto manageCategoryDto) {
		return manageCategoryService.save(manageCategoryDto);
	}
}
