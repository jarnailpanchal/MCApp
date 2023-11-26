package com.market.connect.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.connect.dto.RoleDto;
import com.market.connect.entity.Role;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.RoleRepository;

import ch.qos.logback.core.boolex.EvaluationException;
import lombok.extern.log4j.Log4j2;

@Log4j2
@Service
public class RoleServiceImpl implements RoleService {
	
	@Autowired
	RoleRepository roleRepository;
	
	@Transactional
	@Override
	public RoleDto save(RoleDto roleDto) throws EvaluationException {
		List<Role> existRole = roleRepository.findByRoleName(roleDto.getRoleName());
		if(existRole.size()>0) {
			throw new EvaluationException("this role already exist");
		} else {
			Role role = MCMapper.INSTANCE.toRole(roleDto);
			return MCMapper.INSTANCE.toRoleDto(roleRepository.save(role));
		}
	}

	@Transactional
	@Override
	public Page<RoleDto> searchRoles(int page, int size, String sort) {
		Pageable pageable = null;
	    if (sort != null) {
	      // with sorting
	      pageable = PageRequest.of(page, size, Sort.Direction.ASC, sort);
	    } else {
	      // without sorting
	      pageable = PageRequest.of(page, size);
	    }
	    return roleRepository.findAll(pageable).map(MCMapper.INSTANCE::toRoleDto);
	}

}
