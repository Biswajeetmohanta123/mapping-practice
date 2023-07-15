package com.geekster.MappingPractice.repo;

import com.geekster.MappingPractice.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseRepository extends JpaRepository<Course, String> {
}
