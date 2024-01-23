package com.market.connect.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.market.connect.constant.MarketConnectConstant;
import com.market.connect.dto.CommentManagerDto;
import com.market.connect.dto.LikeCommentManagerDto;
import com.market.connect.dto.Response;
import com.market.connect.service.CommentManagerService;
import com.market.connect.util.ResponseBuilder;

@RestController
@RequestMapping(value = "/comment")
public class CommentManagerController {

	@Autowired
	private CommentManagerService commentManagerService;
	
	@PostMapping("/save")
	public Response<CommentManagerDto> saveCompany(@Valid @RequestBody CommentManagerDto commentManagerDto) {
		Response<CommentManagerDto> finalResponse = null;
		CommentManagerDto response = null;
		try {
			response = commentManagerService.save(commentManagerDto);
			finalResponse = ResponseBuilder.createResponse(true, MarketConnectConstant.StatusCode.SUCCESS_CODE,
					MarketConnectConstant.SUCCESS, response);
		} catch(Exception e) {
			finalResponse = ResponseBuilder.createResponse(false, MarketConnectConstant.StatusCode.RESPONSE_FAIL,
					e.getMessage(), response);
		}
		return finalResponse;
	}
	
	@PostMapping("/like/dislike")
	public Response<CommentManagerDto> likeDislikeComment(@RequestBody LikeCommentManagerDto likeCommentManagerDto) {
		Response<CommentManagerDto> finalResponse = null;
		CommentManagerDto response = null;
		return finalResponse;
	}
}
