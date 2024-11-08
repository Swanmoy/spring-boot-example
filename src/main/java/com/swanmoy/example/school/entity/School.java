package com.swanmoy.example.school.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.swanmoy.example.school.dto.SchoolDTO;
import com.swanmoy.example.student.entity.Student;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class School {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    @OneToMany(mappedBy = "school", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<Student> students;

    public SchoolDTO toSchoolDTO(){
        SchoolDTO schoolDTO=new SchoolDTO();
        schoolDTO.setId(this.id);
        schoolDTO.setName(this.name);
        schoolDTO.setStudents(this.students);
        return schoolDTO;
    }
}
