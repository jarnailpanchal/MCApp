package com.market.connect.service;

import org.springframework.data.domain.Page;

import com.market.connect.dto.ManageCategoryDto;

public interface ManageCategoryService {

	ManageCategoryDto save(ManageCategoryDto manageCategoryDto);

	Page<ManageCategoryDto> searchCategories(int page, int size, String sort);

}
