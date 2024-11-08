package com.swanmoy.example.student.service;


import com.swanmoy.example.student.dto.StudentDTO;
import com.swanmoy.example.student.dto.StudentRequestDTO;
import com.swanmoy.example.student.entity.Student;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface StudentService {

    public StudentDTO addStudent(StudentRequestDTO s);
    public StudentDTO getStudent(int id);
    public List<StudentDTO> getAllStudents();
}
