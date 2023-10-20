package com.market.connect.entity;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
@Table(name = "category_manager")
public class ManagerPassword {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "manage_password_id")
	private String managerPasswordId;
	@Column(name = "password")
	private String password;
	@Column(name = "try_count")
	private Integer tryCount;
	@Column(name = "status")
	private String status;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "update_date")
	private Date updatedDate;
	@Column(name = "update_by")
	private String updateBy;
	@Column(name = "otp_value")
	private String otpValue;
	@Column(name = "otp_time")
	private Timestamp otpTime;
	@Column(name = "otp_source")
	private String topSource;
	@Column(name = "user_id")
	private String userId;
}
