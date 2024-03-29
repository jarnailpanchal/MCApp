package com.market.connect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.connect.dto.RatingManagerDto;
import com.market.connect.entity.RatingManager;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.RatingManagerRepository;

import ch.qos.logback.core.boolex.EvaluationException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class RatingManagerServiceImpl implements RatingManagerService {

	@Autowired
	private RatingManagerRepository ratingManagerRepository;

	@Transactional
	@Override
	public RatingManagerDto save(RatingManagerDto ratingManagerDto) throws EvaluationException {

		ratingManagerDto.setStatus(Short.valueOf("1"));
		RatingManager ratingManagerEntity = MCMapper.INSTANCE.toRatingManager(ratingManagerDto);
		List<RatingManager> ratingManagers = ratingManagerRepository
				.findByUserIdAndCompanyId(ratingManagerDto.getUserId(), ratingManagerDto.getCompanyId());
		
		if(ratingManagers.size() > 0) {
			List<Long> ids = ratingManagers.stream().map(RatingManager::getRatingId).toList();
			ratingManagerRepository.deleteAllById(ids);
		}
		
		log.info("save reating exectuted successfully 👽 ");
		return MCMapper.INSTANCE.toRatingManagerDto(ratingManagerRepository.save(ratingManagerEntity));
	}

	@Transactional
	@Override
	public Page<RatingManagerDto> searchRatings(int page, int size, String sort) {
		Pageable pageable = null;
		if (sort != null) {
			// with sorting
			pageable = PageRequest.of(page, size, Sort.Direction.ASC, sort);
		} else {
			// without sorting
			pageable = PageRequest.of(page, size);
		}
		return ratingManagerRepository.findAll(pageable).map(MCMapper.INSTANCE::toRatingManagerDto);
	}
}
