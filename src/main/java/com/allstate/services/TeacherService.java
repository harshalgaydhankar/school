package com.allstate.services;

import com.allstate.entities.Teacher;
import com.allstate.enums.Genders;
import com.allstate.repositories.ITeacherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeacherService {
    private ITeacherRepository teacherRepository;

    @Autowired
    public void setTeacherRepository(ITeacherRepository teacherRepository) {
        this.teacherRepository = teacherRepository;
    }

    public Teacher create(String name, Genders gender, int age){
        Teacher t = new Teacher(name,age,gender);
        return this.teacherRepository.save(t);
    }

    public Teacher findById(int id){
        return this.teacherRepository.findOne(id);
    }


}
