package com.example.StudentmanagementSystem.controller;

import com.example.StudentmanagementSystem.model.Student;
import com.example.StudentmanagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/students")
@CrossOrigin(origins = "*")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    public ResponseEntity<Student> saveStudent(@RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
    }

    // GetAll Rest API
    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    // Get by Id Rest API
    @GetMapping("{id}")
    // localhost:8080/api/students/1
    public ResponseEntity<Student> getStudentById(@PathVariable("id") long studentID) {
        return new ResponseEntity<Student>(studentService.getStudentById(studentID), HttpStatus.OK);
    }

    // Update Rest API
    @PutMapping("{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable("id") long id, @RequestBody Student student) {
        return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
    }

    // Delete Rest API
    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable("id") long id) {
        // delete student from db
        studentService.deleteStudent(id);
        return new ResponseEntity<String>("Student deleted successfully.", HttpStatus.OK);
    }
}
