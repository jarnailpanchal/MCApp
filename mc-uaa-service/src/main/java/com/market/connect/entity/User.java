package com.market.connect.entity;

import java.util.Date;

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
@Table(name = "user")
@Where(clause = "status = 1")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long userId;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "middle_name")
	private String middleName;
	@Column(name = "last_name")
	private String lastName;
	@Column(name = "age")
	private Integer age;
	@Column(name = "email_address")
	private String emailAddress;
	@Column(name = "phone_number")
	private String phoneNumber;
	@Column(name = "address")
	private String address;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	@Column(name = "country")
	private String country;
	@Column(name = "pincode")
	private String pincode;
	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "image_url")
	private String imageUrl;
	@Column(name = "company_name")
	private String companyName;
	@Column(name = "password")
	private String password;
	@Column(name = "Status")
	private Short status;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "update_date")
	private Date updateDate;
	@Column(name = "updated_by")
	private String updatedBy;
	@Column(name = "category_id")
	private Long categoryId;
	@Column(name = "company_id")
	private Long companyId;

}
