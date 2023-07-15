package com.geekster.MappingPractice.repo;

import com.geekster.MappingPractice.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepository extends JpaRepository<Student, String> {
}
