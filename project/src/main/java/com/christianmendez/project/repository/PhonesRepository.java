package com.christianmendez.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.christianmendez.project.entity.Phones;

@Repository
public interface PhonesRepository extends JpaRepository<Phones,String> {

}
