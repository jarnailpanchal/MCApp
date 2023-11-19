package com.market.connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.connect.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{

	List<User> findByPhoneNumber(String phoneNumber);

	List<User> findAllByCategoryId(Long categoryId);

}
