package com.market.connect.service;

import javax.validation.Valid;

import org.springframework.data.domain.Page;

import com.market.connect.dto.CompanyManagerDto;

public interface CompanyManagerService {

	CompanyManagerDto save(@Valid CompanyManagerDto companyManagerDto);

	Page<CompanyManagerDto> searchCompanies(int page, int size, String sort);

}
