package com.market.connect.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.Response;
import com.market.connect.service.LocalityService;
import com.market.connect.util.ResponseBuilder;

@RestController
@RequestMapping(value = "/locality")
public class LocalityController {

	@Autowired
	private LocalityService getLocalAddressService;
	
	@PostMapping("/all/countries")
	public Response<List<String>> getAllCountries() {
		 Response<List<String>> finalResponse = null;
			List<String> response = null;
			try {
				response = getLocalAddressService.findAllCountries();
				finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
						MarketConnectConstant.SUCCESS, response);
				} catch (Exception e) {
					finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
							e.getMessage(), response);
				}
			return finalResponse;
	}
	
	@PostMapping("/get/states")
	public Response<List<String>> getAllStatesByCountry(@RequestParam("country") String country) {
		 Response<List<String>> finalResponse = null;
			List<String> response = null;
			try {
				response = getLocalAddressService.findAllStateByCountry(country);
				finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
						MarketConnectConstant.SUCCESS, response);
				} catch (Exception e) {
					finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
							e.getMessage(), response);
				}
			return finalResponse;
	}
	
	@PostMapping("/get/cities")
	public Response<List<String>> findAllCitiesByState(@RequestParam("state") String state) {
		 Response<List<String>> finalResponse = null;
			List<String> response = null;
			try {
				response = getLocalAddressService.findAllCitiesByState(state);
				finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
						MarketConnectConstant.SUCCESS, response);
				} catch (Exception e) {
					finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
							e.getMessage(), response);
				}
			return finalResponse;
	}
}
