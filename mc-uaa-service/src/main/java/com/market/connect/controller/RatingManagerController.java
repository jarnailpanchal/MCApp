package com.market.connect.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.dto.RatingManagerDto;
import com.market.connect.service.RatingManagerService;

import ch.qos.logback.core.boolex.EvaluationException;

@RestController
@RequestMapping(value = "/rating")
public class RatingManagerController {

	@Autowired
	private RatingManagerService ratingManagerService;

	// to save the category
	@PostMapping("/save")
	public RatingManagerDto saveCategory(@Valid @RequestBody RatingManagerDto ratingManagerDto) throws EvaluationException {
		return ratingManagerService.save(ratingManagerDto);
	}

	@GetMapping(path = "/getAll")
	public Page<RatingManagerDto> getAllCategory(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("sort") String sort) {
		return ratingManagerService.searchRatings(page, size, sort);
	}
	
}
