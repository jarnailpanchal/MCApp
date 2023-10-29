package com.market.connect.service;

import org.springframework.data.domain.Page;

import com.market.connect.dto.BannerManagerDto;

public interface BannerManagerService {

	BannerManagerDto save(BannerManagerDto bannerManagerDto);

	Page<BannerManagerDto> searchBanners(int page, int size, String sort);

}
