package com.market.connect.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.web.multipart.MultipartFile;

import com.market.connect.dto.BannerManagerDto;

public interface BannerManagerService {

	BannerManagerDto save(BannerManagerDto bannerManagerDto);

	Page<BannerManagerDto> searchBanners(int page, int size, String sort);

	String saveBanner(Long userId,String type, MultipartFile file);

	List<String> getTemplatesUrl(Long userId, String type);

}
