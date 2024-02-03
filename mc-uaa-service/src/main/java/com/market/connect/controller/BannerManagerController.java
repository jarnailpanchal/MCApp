package com.market.connect.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
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
	
	@Value("${upload.path}")
	private String uploadPath;

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
	public Response<Boolean> saveTemplate(@RequestParam("companyId") Long companyId, @RequestParam("file") MultipartFile file) {
		Response<Boolean> finalResponse = null;
		try {
			bannerManagerService.saveBanner(companyId, file);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, true);
		} catch (Exception e) {
			finalResponse = ResponseBuilder.createResponse(false, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
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
	
	@PostMapping(value = "/photo", produces = MediaType.IMAGE_JPEG_VALUE)
    public ResponseEntity<byte[]> getPhotoByUrl(@RequestParam("photoName") String photoPath) {
    	try {
            File file = new File(uploadPath + photoPath);
            if (!file.exists()) {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
            Resource resource = new FileSystemResource(file);
            byte[] photoBytes = Files.readAllBytes(resource.getFile().toPath());
            return ResponseEntity.ok().contentType(MediaType.IMAGE_JPEG).body(photoBytes);
        } catch (IOException e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
