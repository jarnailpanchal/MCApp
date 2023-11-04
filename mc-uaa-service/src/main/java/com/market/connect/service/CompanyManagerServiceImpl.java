package com.market.connect.service;

import java.time.Instant;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.CompanyManagerDto;
import com.market.connect.entity.CompanyManager;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.CompanyManagerRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CompanyManagerServiceImpl implements CompanyManagerService {

	@Autowired
	private CompanyManagerRepository companyManagerRepository;	
	
	@Override
	public CompanyManagerDto save(CompanyManagerDto companyManagerDto) {
		
			companyManagerDto.setCreatedBy(MarketConnectConstant.ADMIN);
			companyManagerDto.setCreatedDate(Instant.now());
			companyManagerDto.setStatus(Short.valueOf("1"));
		CompanyManager categoryManagerEntity = MCMapper.INSTANCE
				.toCompanyManager(companyManagerDto);
		log.info("save company exectuted successfully 👽 ");
		return MCMapper.INSTANCE.toCompanyManagerDto(companyManagerRepository.save(categoryManagerEntity));
	}

	@Override
	public Page<CompanyManagerDto> searchCompanies(int page, int size, String sort) {
		Pageable pageable = null;
	    if (sort != null) {
	      // with sorting
	      pageable = PageRequest.of(page, size, Sort.Direction.ASC, sort);
	    } else {
	      // without sorting
	      pageable = PageRequest.of(page, size);
	    }
	    return companyManagerRepository.findAll(pageable).map(MCMapper.INSTANCE::toCompanyManagerDto);
	}
	
}
