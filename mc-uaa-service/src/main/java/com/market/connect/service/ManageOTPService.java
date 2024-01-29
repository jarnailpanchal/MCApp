package com.market.connect.service;

import com.market.connect.dto.UserDto;

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
	UserDto verifyOtp(String mobileNumber, String otp);
}
