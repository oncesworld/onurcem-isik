package controller;

import model.Student;
import utility.StudentService;

import java.util.List;

public class StudentController {

    StudentService service = new StudentService();

    public List<Student> findAllStudent(){
        return service.findAll();
    }

    public Student findStudent(int id){

        return service.find(id);
    }

    public void saveStudent(Student student){
        service.save(student);
    }



}
