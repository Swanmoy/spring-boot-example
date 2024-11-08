package com.swanmoy.example.student.dto;


import jakarta.persistence.UniqueConstraint;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class StudentRequestDTO {
    @NotEmpty(message = "Name should not be empty")
    private String name;
    @NotEmpty(message ="Address should not be empty" )
    private String address;
    private String email;
    private int schoolId;
}
