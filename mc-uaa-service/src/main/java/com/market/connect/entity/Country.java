package com.market.connect.entity;

import java.time.Instant;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Where;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "country")
@Where(clause = "status = 1")
public class Country {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "country_id")
	private Long countryId;
	
	@Column(name = "country_name")
	private String countryName;
	
	@Column(name = "short_name")
	private String shortName;
	
	@Column(name = "phone_code")
	private Integer phoneCode;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "created_date")
	private Instant createdDate;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "update_date")
	private Instant updatedDate;
	
	@Column(name = "updated_by")
	private String updatedBy;
	
	
	
}
