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
import com.market.connect.dto.CompanyManagerDto;
import com.market.connect.dto.Response;
import com.market.connect.service.CompanyManagerService;
import com.market.connect.util.ResponseBuilder;

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

	@PostMapping(path = "/getAll")
	public Response<Page<CompanyManagerDto>> getAllCategory(@RequestParam("page") int page,
			@RequestParam("size") int size, @RequestParam("sort") String sort) {
		Response<Page<CompanyManagerDto>> finalResponse = null;
		Page<CompanyManagerDto> response = null;
		try {
			response = companyManagerService.searchCompanies(page, size, sort);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
		} catch (Exception e) {
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), response);
		}
		return finalResponse;
	}
}
