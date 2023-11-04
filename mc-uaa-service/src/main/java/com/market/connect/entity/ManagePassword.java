package com.market.connect.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "manage_password")
@Where(clause = "status = 1")
public class ManagePassword {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manage_password_id")
	private Long managerPasswordId;
	@Column(name = "status")
	private String status;
	@Column(name = "created_date")
	private Instant createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "update_date")
	private Instant updatedDate;
	@Column(name = "update_by")
	private String updateBy;
	@Column(name = "otp_value")
	private String otpValue;
	@Column(name = "otp_source")
	private String otpSource;
	@Column(name = "mobile_number")
	private String mobileNumber;
	@Column(name = "user_id")
	private Long userId;
}
