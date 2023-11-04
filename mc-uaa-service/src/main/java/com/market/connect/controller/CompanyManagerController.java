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

import com.market.connect.dto.CompanyManagerDto;
import com.market.connect.service.CompanyManagerService;

@RestController
@RequestMapping(value = "/company")
public class CompanyManagerController {

	@Autowired
	private CompanyManagerService companyManagerService;

	// to save the category
	@PostMapping("/save")
	public CompanyManagerDto saveCategory(@Valid @RequestBody CompanyManagerDto companyManagerDto) {
		return companyManagerService.save(companyManagerDto);
	}

	@GetMapping(path = "/getAll")
	public Page<CompanyManagerDto> getAllCategory(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("sort") String sort) {
		Page<CompanyManagerDto> categories = companyManagerService.searchCompanies(page, size, sort);
		return categories;
	}

}
