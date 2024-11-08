package com.swanmoy.example.student.service;

import com.swanmoy.example.school.repository.SchoolRepository;
import com.swanmoy.example.student.dto.StudentDTO;
import com.swanmoy.example.student.dto.StudentRequestDTO;
import com.swanmoy.example.student.entity.Student;
import com.swanmoy.example.student.exceptions.StudentWithEmailAlreadyExists;
import com.swanmoy.example.student.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentServiceImpl implements StudentService{

    private final StudentRepository studentRepository;
    private final SchoolRepository schoolRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository, SchoolRepository schoolRepository) {
        this.studentRepository = studentRepository;
        this.schoolRepository = schoolRepository;
    }

    public StudentDTO addStudent(StudentRequestDTO s){
        Student student=new Student();
        student.setName(s.getName());
        student.setAddress(s.getAddress());
        student.setEmail(s.getEmail());
        student.setSchool(this.schoolRepository.findById(s.getSchoolId()).orElse(null));
        Optional<Student> checkStudent=this.studentRepository.findByEmail(student.getEmail());
        if(checkStudent.isPresent()){
            throw new StudentWithEmailAlreadyExists("Student with Email Id already Exists");
        }
        return this.studentRepository.save(student).toStudentDTO();
    }

    public StudentDTO getStudent(int id){
        return this.studentRepository.findById(id).map(Student::toStudentDTO).orElse(null);
    }
    public List<StudentDTO> getAllStudents(){
        return this.studentRepository.findAll().stream().map(Student::toStudentDTO).collect(Collectors.toList());
    }
}
