package com.market.connect.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.market.connect.dto.BannerManagerDto;
import com.market.connect.entity.BannerManager;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.BannerManagerRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BannerManagerServiceImpl implements BannerManagerService {
	
	@Autowired
	private BannerManagerRepository bannerManagerRepository;
	
	@Override
	public BannerManagerDto save(BannerManagerDto bannerManagerDto) {
		BannerManager bannerManager = MCMapper.INSTANCE.toBannerManager(bannerManagerDto);
		bannerManager.setCreatedBy("Admin");
		bannerManager.setCreatedDate(Instant.now());
		bannerManager.setStatus(Short.valueOf("1"));
		log.info("save banner manager funcation start here");
		return MCMapper.INSTANCE.toBannerManagerDto(bannerManagerRepository.save(bannerManager));
	}

	@Override
	public Page<BannerManagerDto> searchBanners(int page, int size, String sort) {
		Pageable pageable = null;
	    if (sort != null) {
	      // with sorting
	      pageable = PageRequest.of(page, size, Sort.Direction.ASC, sort);
	    } else {
	      // without sorting
	      pageable = PageRequest.of(page, size);
	    }
	    return bannerManagerRepository.findAll(pageable).map(MCMapper.INSTANCE::toBannerManagerDto);
	}

}
