package com.example.StudentmanagementSystem.service.impl;

import com.example.StudentmanagementSystem.model.Student;
import com.example.StudentmanagementSystem.repository.StudentRepository;
import com.example.StudentmanagementSystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;
    // save student in database
    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }
    // get all students from database
    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }
    // get student using id
    @Override
    public Student getStudentById(long id) {
        Optional<Student> student = studentRepository.findById(id);
        if (student.isPresent()) {
            return student.get();
        } else {
            throw new RuntimeException();
        }
    }
    // update student
    @Override
    public Student updateStudent(Student student, long id) {
        Student existingStudent = studentRepository.findById(id).orElseThrow(
                () -> new RuntimeException()
        );
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());
        existingStudent.setDepartment(student.getDepartment());
        existingStudent.setYearOfEnrollment(student.getYearOfEnrollment());
// save

        // save
        studentRepository.save(existingStudent);
        return existingStudent;
    }
    // delete student
    @Override
    public void deleteStudent(long id) {
        // check
        studentRepository.findById(id).orElseThrow(() -> new RuntimeException());
        // delete
        studentRepository.deleteById(id);
    }
}

