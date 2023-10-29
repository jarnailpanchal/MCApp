package com.market.connect.service;

import org.springframework.data.domain.Page;

import com.market.connect.dto.CategoryManagerDto;

public interface CategoryManagerService {

	CategoryManagerDto save(CategoryManagerDto manageCategoryDto);

	Page<CategoryManagerDto> searchCategories(int page, int size, String sort);

}
