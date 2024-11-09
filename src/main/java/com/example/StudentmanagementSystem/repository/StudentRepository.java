package com.example.StudentmanagementSystem.repository;

import com.example.StudentmanagementSystem.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
public interface StudentRepository  extends JpaRepository<Student,Long>{
    //crud
}
