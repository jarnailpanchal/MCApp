package com.market.connect.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

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
public class RatingManagerDto {

	private Long ratingId;
	
	@Max(value = 5, message = "Rating value cannot be greater than 5")
    @Min(value = 0, message = "Rating value cannot be less than 0")
	private String ratedValue;
	private Long userId;
	private String ratingComment;
	private Long companyId;
	private Short status;
	
}
