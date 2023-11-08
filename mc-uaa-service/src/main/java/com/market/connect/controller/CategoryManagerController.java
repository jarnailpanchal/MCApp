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
import com.market.connect.dto.CategoryManagerDto;
import com.market.connect.dto.Response;
import com.market.connect.service.CategoryManagerService;
import com.market.connect.util.ResponseBuilder;

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

	@PostMapping(path = "/getAll")
	public Response<Page<CategoryManagerDto>> getAllCategory(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("sort") String sort) {
		Response<Page<CategoryManagerDto>> finalResponse = null;
		Page<CategoryManagerDto> response = null;
		try {
			response = manageCategoryService.searchCategories(page, size, sort);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
			} catch (Exception e) {
				finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
						e.getMessage(), response);
			}
		return finalResponse;
	}
}
