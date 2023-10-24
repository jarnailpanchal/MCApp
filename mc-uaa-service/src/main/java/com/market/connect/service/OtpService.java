package com.market.connect.service;

public interface OtpService {

	String generateOtpSecurityKey();

	Boolean generateAndSendOtp(String secreteKey, String mobileNumber, String userType);

	String generateOTP(String secretKey);

	void sendOTP(String mobileNumber, String otp);

	Boolean verifyOtp(String mobileNumber, String otp);
}
