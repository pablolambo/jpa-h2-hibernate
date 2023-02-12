package com.example.demoRESTweb.entity;

import javax.persistence.*;
import java.util.List;
@Entity
@Table(name = "STUDENT")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    @OneToMany(mappedBy = "student", cascade = CascadeType.ALL)
    private List<Address> address;

    public Student(long id, String name, List<Address> address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public Student() {}

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public List<Address> getAddress() {
        return address;
    }

    public Student getStudent() {
        return Student.this;
    }
}
