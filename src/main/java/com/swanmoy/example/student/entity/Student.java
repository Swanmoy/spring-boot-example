package com.swanmoy.example.student.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.swanmoy.example.school.entity.School;
import com.swanmoy.example.student.dto.StudentDTO;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    private String address;
    private String email;
    @ManyToOne()
    @JoinColumn(name = "school_id")
    @JsonBackReference
    private School school;

    public StudentDTO toStudentDTO(){
        StudentDTO s=new StudentDTO();
        s.setId(this.id);
        s.setName(this.name);
        s.setAddress(this.address);
        s.setEmail(this.email);
        s.setSchoolName(this.school.getName());
        return s;
    }
}
