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
public class CategoryManagerDto {

	private Long categoryId;
	
	@NotEmpty(message = "category name can't be blank")
	@NotNull(message = "category name can't be null")
	private String categoryName;
	private Short status;
	private Instant createdDate;
	private String createdBy;
	private Instant updateDate;
	private String updatedBy;
	
}
