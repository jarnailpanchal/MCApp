package com.market.connect.entity;

import java.sql.Time;
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
@Table(name = "availability_manager")
public class AvailabilityManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "company_id")
	private String companyId;
	@Column(name = "open_time")
	private Time openTime;
	@Column(name = "closing_time")
	private Time closingTime;
	@Column(name = "day_number")
	private String dayNumber;
	
}
