package com.swanmoy.example.school.exceptions;

public class SchoolWithIdDoesNotExistException extends RuntimeException{
    public SchoolWithIdDoesNotExistException(String message){
        super(message);
    }
}
