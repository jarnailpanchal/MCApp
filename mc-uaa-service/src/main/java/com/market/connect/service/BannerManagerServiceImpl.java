package com.market.connect.service;

import org.springframework.beans.factory.annotation.Autowired;
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
		log.info("save banner manager funcation start here");
		return MCMapper.INSTANCE.toBannerManagerDto(bannerManagerRepository.save(bannerManager));
	}

}
