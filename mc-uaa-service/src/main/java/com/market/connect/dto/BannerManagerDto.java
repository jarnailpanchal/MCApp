package com.market.connect.dto;

import java.util.Date;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

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
public class BannerManagerDto {

	private Long bannerManagerId;
	
	@NotEmpty(message = "banner url can't be blank")
	@NotNull(message = "banner url can't be null")
	private String bannerUrl;
	private String userId;
	private String companyId;
	private Short status;
	
	@NotEmpty(message = "varifaction status can't be blank")
	@NotNull(message = "varifaction status can't be null")
	private String verificationStatus;
	private Date createdDate;
	private String createdBy;
	private Date updateDate;
	private String updatedBy;
}
