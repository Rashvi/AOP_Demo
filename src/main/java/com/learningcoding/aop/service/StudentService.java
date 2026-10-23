package com.learningcoding.aop.service;

import com.learningcoding.aop.dto.Student;

public interface StudentService {
    Student createStudent(Student student);
    String afterReturnDemo(Student student);
    String afterThrowing(Student student);
}
