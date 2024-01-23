package com.market.connect.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.market.connect.entity.CommentManager;

public interface CommentManagerRepository extends JpaRepository<CommentManager, Long> {

}
