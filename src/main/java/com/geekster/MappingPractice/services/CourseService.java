package com.geekster.MappingPractice.services;

import com.geekster.MappingPractice.exception.ResourceNotFoundException;
import com.geekster.MappingPractice.models.Course;
import com.geekster.MappingPractice.repo.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseService {
    @Autowired
    private CourseRepository courseRepository;

    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    public Course getCourseById(String id) {
        return courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not found"));
    }

    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    public Course updateCourse(String id, Course course) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not exist"));
        existingCourse.setTitle(course.getTitle());
        existingCourse.setDescription(course.getDescription());
        existingCourse.setDuration(course.getDuration());
        existingCourse.setStudentList(course.getStudentList());
        return courseRepository.save(existingCourse);
    }

    public void deleteCourse(String id) {
        Course existingCourse = courseRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Course not exist"));
        courseRepository.delete(existingCourse);
    }
}

