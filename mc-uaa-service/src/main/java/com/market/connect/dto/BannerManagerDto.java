package com.market.connect.dto;

import java.time.Instant;

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
	private Long companyId;
	private Short status;
	
	@NotEmpty(message = "varifaction status can't be blank")
	@NotNull(message = "varifaction status can't be null")
	private String verificationStatus;
	private Instant createdDate;
	private String createdBy;
	private Instant updateDate;
	private String updatedBy;
	private String type;
}
