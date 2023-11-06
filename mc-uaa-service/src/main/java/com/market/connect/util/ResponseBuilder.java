package com.market.connect.util;

import com.market.connect.dto.Response;

public class ResponseBuilder {
	
	private ResponseBuilder()
	{
		
	}
	
	public static <T> Response<T> createResponse(boolean status,String statusCode,String message,T objectResponse)
	{
		return new Response<>(status,statusCode,message,objectResponse);
	}

}
