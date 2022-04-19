package com.first.springrest.service.implement;

import org.springframework.beans.factory.annotation.Autowired;

import com.first.springrest.model.User;
import com.first.springrest.repository.UserReprository;
import com.first.springrest.service.UserService;

public class UserServiceImplement implements UserService {
	@Autowired
	UserReprository userReprository;

	@Override
	public User saveUser(UserService user) {
		// TODO Auto-generated method stub
		return null;
	}
}
