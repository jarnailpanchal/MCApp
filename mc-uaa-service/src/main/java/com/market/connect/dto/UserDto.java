package com.market.connect.dto;

import java.time.Instant;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@JsonIgnoreProperties
public class UserDto {
	private String userId;
	@NotNull(message = "First Name can not be null")
	@NotBlank(message = "First Name can not be blank")
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer age;
	private String emailAddress;
	@NotNull(message = "Phone number can not be null")
	@NotBlank(message = "Phone number not be blank")
	@Pattern(regexp = "^(\\+[0-9]{1,3}[- ]?)?\\(?[0-9]{3}\\)?[- ]?[0-9]{3}[- ]?[0-9]{4}$",  message = "Invalid phone number format")
	private String phoneNumber;
	private String address;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private Long roleId;
	private String imageUrl;
	private String companyName;
	private String password;
	private Short status;
	private Instant createdDate;
	private String createdBy;
	private Instant updateDate;
	private String updatedBy;
	private String categoryId;
	private String companyId;
	private String categoryName;
}
