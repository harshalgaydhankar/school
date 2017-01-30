package com.allstate.services;

import com.allstate.entities.Teacher;
import com.allstate.enums.Genders;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@Sql(value = {"/sql/seed.sql"})
public class TeacherServiceTest {

    @Autowired
    private TeacherService teacherService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    @Test
    public void shouldCreateTeacher() throws Exception {
        Teacher t = teacherService.create("Saurabh Singhania", Genders.Male, 65);
        assertEquals(3, t.getId());
        assertEquals("Saurabh Singhania", t.getName());
    }

    @Test
    public void shouldFindTeacherById() throws Exception {
        Teacher t = teacherService.findById(2);
        //assertEquals(3, t.getId());
        assertEquals("Rama Rao", t.getName());
    }


}