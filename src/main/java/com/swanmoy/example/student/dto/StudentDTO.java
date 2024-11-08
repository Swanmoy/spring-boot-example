package com.swanmoy.example.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class StudentDTO {
    private int id;
    private String name;
    private String address;
    private String email;
    private String schoolName;
}
