package edu.sabanciuniv.homework4.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Faculty {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String facultyName;

    @OneToMany(mappedBy = "faculty")
    @JsonBackReference
    private List<Student> studentListOfFaculty = new ArrayList<>();

    public Faculty(String facultyName) {
        this.facultyName = facultyName;
    }

    public Faculty() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public List<Student> getStudentListOfFaculty() {
        return studentListOfFaculty;
    }

    public void setStudentListOfFaculty(List<Student> studentListOfFaculty) {
        this.studentListOfFaculty = studentListOfFaculty;
    }
}
