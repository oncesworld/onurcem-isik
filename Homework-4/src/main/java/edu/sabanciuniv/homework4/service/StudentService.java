package edu.sabanciuniv.homework4.service;


import edu.sabanciuniv.homework4.model.Student;
import edu.sabanciuniv.homework4.model.dto.StudentDto;
import edu.sabanciuniv.homework4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public Student saveStudent(Student student){

        return studentRepository.save(student);
    }

    public List<Student> findAllStudents(){

        return studentRepository.findAll();
    }

    public Optional<Student> findStudentById(Integer id){

        return studentRepository.findById(id);
    }

    public Student updateStudent(Student student){
        if (student.getId() == 0){
            throw new IllegalArgumentException("There is no student with this ID");
        }
        return studentRepository.save(student);
    }

    public void deleteStudent(Student student){
        studentRepository.delete(student);
    }

}
