package com.excel.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.excel.entity.UserDetails;

public interface UserRepo extends JpaRepository<UserDetails, Integer> {

	
}
