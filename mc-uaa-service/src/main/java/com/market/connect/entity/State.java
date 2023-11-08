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
@Table(name = "state")
@Where(clause = "status = 1")
public class State {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_id")
	private Long stateId;
	
	@Column(name = "state_name")
	private String stateName;
	
	@Column(name = "country_id")
	private Long countryId;
	
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
