package com.oit;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface EmpRepo extends JpaRepository<Employee, Integer> {

}
