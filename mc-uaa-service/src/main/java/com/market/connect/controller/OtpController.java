package com.market.connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.service.OtpService;

@RestController
@RequestMapping(value = "/otp")
public class OtpController {

	@Autowired
	private OtpService otpService;

	@GetMapping("/generateSecuriyKey")
	public String generateOtpSecurityKey() {
		return otpService.generateOtpSecurityKey();
	}

	@PutMapping("/generate/send")
	public Boolean generateAndSendOtp(@RequestParam("secreteKey") String secreteKey,
			@RequestParam("mobileNumber") String mobileNumber, @RequestParam("userType") String userType) {
		return otpService.generateAndSendOtp(secreteKey, mobileNumber, userType);
	}
	
	@PutMapping("/verify")
	public Boolean verifyOtp(@RequestParam("mobileNumber") String mobileNumber,
			@RequestParam("otp") String otp) {
		return otpService.verifyOtp(mobileNumber, otp);
	}

}
