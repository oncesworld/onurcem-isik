package edu.sabanciuniv.homework4.model;

import jakarta.persistence.*;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String facultyName;

    //@OneToOne(mappedBy = "faculty")
    //Student student;

}
