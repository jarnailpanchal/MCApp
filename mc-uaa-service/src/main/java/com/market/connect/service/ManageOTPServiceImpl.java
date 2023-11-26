package com.market.connect.service;

import java.nio.ByteBuffer;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.entity.ManagePassword;
import com.market.connect.repository.ManagePasswordRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ManageOTPServiceImpl implements ManageOTPService {

	@Autowired
	ManagePasswordRepository managePasswordRepository;

	@Transactional
	@Override
	public String generateOtpSecurityKey() {
		log.info("inside generate otp security key 👽 ");
		// Generate a random byte array for the secret key
		byte[] buffer = new byte[10]; // You can adjust the length as needed
		new SecureRandom().nextBytes(buffer);

		log.info("security key generated successfully 👽 ");
		// Encode the byte array as a Base32 string
		return new Base64().encodeToString(buffer);
	}

	@Transactional
	@Override
	public Boolean generateAndSendOtp(String secreteKey, String mobileNumber, String userType) {
		Boolean isOtpSent = false;
		try {
			log.info("generate and send otp funcation start here 👽 " + mobileNumber);
			String otp = generateOTP(secreteKey);
			log.info("generate and send otp funcation start here 👽 with otp :" + otp);
			ManagePassword managerPasswordEntity = managePasswordRepository.findByMobileNumber(mobileNumber);
			if (managerPasswordEntity == null) {
				log.info("generate and send otp funcation when user doesn't exist start here 👽 with params otp :" + otp
						+ " : mobile number : " + mobileNumber);
				ManagePassword managerPassword = new ManagePassword();
				managerPassword.setCreatedBy(mobileNumber);
				managerPassword.setCreatedDate(Instant.now());
				managerPassword.setOtpValue(otp);
				managerPassword.setStatus("1");
				managerPassword.setOtpSource(mobileNumber);
				managerPassword.setMobileNumber(mobileNumber);
				managerPassword.setOtpSource(mobileNumber);
				managePasswordRepository.save(managerPassword);
				log.info(
						"generate and send otp funcation when user doesn't exist and saved successfully start here 👽 with params otp :"
								+ otp + " : mobile number : " + mobileNumber);
				sendOTP(mobileNumber, otp);
				log.info(
						"generate and send otp funcation when user doesn't exist and saved and sent successfully to the user successfully start here 👽 with params otp :"
								+ otp + " : mobile number : " + mobileNumber);
				isOtpSent = true;
			} else if (managerPasswordEntity != null && userType.equalsIgnoreCase(MarketConnectConstant.USER_STATE_New)
					&& managerPasswordEntity.getUserId() == null) {
				managerPasswordEntity.setOtpValue(otp);
				managePasswordRepository.save(managerPasswordEntity);
				sendOTP(mobileNumber, otp);
				isOtpSent = true;
			} else if (managerPasswordEntity != null && !userType.equalsIgnoreCase(MarketConnectConstant.USER_STATE_New)
					&& managerPasswordEntity.getUserId() != null) {
				managerPasswordEntity.setOtpValue(otp);
				managePasswordRepository.save(managerPasswordEntity);
				sendOTP(mobileNumber, otp);
			} else {
				isOtpSent = false;
				MarketConnectConstant.StatusCode.RESPONSE_FAIL = MarketConnectConstant.StatusCode.SUCCESS_CODE;
				throw new RuntimeException("user already exist with this mobile number");
			}

			log.info("otp generate and validate successfully 👽 " + otp + ": mobile number : " + mobileNumber);
		} catch (Exception e) {
			log.error("error while generating/sending otp 👽 ");
			e.printStackTrace();
			MarketConnectConstant.StatusCode.RESPONSE_FAIL = "500";
			throw e;
		}
		return isOtpSent;
	}

	@Transactional
	@Override
	public String generateOTP(String secretKey) {
		try {
			long timeStep = 30; // TOTP time step (in seconds)
			long timestamp = Instant.now().getEpochSecond() / timeStep;
			byte[] keyBytes = secretKey.getBytes();

			// Convert the timestamp to bytes
			ByteBuffer buffer = ByteBuffer.allocate(8);
			buffer.putLong(timestamp);
			byte[] timeBytes = buffer.array();

			// Generate the HMAC-SHA1 hash
			SecretKeySpec key = new SecretKeySpec(keyBytes, "HmacSHA1");
			Mac mac = Mac.getInstance("HmacSHA1");
			mac.init(key);
			byte[] hash = mac.doFinal(timeBytes);

			// Calculate the offset for the OTP
			int offset = hash[hash.length - 1] & 0x0F;
			int truncatedHash = 0;
			for (int i = offset; i < offset + 4; i++) {
				truncatedHash <<= 8;
				truncatedHash |= hash[i] & 0xFF;
			}
			truncatedHash &= 0x7FFFFFFF;
			truncatedHash %= 1000000; // 6-digit OTP

			// Format the OTP as a 6-digit string
			return String.format("%06d", truncatedHash);
		} catch (NoSuchAlgorithmException | InvalidKeyException e) {
			e.printStackTrace();
			return null;
		}
	}

	@Transactional
	@Override
	public void sendOTP(String mobileNumber, String otp) {
		// TODO need to add send OTP functionality
	}

	@Transactional
	@Override
	public Boolean verifyOtp(String mobileNumber, String otp) {
		Boolean isOtpVerfied = false;
		try {
			log.info(
					"verifyOtp execution start here with param 👽 : OTP :" + otp + ": mobile number : " + mobileNumber);
			ManagePassword managerPasswordEntity = managePasswordRepository.findByMobileNumberAndOtpValue(mobileNumber,
					otp);
			if (managerPasswordEntity != null) {
				isOtpVerfied = MarketConnectConstant.True;
			} else {
				MarketConnectConstant.StatusCode.RESPONSE_FAIL = MarketConnectConstant.StatusCode.SUCCESS_CODE;
				throw new RuntimeException("OTP not verified!");
			}
		} catch (Exception e) {
			log.error("error while generating/sending otp 👽 ");
			e.printStackTrace();
			MarketConnectConstant.StatusCode.RESPONSE_FAIL = "500";
			throw e;
		}
		return isOtpVerfied;
	}
}
