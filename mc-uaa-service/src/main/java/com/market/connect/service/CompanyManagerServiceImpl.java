package com.market.connect.service;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.CompanyCustomDetailDto;
import com.market.connect.dto.CompanyCustomDetailFinalDto;
import com.market.connect.dto.CompanyManagerDto;
import com.market.connect.dto.CompanyWithCategoryCustomDto;
import com.market.connect.entity.CompanyManager;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.CompanyManagerRepository;

import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class CompanyManagerServiceImpl implements CompanyManagerService {

	private static final double EARTH_RADIUS_KM = 6371.0;

	@Autowired
	private CompanyManagerRepository companyManagerRepository;

	@Transactional
	@Override
	public CompanyManagerDto save(CompanyManagerDto companyManagerDto) {
		log.info("save method execution started in company manager service "
				+ "👽 companyManagerDto " + companyManagerDto);
		companyManagerDto.setCreatedBy(MarketConnectConstant.ADMIN);
		companyManagerDto.setCreatedDate(Instant.now());
		companyManagerDto.setStatus(Short.valueOf("1"));
		CompanyManager categoryManagerEntity = MCMapper.INSTANCE.toCompanyManager(companyManagerDto);
		log.info("save company exectuted successfully 👽 ");
		log.info("save method execution started in company manager service "
				+ "👽 categoryManagerEntity " + categoryManagerEntity);
		return MCMapper.INSTANCE.toCompanyManagerDto(companyManagerRepository.save(categoryManagerEntity));
	}

	@Transactional
	@Override
	public Page<CompanyManagerDto> searchCompanies(int page, int size, String sort) {
		log.info("searchCompanies method execution started in service 👽 ");
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

	@Override
	public List<CompanyWithCategoryCustomDto> getAllCompanyByCategoryId(Long categoryId, double targetLatitude,
			double targetLongitude, double distanceKm) {
		log.info("getAllCompanyByCategoryId method execution started in service 👽 ");
		List<CompanyWithCategoryCustomDto> nearbyCompanies = new ArrayList<>();
		List<CompanyWithCategoryCustomDto> companies = new ArrayList<>();
		// Get the current date
		LocalDate currentDate = LocalDate.now();

		// Get the current day of the week as an enum (e.g., MONDAY, TUESDAY, etc.)
		DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();

		// Get the day number (1 for Monday, 2 for Tuesday, ..., 7 for Sunday)
		int currentDayNumber = currentDayOfWeek.getValue();
		log.info("in service 👽 currentDayOfWeek : " + currentDayOfWeek + " : currentDayNumber : " + currentDayNumber);
		if (categoryId != 0) {
			log.info("repository invocation start here for findCustomUserDetails method 👽 ");
			companies = companyManagerRepository.findCustomUserDetails(categoryId, String.valueOf(currentDayNumber));
		} else {
			companies = companyManagerRepository.findCustomUserDetails(String.valueOf(currentDayNumber));
		}
		log.info("getAllCompanyByCategoryId method execution started in service 👽 companies size is "
				+ companies.size());
		for (CompanyWithCategoryCustomDto company : companies) {
			double distance = calculateHaversineDistance(targetLatitude, targetLongitude,
					Double.parseDouble(company.getLatitude()), Double.parseDouble(company.getLongtitude()));

			if (distance <= distanceKm) {
				nearbyCompanies.add(company);
			}
		}
		return nearbyCompanies;
	}

	private static double calculateHaversineDistance(double lat1, double lon1, double lat2, double lon2) {
		log.info("calculateHaversineDistance method execution started in service 👽 ");
		double dLat = Math.toRadians(lat2 - lat1);
		double dLon = Math.toRadians(lon2 - lon1);
		double a = Math.sin(dLat / 2) * Math.sin(dLat / 2) + Math.cos(Math.toRadians(lat1))
				* Math.cos(Math.toRadians(lat2)) * Math.sin(dLon / 2) * Math.sin(dLon / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));
		return EARTH_RADIUS_KM * c;
	}

	@Override
	public CompanyCustomDetailFinalDto getCompanyDetailById(Long companyId) {
		log.info("getCompanyDetailById method execution started in service 👽 with companyId : " + companyId);
		// Get the current date
		LocalDate currentDate = LocalDate.now();
		// Get the current day of the week as an enum (e.g., MONDAY, TUESDAY, etc.)
		DayOfWeek currentDayOfWeek = currentDate.getDayOfWeek();
		// Get the day number (1 for Monday, 2 for Tuesday, ..., 7 for Sunday)
		int currentDayNumber = currentDayOfWeek.getValue();
		log.info("in service 👽 currentDayOfWeek : " + currentDayOfWeek + " : currentDayNumber : " + currentDayNumber);
		List<CompanyCustomDetailDto> companyDetailedList = companyManagerRepository.getCompanyCustomDetail(companyId,
				String.valueOf(currentDayNumber));
		log.info("companyDetailedList size in CompanyManagerServiceImpl 👽 : " + companyDetailedList.size());
		List<String> bannersList = companyDetailedList.stream().map(CompanyCustomDetailDto::getCompanyBanners)
				.collect(Collectors.toList());
		CompanyCustomDetailFinalDto companyCustomDetailDto = MCMapper.INSTANCE
				.toCompanyCustomDetailFinalDto(companyDetailedList.get(0));
		companyCustomDetailDto.setBanners(bannersList);
		log.info("getCompanyDetailById execution completed 👽 with result: " + companyCustomDetailDto);
		return companyCustomDetailDto;
	}
}
