package model;

public class PermanentInstructor extends Instructor{

    private int PermanentInstructorsFixedSalary;



    //Constructors
    public PermanentInstructor(String instructorName, String instructorAddress, String instructorPhoneNumber,
                               Course instructorMainCourse, int permanentInstructorsFixedSalary) {
        super(instructorName, instructorAddress, instructorPhoneNumber);
        PermanentInstructorsFixedSalary = permanentInstructorsFixedSalary;
    }

    public PermanentInstructor() {
    }

    public int getPermanentInstructorsFixedSalary() {
        return PermanentInstructorsFixedSalary;
    }

    public void setPermanentInstructorsFixedSalary(int permanentInstructorsFixedSalary) {
        PermanentInstructorsFixedSalary = permanentInstructorsFixedSalary;
    }
}
