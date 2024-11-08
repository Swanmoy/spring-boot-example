package com.swanmoy.example.student.exceptions;

public class StudentWithEmailAlreadyExists extends RuntimeException{
    public StudentWithEmailAlreadyExists(String message){
        super(message);
    }
}
