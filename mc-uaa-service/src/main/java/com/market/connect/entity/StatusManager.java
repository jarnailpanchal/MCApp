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
@Table(name = "status_manager")
@Where(clause = "status = 1")
public class StatusManager {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "status_id")
	private Long statusId;
	@Column(name = "status_name")
	private String statusName;
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
