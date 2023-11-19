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
@Table(name = "banner_manager")
@Where(clause = "status = 1")
public class BannerManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bannerManagerId;
	@Column(name = "banner_url")
	private String bannerUrl;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "company_id")
	private String companyId;
	@Column(name = "type")
	private String type;
	@Column(name = "Status")
	private Short status;
	@Column(name = "verification_status")
	private String verificationStatus;
	@Column(name = "created_date")
	private Instant createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "update_date")
	private Instant updateDate;
	@Column(name = "updated_by")
	private String updatedBy;

}
