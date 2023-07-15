package com.geekster.MappingPractice.controller;

import com.geekster.MappingPractice.models.Course;
import com.geekster.MappingPractice.repo.CourseRepository;
import com.geekster.MappingPractice.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/")
    public List<Course> getAllCourses() {
        return courseService.getAllCourses();
    }

    @GetMapping("/{id}")
    public Course getCourseById(@PathVariable String id) {
        return courseService.getCourseById(id);
    }

    @PostMapping("/")
    public Course createCourse(@RequestBody Course course) {
        return courseService.createCourse(course);
    }

    @PutMapping("/{id}")
    public Course updateCourse(@PathVariable String id, @RequestBody Course course) {
       return courseService.updateCourse(id,course);
    }

    @DeleteMapping("/{id}")
    public void deleteCourse(@PathVariable String id) {
        courseService.deleteCourse(id);
    }
}
