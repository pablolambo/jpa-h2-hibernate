package com.example.demoRESTweb.controller;

import com.example.demoRESTweb.entity.Address;
import com.example.demoRESTweb.entity.Student;
import com.example.demoRESTweb.service.StudentService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/getStudentList")
    public ResponseEntity<List<Student>> getAllStudents() {
        List<Student> studentList = studentService.getAllStudents();
        return new ResponseEntity<>(studentList, HttpStatus.OK);
    }

    @GetMapping("/getStudentById/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long studentId) {
        Student student = studentService.getStudentById(studentId);
        return new ResponseEntity<>(student, HttpStatus.OK);
    }

    @PostMapping("/addStudent/{studentId}")
    public ResponseEntity<Student> addStudent(@PathVariable Long studentId, @RequestBody Address address) {
        Student student = studentService.getStudentById(studentId);
        address.setStudent(student.getId());
        Address newAdress = studentService.addAddressToStudent(studentId, address);
        URI path = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newAdress.getId())
                .toUri();
        return ResponseEntity.created(path).build();
    }

}
