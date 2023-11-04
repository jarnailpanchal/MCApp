package com.market.connect.mapper;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageableRequest {

	private int page;
    private  int size;
    private List<String> sort;
}
