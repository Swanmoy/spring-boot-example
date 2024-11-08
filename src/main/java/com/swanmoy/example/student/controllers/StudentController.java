package com.swanmoy.example.student.controllers;

import com.swanmoy.example.student.dto.StudentDTO;
import com.swanmoy.example.student.dto.StudentRequestDTO;
import com.swanmoy.example.student.entity.Student;
import com.swanmoy.example.student.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<StudentDTO> addStudent(@Valid @RequestBody StudentRequestDTO s) {
        return ResponseEntity.status(HttpStatus.CREATED).body(this.studentService.addStudent(s));
    }

    @GetMapping
    public ResponseEntity<List<StudentDTO>> getAllStudents(){
        return ResponseEntity.status(HttpStatus.FOUND).body(this.studentService.getAllStudents());
    }

    @GetMapping("/{id}")
    public ResponseEntity<StudentDTO> getStudent(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.FOUND).body(this.studentService.getStudent(id));
    }
}
