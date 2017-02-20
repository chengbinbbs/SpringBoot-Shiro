package com.daysluck.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.daysluck.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{

	/**通过username查找用户信息;*/
	User findByUsername(String username);
}
