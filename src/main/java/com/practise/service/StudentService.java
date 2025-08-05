package com.practise.service;

import com.practise.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;


public interface StudentService {

    String saveStudent(Student student);

    List<Student> getAllStudents();

    Student getStudentById(int id);

    String deleteStudentById(int id);

    Student upadateStudent(int id, Student newStudent);

    List<Student> saveListOfStudent(List<Student> studentList);
}
