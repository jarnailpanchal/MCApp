package com.market.connect.service;

import org.springframework.data.domain.Page;

import com.market.connect.dto.RatingManagerDto;

import ch.qos.logback.core.boolex.EvaluationException;

public interface RatingManagerService {

	RatingManagerDto save(RatingManagerDto ratingManagerDto) throws EvaluationException;

	Page<RatingManagerDto> searchRatings(int page, int size, String sort);

}
