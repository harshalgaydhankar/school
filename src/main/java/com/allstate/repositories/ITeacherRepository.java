package com.allstate.repositories;


import com.allstate.entities.Teacher;
import com.allstate.enums.Genders;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ITeacherRepository extends CrudRepository<Teacher, Integer> {
    public Teacher findByName(String name);
    public List<Teacher> findByGender(Genders gender);
    public List<Teacher> findByAgeGreaterThan(int age);
}
