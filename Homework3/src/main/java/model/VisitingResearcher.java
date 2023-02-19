package model;

public class VisitingResearcher extends Instructor{

    private int dailyWorkingHour;



    //Constructors
    public VisitingResearcher(String instructorName, String instructorAddress, String instructorPhoneNumber,
                              Course instructorMainCourse, int dailyWorkingHour) {
        super(instructorName, instructorAddress, instructorPhoneNumber);
        this.dailyWorkingHour = dailyWorkingHour;
    }

    public VisitingResearcher() {
    }

    //Getter and Setters

    public int getDailyWorkingHour() {
        return dailyWorkingHour;
    }

    public void setDailyWorkingHour(int dailyWorkingHour) {
        this.dailyWorkingHour = dailyWorkingHour;
    }
}
