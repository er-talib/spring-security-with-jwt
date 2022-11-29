package com.jwt.repositories;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jwt.entities.Vehical;

@Repository
public interface VehicalRepository extends JpaRepository<Vehical, Serializable>{

}
