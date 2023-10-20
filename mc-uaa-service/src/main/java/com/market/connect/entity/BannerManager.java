package com.market.connect.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
public class BannerManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String bannerManagerId;
	@Column(name = "banner_url")
	private String bannerUrl;
	@Column(name = "user_id")
	private String userId;
	@Column(name = "company_id")
	private String companyId;
	@Column(name = "Status")
	private Short status;
	@Column(name = "verification_status")
	private String verificationStatus;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "update_date")
	private Date updateDate;
	@Column(name = "updated_by")
	private String updatedBy;

}
