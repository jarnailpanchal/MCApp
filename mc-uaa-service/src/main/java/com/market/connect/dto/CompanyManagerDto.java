package com.market.connect.dto;

import java.time.Instant;

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
public class CompanyManagerDto {

	private Long companyId;
	private String companyType;
	private String companyAddress;
	private String city;
	private String state;
	private Long userId;
	private Instant companyStartDate;
	private String country;
	private String longtitude;
	private String latitude;
	private Long categoryId;
	private String description;
	private Short status;
	private Instant createdDate;
	private String createdBy;
	private Instant updateDate;
	private String updatedBy;
}
