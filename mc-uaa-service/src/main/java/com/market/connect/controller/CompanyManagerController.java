package com.market.connect.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.CompanyCustomDetailFinalDto;
import com.market.connect.dto.CompanyManagerDto;
import com.market.connect.dto.CompanyWithCategoryCustomDto;
import com.market.connect.dto.Response;
import com.market.connect.service.CompanyManagerService;
import com.market.connect.util.ResponseBuilder;

@RestController
@RequestMapping(value = "/company")
public class CompanyManagerController {

	@Autowired
	private CompanyManagerService companyManagerService;

	// to save the company
	@PostMapping("/save")
	public Response<CompanyManagerDto> saveCompany(@Valid @RequestBody CompanyManagerDto companyManagerDto) {
		Response<CompanyManagerDto> finalResponse = null;
		CompanyManagerDto response = null;
		try {
			response = companyManagerService.save(companyManagerDto);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
		} catch(Exception e) {
			finalResponse = ResponseBuilder.createResponse(false, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), response);
		}
		return finalResponse;
	}

	@PostMapping(path = "/getAll")
	public Response<Page<CompanyManagerDto>> getAllCompany(@RequestParam("page") int page,
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
	
	@PostMapping(path = "/findByCategory")
	public Response<List<CompanyWithCategoryCustomDto>> getAllCompanyByCategoryId(@RequestParam("categoryId") Long categoryId,
			@RequestParam("latitude") double targetLatitude, @RequestParam("longitude") double targetLongitude,
			@RequestParam("distanceKm") double distanceKm) {
		Response<List<CompanyWithCategoryCustomDto>> finalResponse = null;
		List<CompanyWithCategoryCustomDto> response = null;
		try {
			response = companyManagerService.getAllCompanyByCategoryId(categoryId, targetLatitude, targetLongitude,distanceKm);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
		} catch (Exception e) {
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), response);
		}
		return finalResponse;
	}
	
	@PostMapping(path = "/getCompanyDetails/{companyId}")
	public Response<CompanyCustomDetailFinalDto> getCompanyDetailById(@PathVariable("companyId") Long companyId) {
		Response<CompanyCustomDetailFinalDto> finalResponse = null;
		CompanyCustomDetailFinalDto response = null;
		try {
			response = companyManagerService.getCompanyDetailById(companyId);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
		} catch (Exception e) {
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), response);
		}
		return finalResponse; 
	}
}
