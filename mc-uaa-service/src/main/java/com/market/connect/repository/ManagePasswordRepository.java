package com.market.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.connect.entity.ManagePassword;

@Repository
public interface ManagePasswordRepository extends JpaRepository<ManagePassword, Long>{

	ManagePassword findByMobileNumber(String mobileNumber);

	ManagePassword findByMobileNumberAndOtpValue(String mobileNumber, String otp);

}
