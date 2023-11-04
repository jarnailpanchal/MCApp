package com.market.connect.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.service.ManageOTPService;

@RestController
@RequestMapping(value = "/OTP")
public class ManageOTPController {

	@Autowired
	private ManageOTPService otpService;

	//to generate the security key for otp generation
	@GetMapping("/generateSecuriyKey")
	public String generateOtpSecurityKey() {
		return otpService.generateOtpSecurityKey();
	}

	//to generate and send the otp with secrete key
	@PutMapping("/generate/send")
	public Boolean generateAndSendOtp(@RequestParam("secreteKey") String secreteKey,
			@RequestParam("mobileNumber") String mobileNumber, @RequestParam("userType") String userType) {
		return otpService.generateAndSendOtp(secreteKey, mobileNumber, userType);
	}
	
	//to verify the user
	@GetMapping("/verify")
	public Boolean verifyOtp(@RequestParam("mobileNumber") String mobileNumber,
			@RequestParam("otp") String otp) {
		return otpService.verifyOtp(mobileNumber, otp);
	}

}
