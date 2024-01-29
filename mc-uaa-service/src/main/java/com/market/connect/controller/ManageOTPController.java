package com.market.connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.Response;
import com.market.connect.dto.UserDto;
import com.market.connect.service.ManageOTPService;
import com.market.connect.util.ResponseBuilder;

@RestController
@RequestMapping(value = "/OTP")
public class ManageOTPController {

	@Autowired
	private ManageOTPService otpService;

	// to generate the security key for otp generation
	@GetMapping("/generateSecuriyKey")
	public String generateOtpSecurityKey() {
		return otpService.generateOtpSecurityKey();
	}

	// to generate and send the otp with secrete key
	@PostMapping("/generate/send/{mobileNumber}/{userType}")
	public Response<Boolean> generateAndSendOtp(@PathVariable("mobileNumber") String mobileNumber,
			@PathVariable("userType") String userType) {
		Response<Boolean> finalResposne = null;
		try {
		Boolean response = otpService.generateAndSendOtp(generateOtpSecurityKey(), mobileNumber, userType);
		finalResposne = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
				MarketConnectConstant.SUCCESS, response);
		} catch (Exception e) {
			finalResposne = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), false);
		}
		return finalResposne;
	}

	// to verify the user
	@PostMapping("/verify")
	public Response<UserDto> verifyOtp(@RequestParam("mobileNumber") String mobileNumber,
			@RequestParam("otp") String otp) {
		Response<UserDto> finalResponse = null;
		UserDto response = new UserDto();
		try {
			response = otpService.verifyOtp(mobileNumber, otp);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
			} catch (Exception e) {
				finalResponse = ResponseBuilder.createResponse(false, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
						e.getMessage(), response);
			}
		return finalResponse;
	}

}
