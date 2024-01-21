package com.market.connect.service;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.market.connect.dto.BannerManagerDto;
import com.market.connect.entity.BannerManager;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.BannerManagerRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class BannerManagerServiceImpl implements BannerManagerService {

	@Value("${upload.path}")
	private String uploadPath;

	@Autowired
	private BannerManagerRepository bannerManagerRepository;

	@Transactional
	@Override
	public BannerManagerDto saveBanner(Long companyId, MultipartFile file) {
		String status = "";
		BannerManagerDto savedBanner = new BannerManagerDto();
		try {
			InputStream inputStream = file.getInputStream();
			OutputStream outputStream = new FileOutputStream(uploadPath + companyId + "_" + file.getOriginalFilename());
			IOUtils.copy(inputStream, outputStream);
			BannerManagerDto bannerManagerDto = new BannerManagerDto();
			bannerManagerDto.setBannerUrl(uploadPath + companyId + "_" + file.getOriginalFilename());
			bannerManagerDto.setCompanyId(companyId);
			bannerManagerDto.setVerificationStatus("Done");
			//bannerManagerDto.setType(type);
			savedBanner = save(bannerManagerDto);
			status = "Saved";
		} catch (IOException e) {
			status = "Not Saved";
			e.printStackTrace();
		}
		return savedBanner;
	}

	@Transactional
	@Override
	public BannerManagerDto save(BannerManagerDto bannerManagerDto) {
		BannerManager bannerManager = MCMapper.INSTANCE.toBannerManager(bannerManagerDto);
		bannerManager.setCreatedBy("Admin");
		bannerManager.setCreatedDate(Instant.now());
		bannerManager.setStatus(Short.valueOf("1"));
		log.info("save banner manager funcation start here");
		return MCMapper.INSTANCE.toBannerManagerDto(bannerManagerRepository.save(bannerManager));
	}

	@Transactional
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

	@Transactional
	@Override
	public List<String> getTemplatesUrl(Long userId, String type) {
		List<String> bannersUrl = new ArrayList<>();
		try {
			/*
			 * bannersUrl = bannerManagerRepository.findByUserIdAndType(userId, type)
			 * .stream() .map(BannerManager::getBannerUrl) .collect(Collectors.toList());
			 */
		} catch (Exception e) {
			e.printStackTrace();
		}
		return bannersUrl;
	}

}
