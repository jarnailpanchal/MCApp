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
@Table(name = "rating_manager")
@Where(clause = "status = 1")
public class Role {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "role_id")
	private Long roleId;
	@Column(name = "role_name")
	private String roleName;
	@Column(name = "status")
	private Short status;
	@Column(name = "created_date")
	private Date createdDate;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "update_date")
	private Date updateDate;
	@Column(name = "updated_by")
	private String updatedBy;
	
}
