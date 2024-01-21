package com.market.connect.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.market.connect.dto.CompanyCustomDetailFinalDto;
import com.market.connect.dto.CompanyManagerDto;
import com.market.connect.dto.CompanyWithCategoryCustomDto;

public interface CompanyManagerService {

	CompanyManagerDto save(@Valid CompanyManagerDto companyManagerDto);

	Page<CompanyManagerDto> searchCompanies(int page, int size, String sort);

	List<CompanyWithCategoryCustomDto> getAllCompanyByCategoryId(Long categoryId, double targetLatitude, double targetLongitude,
			double distanceKm);

	CompanyCustomDetailFinalDto getCompanyDetailById(Long companyId);

}
