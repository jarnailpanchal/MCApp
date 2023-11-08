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

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.CompanyManagerDto;
import com.market.connect.dto.RatingManagerDto;
import com.market.connect.dto.Response;
import com.market.connect.service.RatingManagerService;
import com.market.connect.util.ResponseBuilder;

import ch.qos.logback.core.boolex.EvaluationException;

@RestController
@RequestMapping(value = "/rating")
public class RatingManagerController {

	@Autowired
	private RatingManagerService ratingManagerService;

	// to save the category
	@PostMapping("/save")
	public RatingManagerDto saveCategory(@Valid @RequestBody RatingManagerDto ratingManagerDto) throws EvaluationException {
		return ratingManagerService.save(ratingManagerDto);
	}

	@GetMapping(path = "/getAll")
	public Response<Page<RatingManagerDto>> getAllCategory(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("sort") String sort) {
		Response<Page<RatingManagerDto>> finalResponse = null;
		Page<RatingManagerDto> response = null;
		try {
			response = ratingManagerService.searchRatings(page, size, sort);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
			} catch (Exception e) {
				finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
						e.getMessage(), response);
			}
		return finalResponse;
	}
	
}
