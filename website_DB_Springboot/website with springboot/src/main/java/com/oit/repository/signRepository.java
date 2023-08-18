package com.oit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oit.entity.signup;
@Repository
public interface signRepository extends JpaRepository<signup, Integer>{

}
