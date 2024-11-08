package com.swanmoy.example.school.dto;

import com.swanmoy.example.student.entity.Student;
import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class SchoolDTO {

    private int id;

    private String name;

    private List<Student> students;
}
