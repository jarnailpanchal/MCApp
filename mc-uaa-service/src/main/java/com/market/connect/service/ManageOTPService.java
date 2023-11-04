package com.market.connect.service;

public interface ManageOTPService {

	/**
	 * 
	 * @return
	 */
	String generateOtpSecurityKey();

	/**
	 * 
	 * @param secreteKey
	 * @param mobileNumber
	 * @param userType
	 * @return
	 */
	Boolean generateAndSendOtp(String secreteKey, String mobileNumber, String userType);

	/**
	 * 
	 * @param secretKey
	 * @return
	 */
	String generateOTP(String secretKey);

	/**
	 * 
	 * @param mobileNumber
	 * @param otp
	 */
	void sendOTP(String mobileNumber, String otp);

	/**
	 * 
	 * @param mobileNumber
	 * @param otp
	 * @return
	 */
	Boolean verifyOtp(String mobileNumber, String otp);
}
