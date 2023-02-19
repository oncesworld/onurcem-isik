package controller;

import model.Course;
import utility.CourseService;

import java.util.List;

public class CourseController {

    CourseService courseService = new CourseService();

    public List<Course> findAllCourses(){

        return courseService.findAll();
    }

    public Course findCourseById(int id){

        return courseService.find(id);
    }

    public void saveCourse(Course course){

        courseService.save(course);
    }

}
