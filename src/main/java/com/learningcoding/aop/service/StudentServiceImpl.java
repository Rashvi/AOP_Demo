package com.learningcoding.aop.service;

import com.learningcoding.aop.dto.Student;
import com.learningcoding.aop.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {
    private final StudentRepository studentRepository;
    public Student createStudent(Student student){
        studentRepository.save(student);
        System.out.println("Student is saved successfully");
    return student;
    }
    public String afterReturnDemo(Student student){
        studentRepository.save(student);
        System.out.println("inside AfterReturnDemo method");
        return "afterReturnDemoValue";
    }

    @Override
    public String afterThrowing(Student student) {
    throw new RuntimeException("runtime Exception is thrown from afterReturnThrowing method");
//        return "logAfterThrowingDemo";
    }
}
