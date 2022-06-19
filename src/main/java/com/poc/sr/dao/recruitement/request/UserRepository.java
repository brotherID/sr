package com.poc.sr.dao.recruitement.request;

import org.springframework.data.jpa.repository.JpaRepository;

import com.poc.sr.entities.User;

public interface UserRepository extends JpaRepository<User, String>{

}
