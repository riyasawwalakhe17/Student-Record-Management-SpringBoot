package com.practise.controller;

import com.practise.entity.Student;
import com.practise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/add")
    public ResponseEntity<String> addStudent(@RequestBody Student student){
    System.err.println(student);
    studentService.saveStudent(student);
    return new ResponseEntity<>("Student Data Saved Successfully", HttpStatus.CREATED);
        }



@GetMapping("/getAllData")
public ResponseEntity<List<Student>> getAllData(){
    List<Student> studentList = studentService.getAllStudents();
    return new ResponseEntity<>(studentList,HttpStatus.OK);
}

    @GetMapping("/getDataById/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable("id") int id){
        Student student = studentService.getStudentById(id);
        return new ResponseEntity<>(student,HttpStatus.OK);
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<String> deleteStudentById(@PathVariable("id")int id){
        studentService.deleteStudentById(id);
        return new ResponseEntity<>("Student deleted Successfully",HttpStatus.OK);
    }

    @PutMapping("/updateDataById/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id")int id, @RequestBody Student student){
        Student updateStudent = studentService.upadateStudent(id,student);
        return new ResponseEntity<>(updateStudent,HttpStatus.OK);
    }

    @PostMapping("/addListOfData")
    public ResponseEntity<List<Student>> saveListOfStudent(@RequestBody List<Student> studentList){
        studentService.saveListOfStudent(studentList);
        return new ResponseEntity<>(studentList,HttpStatus.CREATED);
    }
}
