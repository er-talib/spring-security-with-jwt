package com.jwt.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.entities.Driver;

@Repository
public interface DriverRepository extends JpaRepository<Driver, Serializable>{

}
