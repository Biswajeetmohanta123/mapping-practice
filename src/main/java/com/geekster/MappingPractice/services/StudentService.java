package com.geekster.MappingPractice.services;

import com.geekster.MappingPractice.exception.ResourceNotFoundException;
import com.geekster.MappingPractice.models.Student;
import com.geekster.MappingPractice.repo.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    public Student getStudentById(String id) {
        return studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student not found"));
    }

    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student updateStudent(String id, Student student) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Student details updated"));
        existingStudent.setName(student.getName());
        existingStudent.setAge(student.getAge());
        existingStudent.setPhoneNumber(student.getPhoneNumber());
        existingStudent.setBranch(student.getBranch());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setAddress(student.getAddress());
        return studentRepository.save(existingStudent);
    }

    public void deleteStudent(String id) {
        Student existingStudent = studentRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("not fount student with this id"));
        studentRepository.delete(existingStudent);
    }
}
