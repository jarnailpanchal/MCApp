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

import com.market.connect.dto.CategoryManagerDto;
import com.market.connect.service.CategoryManagerService;

@RestController
@RequestMapping(value = "/category")
public class CategoryManagerController {

	@Autowired
	private CategoryManagerService manageCategoryService;

	// to save the category
	@PostMapping("/save")
	public CategoryManagerDto saveCategory(@Valid @RequestBody CategoryManagerDto manageCategoryDto) {
		return manageCategoryService.save(manageCategoryDto);
	}

	@GetMapping(path = "/getAll")
	public Page<CategoryManagerDto> getAllCategory(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("sort") String sort) {
		Page<CategoryManagerDto> categories = manageCategoryService.searchCategories(page, size, sort);
		return categories;
	}
}
