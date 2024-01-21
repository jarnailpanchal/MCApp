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
@Table(name = "company_manager")
@Where(clause = "status = 1")
public class CompanyManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "company_id")
	private Long companyId;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "company_address")
	private String companyAddress;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "company_start_date")
	private Instant companyStartDate;
	@Column(name = "counry")
	private String country;
	@Column(name = "longtitude")
	private String longtitude;
	@Column(name = "latitude")
	private String latitude;
	@Column(name = "category_id")
	private Long categoryId;
	@Column(name = "description")
	private String description;
	@Column(name = "status")
	private Short status;
	@Column(name = "created_date")
	private Instant createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "update_date")
	private Instant updateDate;
	@Column(name = "updated_by")
	private String updatedBy;
}
