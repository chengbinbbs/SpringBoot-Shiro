package com.daysluck.service;

import com.daysluck.domain.User;

public interface UserService {

	User findByUsername(String username);
}
