package com.oit.springBootMysqlDocker.repo;

import com.oit.springBootMysqlDocker.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student, Integer> {
}
