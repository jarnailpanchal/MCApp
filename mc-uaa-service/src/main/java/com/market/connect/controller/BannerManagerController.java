package com.market.connect.controller;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.BannerManagerDto;
import com.market.connect.dto.Response;
import com.market.connect.service.BannerManagerService;
import com.market.connect.util.ResponseBuilder;

import lombok.extern.log4j.Log4j2;

@Log4j2
@RestController
@RequestMapping(value = "/banner")
public class BannerManagerController {

	@Autowired
	private BannerManagerService bannerManagerService;

	// to save the category
	@PostMapping("/save")
	public BannerManagerDto saveCategory(@Valid @RequestBody BannerManagerDto bannerManagerDto) {
		return bannerManagerService.save(bannerManagerDto);
	}

	@PostMapping(path = "/getAll")
	public Response<Page<BannerManagerDto>> getAllCategory(@RequestParam("page") int page, @RequestParam("size") int size,
			@RequestParam("sort") String sort) {
		Response<Page<BannerManagerDto>> finalResponse = null;
		Page<BannerManagerDto> response = null;
		try {
			response = bannerManagerService.searchBanners(page, size, sort);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
			} catch (Exception e) {
				finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
						e.getMessage(), response);
			}
		return finalResponse;
	}
	
	@PostMapping("/file")
	public Response<Boolean> saveTemplate(@RequestParam("userId") Long userId, @RequestParam("type") String type, @RequestParam("file") MultipartFile file) {
		Response<Boolean> finalResponse = null;
		try {
			bannerManagerService.saveBanner(userId, type, file);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, true);
		} catch (Exception e) {
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), false);
		}
		return finalResponse;
	}
	
	@PostMapping("/get/template/urls")
	public Response<List<String>> getTemplatesUrl(@RequestParam("userId") Long userId,@RequestParam("type") String type) {
		Response<List<String>> finalResponse = null;
		List<String> urls = new ArrayList<>();
		try {
			urls = bannerManagerService.getTemplatesUrl(userId, type);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, urls);
			log.info("inside try ");
		} catch (Exception e) {
			log.info("inside catch");
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), urls);
		}
		return finalResponse;
	}
}
