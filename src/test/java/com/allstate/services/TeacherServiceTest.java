package com.allstate.services;

import com.allstate.entities.Klass;
import com.allstate.entities.Teacher;
import com.allstate.enums.Genders;
import com.allstate.repositories.ITeacherRepository;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
    public void shouldCreateNewTeacher() throws Exception {
        Teacher teacher = new Teacher("alice", 22, Genders.Female);
        teacher = this.teacherService.create(teacher);
        assertEquals(4, teacher.getId());
        assertEquals("alice", teacher.getName());
        assertEquals(Genders.Female, teacher.getGender());
    }

    @Test
    public void shouldFindTeacherById() throws Exception {
        Teacher teacher = this.teacherService.findById(1);
        assertEquals(1, teacher.getId());
        assertEquals("Debabrata Das", teacher.getName());
    }

    @Test
    public void shouldFindTeacherByName() throws Exception {
        Teacher teacher = this.teacherService.findByName("Donald Trump");
        assertEquals(3, teacher.getId());
        assertEquals("Donald Trump", teacher.getName());
    }

    @Test
    public void shouldFindFemaleTeachers() throws Exception {
        List<Teacher> teachers = this.teacherService.findByGender(Genders.Female);
        assertEquals(1, teachers.size());
    }

    @Test
    public void shouldFindTeachersOlderThan50() throws Exception {
        List<Teacher> teachers = this.teacherService.findByAgeGreaterThan(50);
        assertEquals(1, teachers.size());
    }

    @Test
    public void shouldNotFindAnyTeachersOlderThan100() throws Exception {
        List<Teacher> teachers = this.teacherService.findByAgeGreaterThan(100);
        assertEquals(0, teachers.size());
    }

    @Test
    @Transactional
    public void shouldFindAllTheKlassesTaughtByTeacher() throws Exception {
        List<Klass> klasses = this.teacherService.findById(2).getKlasses();
        assertEquals(2, klasses.size());
    }

    @Test
    @Transactional
    public void shouldFindNoKlassesTaughtByTeacher() throws Exception {
        List<Klass> klasses = this.teacherService.findById(3).getKlasses();
        assertEquals(0, klasses.size());
    }


}