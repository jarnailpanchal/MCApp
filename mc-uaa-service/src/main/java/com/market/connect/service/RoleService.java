package com.market.connect.service;

import org.springframework.data.domain.Page;

import com.market.connect.dto.RoleDto;

import ch.qos.logback.core.boolex.EvaluationException;

public interface RoleService {

	RoleDto save(RoleDto roleDto) throws EvaluationException;

	Page<RoleDto> searchRoles(int page, int size, String sort);

}
