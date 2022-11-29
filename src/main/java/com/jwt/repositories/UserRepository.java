package com.jwt.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Serializable>{

	User findByUserName(String userName);

}
