package edu.sabanciuniv.homework4.controller;

import edu.sabanciuniv.homework4.model.Student;
import edu.sabanciuniv.homework4.model.dto.StudentRequest;
import edu.sabanciuniv.homework4.model.dto.StudentResponse;
import edu.sabanciuniv.homework4.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping("/student")
    public List<Student> getAllStudents(){
        return studentService.findAllStudents();
    }

    @PostMapping("/student")
    public StudentResponse saveNewStudent(@RequestBody StudentRequest studentRequest){

        return studentService.saveStudent(studentRequest);
    }

    @GetMapping("/student/{id}")
    public Optional<Student> findStudentwithId(@PathVariable Integer id){
        return studentService.findStudentById(id);
    }

    @PutMapping("/student")
    public Student updateStudent(@RequestBody Student student){

        return studentService.updateStudent(student);
    }

    @DeleteMapping("/student/{id}")
    public void deleteStudent(@PathVariable int id){
        studentService.deleteStudent(id);
    }
}
