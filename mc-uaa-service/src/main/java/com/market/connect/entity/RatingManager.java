package com.market.connect.entity;

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
public class RatingManager {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "rating_id")
	private Long ratingId;
	@Column(name = "rated_value")
	private String ratedValue;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "rating_comment")
	private String ratingComment;
	@Column(name = "company_id")
	private Long companyId;
	@Column(name = "status")
	private Short status;

}
