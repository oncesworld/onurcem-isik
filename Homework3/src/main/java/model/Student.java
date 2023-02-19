package model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentName;
    private LocalDate studentBirthDate;
    private String studentAddress;
    private String gender;

    @ManyToMany
    private List<Course> studentCourseList = new ArrayList<>();

    //Constructor

    public Student(String studentName, LocalDate studentBirthDate, String studentAddress, String gender) {
        this.studentName = studentName;
        this.studentBirthDate = studentBirthDate;
        this.studentAddress = studentAddress;
        this.gender = gender;
    }

    public Student() {
    }

    //Getter and Setters

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public LocalDate getStudentBirthDate() {
        return studentBirthDate;
    }

    public void setStudentBirthDate(LocalDate studentBirthDate) {
        this.studentBirthDate = studentBirthDate;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public List<Course> getStudentCourseList() {
        return studentCourseList;
    }

    public void setStudentCourseList(List<Course> studentCourseList) {
        this.studentCourseList = studentCourseList;
    }
}
