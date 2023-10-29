package com.market.connect.service;

import java.time.Instant;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.expression.EvaluationException;
import org.springframework.stereotype.Service;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.CategoryManagerDto;
import com.market.connect.entity.CategoryManager;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.ManageCategoryRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CategoryManagerServiceImpl implements CategoryManagerService {

	@Autowired
	private ManageCategoryRepository manageCategoryRepository;

	@Override
	public CategoryManagerDto save(CategoryManagerDto manageCategoryDto) {
		log.info("save category exectution start here 👽 ");
		List<CategoryManager> category = manageCategoryRepository.findByCategoryName(manageCategoryDto.getCategoryName());
		if(category.size() > 0) {
			throw new UnsupportedOperationException(
		            "Category already exists - " + manageCategoryDto.getCategoryName());
		} else {
		manageCategoryDto.setCreatedBy(MarketConnectConstant.ADMIN);
		manageCategoryDto.setCreatedDate(Instant.now());
		manageCategoryDto.setStatus(Short.valueOf("1"));
		CategoryManager categoryManagerEntity = MCMapper.INSTANCE
				.manageCategoryDtoToCategoryManagerEntity(manageCategoryDto);
		log.info("save category exectuted successfully 👽 ");
		return MCMapper.INSTANCE.toCategoryManagerDto(manageCategoryRepository.save(categoryManagerEntity));
		}
	}
	
	@Override
	public Page<CategoryManagerDto> searchCategories(int page, int size, String sort) {
		Pageable pageable = null;
	    if (sort != null) {
	      // with sorting
	      pageable = PageRequest.of(page, size, Sort.Direction.ASC, sort);
	    } else {
	      // without sorting
	      pageable = PageRequest.of(page, size);
	    }
	    return manageCategoryRepository.findAll(pageable).map(MCMapper.INSTANCE::toCategoryManagerDto);
	}

}
