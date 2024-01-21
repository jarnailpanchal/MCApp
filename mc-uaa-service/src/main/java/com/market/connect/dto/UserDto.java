package com.market.connect.dto;

import java.time.Instant;

import javax.persistence.Column;
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
	private Long userId;
	@NotNull(message = "First Name can not be null")
	@NotBlank(message = "First Name can not be blank")
	private String firstName;
	private String middleName;
	private String lastName;
	//2023-10-29T18:30:00Z
	private Instant birthdDate;
	@NotNull(message = "Phone number can not be null")
	@NotBlank(message = "Phone number not be blank")
	@Pattern(regexp = "^(\\+[0-9]{1,3}[- ]?)?\\(?[0-9]{3}\\)?[- ]?[0-9]{3}[- ]?[0-9]{4}$",  message = "Invalid phone number format")
	private String phoneNumber;
	private String imageUrl;
	private Short status;
	private Instant updateDate;
	private String updatedBy;
	private Instant createdDate;
}
