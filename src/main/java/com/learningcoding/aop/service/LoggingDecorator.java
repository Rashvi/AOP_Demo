package com.learningcoding.aop.service;

import com.learningcoding.aop.dto.Student;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class LoggingDecorator implements StudentService{
    private StudentServiceImpl studentService;
    public LoggingDecorator(StudentServiceImpl studentService) {
        this.studentService = studentService;
    }
    @Override
    public Student createStudent(Student student) {
        // logging logic goes here
        studentService.createStudent(student);
        return student;
    }

    @Override
    public String afterReturnDemo(Student student) {
        studentService.afterReturnDemo(student);
        return "afterReturnDemoValue";
    }
    @Override
    public String afterThrowing(Student student) {
        studentService.afterThrowing(student);
//        throw new RuntimeException("runtime Exception is thrown from afterReturnThrowing method");
        return "logAfterReturnThrowing in side Logging Decorator";
    }
}
