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

import com.market.connect.dto.BannerManagerDto;
import com.market.connect.dto.ManageCategoryDto;
import com.market.connect.service.BannerManagerService;

@RestController
@RequestMapping(value = "/banner")
public class BannerManagerController {

	@Autowired
	private BannerManagerService bannerManagerService;

	// to save the category
	@PostMapping("/save")
	public BannerManagerDto saveCategory(@Valid @RequestBody BannerManagerDto bannerManagerDto) {
		return bannerManagerService.save(bannerManagerDto);
	}

	@GetMapping(path = "/getAll")
	public Page<ManageCategoryDto> getAllCategory(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("sort") String sort) {
		Page<ManageCategoryDto> categories = bannerManagerService.searchCategories(page, size, sort);
		return categories;
	}

}
