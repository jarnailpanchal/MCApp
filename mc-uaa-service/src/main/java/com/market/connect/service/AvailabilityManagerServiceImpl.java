package com.market.connect.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.market.connect.dto.AvailabilityManagerDto;
import com.market.connect.entity.AvailabilityManager;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.AvailabilityManagerRepository;

import lombok.extern.log4j.Log4j2;

@Service
@Log4j2
public class AvailabilityManagerServiceImpl implements AvailabilityManagerService {

	@Autowired
	private AvailabilityManagerRepository availabilityManagerRepository;

	@Transactional
	@Override
	public List<AvailabilityManagerDto> saveAvailabilityManager(List<AvailabilityManagerDto> availabilityManagerDtos) {
		log.info("saveAvailabilityManager method execution start here");
		List<AvailabilityManager> availabilityManagerSaved = new ArrayList<>();
		availabilityManagerRepository.deleteByCompanyId(availabilityManagerDtos.get(0).getCompanyId());
		availabilityManagerRepository.deleteAllById(null);
		try {
			List<AvailabilityManager> availabilityManagers = availabilityManagerDtos.stream()
					.map(MCMapper.INSTANCE::toAvailabilityManager).collect(Collectors.toList());
			availabilityManagerSaved = availabilityManagerRepository.saveAll(availabilityManagers);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return availabilityManagerSaved.stream().map(MCMapper.INSTANCE::toAvailabilityManagerDto)
				.collect(Collectors.toList());
	}
}
