package com.market.connect.service;

import java.util.Date;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.market.connect.dto.CommentManagerDto;
import com.market.connect.entity.CommentManager;
import com.market.connect.mapper.MCMapper;
import com.market.connect.repository.CommentManagerRepository;

@Service
public class CommentManagerServiceImpl implements CommentManagerService {

	@Autowired
	private CommentManagerRepository commentManagerRepository;
	
	@Transactional
	@Override
	public CommentManagerDto save(CommentManagerDto commentManagerDto) {
		CommentManager commentManager = MCMapper.INSTANCE.toCommentManager(commentManagerDto);
		Date date = new Date();
		commentManager.setCommentDate(date);
		CommentManager comment = commentManagerRepository.save(commentManager);
		return MCMapper.INSTANCE.toCommentManagerDto(comment);
	}

}
