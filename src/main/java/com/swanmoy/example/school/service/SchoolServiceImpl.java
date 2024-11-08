package com.swanmoy.example.school.service;

import com.swanmoy.example.school.dto.SchoolDTO;
import com.swanmoy.example.school.entity.School;
import com.swanmoy.example.school.exceptions.SchoolWithIdDoesNotExistException;
import com.swanmoy.example.school.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SchoolServiceImpl implements SchoolService{
    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolServiceImpl(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public SchoolDTO addSchool(School s){
        return this.schoolRepository.save(s).toSchoolDTO();
    }

    public SchoolDTO getSchool(int id){
        Optional<School> s=this.schoolRepository.findById(id);
        if(s.isPresent()){
            return s.get().toSchoolDTO();
        }else{
            throw new SchoolWithIdDoesNotExistException("No School found with this Id");
        }
    }

    public void deleteSchool(int id){
        this.schoolRepository.deleteById(id);
    }
}
