package com.christianmendez.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.christianmendez.project.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User,String>{

	User findByEmail(String email);
}
