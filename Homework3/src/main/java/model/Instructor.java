package model;

import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Instructor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String instructorName;
    private String instructorAddress;
    private String instructorPhoneNumber;


    @OneToMany(mappedBy = "instructor")
    private List<Course> instructorsCourseList = new ArrayList<>();

    //Constructors

    public Instructor(String instructorName, String instructorAddress,
                      String instructorPhoneNumber) {
        this.instructorName = instructorName;
        this.instructorAddress = instructorAddress;
        this.instructorPhoneNumber = instructorPhoneNumber;
    }

    public Instructor() {
    }

    //Getter and Setters

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public String getInstructorAddress() {
        return instructorAddress;
    }

    public void setInstructorAddress(String instructorAddress) {
        this.instructorAddress = instructorAddress;
    }

    public String getInstructorPhoneNumber() {
        return instructorPhoneNumber;
    }

    public void setInstructorPhoneNumber(String instructorPhoneNumber) {
        this.instructorPhoneNumber = instructorPhoneNumber;
    }

    public List<Course> getInstructorsCourseList() {
        return instructorsCourseList;
    }

    public void setInstructorsCourseList(List<Course> instructorsCourseList) {
        this.instructorsCourseList = instructorsCourseList;
    }
}
