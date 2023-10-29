package com.market.connect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.market.connect.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{

	List<Role> findByRoleName(String roleName);

}
