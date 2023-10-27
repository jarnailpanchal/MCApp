package com.market.connect.dto;

import java.util.Date;

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
	private String firstName;
	private String middleName;
	private String lastName;
	private Integer age;
	private String emailAddress;
	private String phoneNumber;
	private String address;
	private String city;
	private String state;
	private String country;
	private String pincode;
	private String roleId;
	private String imageUrl;
	private String companyName;
	private String password;
	private Short status;
	private Date createdDate;
	private String createdBy;
	private Date updateDate;
	private String updatedBy;
	private String categoryId;
	private String companyId;

}
