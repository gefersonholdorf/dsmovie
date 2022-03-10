package com.gefersonholdorf.dsmovie.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gefersonholdorf.dsmovie.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	User findByEmail (String email);
}
