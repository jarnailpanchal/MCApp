package com.market.connect.dto;

import java.util.Date;
import java.util.List;

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
public class CompanyCustomDetailFinalDto {

	private Long categoryId;
	private String imageUrl;
	private Long companyId;
	private String companyName;
	private String companyAddress;
	private String longtitude;
	private String latitude;
	private String discription;
	private String mobileNumber;
	private Date openTime;
	private Date closingTime;
	private double rating;
	private String companyBanners;
	private Long ratedUserCount;
	private List<String> banners;
	
}
