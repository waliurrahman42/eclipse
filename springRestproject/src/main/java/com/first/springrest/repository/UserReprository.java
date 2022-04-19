package com.first.springrest.repository;


import org.springframework.data.repository.CrudRepository;

import com.first.springrest.model.User;

public interface UserReprository extends CrudRepository<User, Long>{
	
	
}
