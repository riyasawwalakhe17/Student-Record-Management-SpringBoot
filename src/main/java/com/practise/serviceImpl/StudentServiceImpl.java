package com.practise.serviceImpl;

import com.practise.entity.Student;
import com.practise.repository.StudentRepository;
import com.practise.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public String saveStudent(Student student) {
        Student saveStudent = studentRepository.save(student);
        return "Student Data Saved Successfully";
    }

    @Override
    public List<Student> getAllStudents() {
     List<Student> studentList = studentRepository.findAll();
     return studentList;
    }

    @Override
    public Student getStudentById(int id) {
Student student = studentRepository.findById(id)
        .orElseThrow(()-> new NullPointerException("Student with id does not found"+id));
        return student;
    }

    @Override
    public String deleteStudentById(int id) {
        studentRepository.deleteById(id);
        return "Student deleted successfully";
    }

    @Override
    public Student upadateStudent(int id, Student newStudent) {
        Student student = studentRepository.findById(id).orElseThrow(()->new NullPointerException("Updated Developer in db does not found with id "+id));
        System.err.println("Old Student from db"+student);
        System.err.println("Student object with value to be updated"+newStudent);

        student.setName(newStudent.getName());
        student.setEmail(newStudent.getEmail());
        student.setCourse(newStudent.getCourse());
        student.setMarks(newStudent.getMarks());

        Student updateStudent = studentRepository.save(student);
        System.err.println("Student with updated value"+updateStudent);
        return updateStudent;
    }

    @Override
    public List<Student> saveListOfStudent(List<Student> studentList) {
        studentRepository.saveAll(studentList);
        return studentList;
    }
}
