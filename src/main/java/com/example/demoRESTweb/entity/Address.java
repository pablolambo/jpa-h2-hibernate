package com.example.demoRESTweb.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")

public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String street;
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    public void setStudent(Long id) {
        this.id = id;
    }

    public Long getId() {
        return student.getId();
    }
}
