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
public class RoleDto {

	private Long roleId;
	
	@NotEmpty(message = "role can't be blank")
	@NotNull(message = "role can't be null")
	private String roleName;
	private Short status;
	private Instant createdDate;
	private String createdBy;
	private Instant updateDate;
	private String updatedBy;
}
