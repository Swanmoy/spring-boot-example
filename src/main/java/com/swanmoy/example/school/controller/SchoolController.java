package com.swanmoy.example.school.controller;

import com.swanmoy.example.school.dto.SchoolDTO;
import com.swanmoy.example.school.entity.School;
import com.swanmoy.example.school.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/school")
public class SchoolController {
    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }
    @PostMapping
    public ResponseEntity<SchoolDTO> addSchool(@RequestBody School school){
       return ResponseEntity.status(HttpStatus.CREATED).body(this.schoolService.addSchool(school));
    }

    @GetMapping("/{id}")
    public ResponseEntity<SchoolDTO> getSchool(@PathVariable("id") int id){
        return ResponseEntity.status(HttpStatus.OK).body(this.schoolService.getSchool(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSchool(@PathVariable("id") int id){
        this.schoolService.deleteSchool(id);
        return ResponseEntity.status(HttpStatus.OK).body("School Deleted Successfully");
    }
}
