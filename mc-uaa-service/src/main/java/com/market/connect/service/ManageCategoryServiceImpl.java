package com.market.connect.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.ManageCategoryDto;
import com.market.connect.entity.CategoryManager;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.ManageCategoryRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class ManageCategoryServiceImpl implements ManageCategoryService {

	@Autowired
	private ManageCategoryRepository manageCategoryRepository;

	@Override
	public ManageCategoryDto save(ManageCategoryDto manageCategoryDto) {
		log.info("save category exectution start here 👽 ");
		manageCategoryDto.setCreatedBy(MarketConnectConstant.ADMIN);
		manageCategoryDto.setCreatedDate(Instant.now());
		manageCategoryDto.setStatus(Short.valueOf("1"));
		CategoryManager categoryManagerEntity = MCMapper.INSTANCE
				.manageCategoryDtoToCategoryManagerEntity(manageCategoryDto);
		log.info("save category exectuted successfully 👽 ");
		return MCMapper.INSTANCE.toCategoryManagerDto(manageCategoryRepository.save(categoryManagerEntity));
	}

}
