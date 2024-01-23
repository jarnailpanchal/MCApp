package com.market.connect.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.AvailabilityManagerDto;
import com.market.connect.dto.Response;
import com.market.connect.service.AvailabilityManagerService;
import com.market.connect.util.ResponseBuilder;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/availability")
public class AvailabilityManagerController {

	@Autowired
	private AvailabilityManagerService availabilityManagerService;

	// to save the timing
	@PostMapping("/save")
	public Response<List<AvailabilityManagerDto>> saveAvailabilityManager(
			@Valid @RequestBody List<AvailabilityManagerDto> availabilityManagerDto) {
		log.info("controller's saveAvailabilityManager method execution start here ");
		List<AvailabilityManagerDto> response = new ArrayList<>();
		Response<List<AvailabilityManagerDto>> finalResponse = null;
		try {
			response = availabilityManagerService.saveAvailabilityManager(availabilityManagerDto);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
		} catch (Exception e) {
			finalResponse = ResponseBuilder.createResponse(false, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), response);
		}
		return finalResponse;
	}
}
