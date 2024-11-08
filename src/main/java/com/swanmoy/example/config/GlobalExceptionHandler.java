package com.swanmoy.example.config;

import com.swanmoy.example.dto.ExceptionMessageDTO;
import com.swanmoy.example.school.exceptions.SchoolWithIdDoesNotExistException;
import com.swanmoy.example.student.exceptions.StudentWithEmailAlreadyExists;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler({StudentWithEmailAlreadyExists.class})
    public ResponseEntity<ExceptionMessageDTO> handleStudentWithEmailAlreadyExistsException(StudentWithEmailAlreadyExists exception){
       return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionMessageDTO(exception.getMessage()));

    }
    @ExceptionHandler({SchoolWithIdDoesNotExistException.class})
    public ResponseEntity<ExceptionMessageDTO> handleSchoolWithIdDoesNotExistException(SchoolWithIdDoesNotExistException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ExceptionMessageDTO(exception.getMessage()));

    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<ExceptionMessageDTO>> handleMethonArgumentNotValidException(MethodArgumentNotValidException exception){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getBindingResult().getAllErrors().stream().map(error->new ExceptionMessageDTO(error.getDefaultMessage())).collect(Collectors.toList()));
    }
}
