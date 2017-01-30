package com.allstate.entities;

import com.allstate.enums.Genders;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "teachers")
public class Teacher {

    private int id;
    private String name;
    private int age;
    private Genders gender;
    private Date created;
    private Date modified;
    private int version;
    private List<Klass> klasses;

    public Teacher() {
    }

    public Teacher(String name, int age, Genders gender) {
        this.name = name;
        this.age = age;
        this.gender = gender;
    }

    @Id
    @GeneratedValue
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Version
    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    @NotNull
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NotNull
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Column(columnDefinition = "ENUM('Male', 'Female', 'Other')")
    @Enumerated(EnumType.STRING)
    @NotNull
    public Genders getGender() {
        return gender;
    }

    public void setGender(Genders gender) {
        this.gender = gender;
    }

    @CreationTimestamp
    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }
    @UpdateTimestamp
    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    @OneToMany(mappedBy = "teacher")
    @JsonIgnore
    public List<Klass> getKlasses() {
        return klasses;
    }
    public void setKlasses(List<Klass> klasses) {
        this.klasses = klasses;
    }
}
