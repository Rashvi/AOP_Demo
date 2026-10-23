package com.learningcoding.aop.controller;

import com.learningcoding.aop.dto.Student;
import com.learningcoding.aop.service.StudentService;
import com.learningcoding.aop.service.StudentServiceImpl;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/student")
@AllArgsConstructor
public class StudentController {
//    This code is for Decorator Design Pattern
    StudentService stuService;
    @PostMapping
    public ResponseEntity<String> createStudent(Student student){
    stuService.createStudent(student);
    stuService.afterReturnDemo(student);
//    stuService.afterThrowing(student);
    return ResponseEntity.ok("DONE");
    }

}
