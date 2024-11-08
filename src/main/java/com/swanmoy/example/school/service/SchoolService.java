package com.swanmoy.example.school.service;

import com.swanmoy.example.school.dto.SchoolDTO;
import com.swanmoy.example.school.entity.School;

public interface SchoolService {
    public SchoolDTO addSchool(School s);
    public SchoolDTO getSchool(int id);
    public void deleteSchool(int id);
}
