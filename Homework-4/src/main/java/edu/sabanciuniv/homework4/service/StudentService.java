package edu.sabanciuniv.homework4.service;


import edu.sabanciuniv.homework4.exceptions.UnauthorizedException;
import edu.sabanciuniv.homework4.model.Student;
import edu.sabanciuniv.homework4.model.dto.StudentRequest;
import edu.sabanciuniv.homework4.model.dto.StudentResponse;
import edu.sabanciuniv.homework4.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentResponse saveStudent(StudentRequest studentRequest){

        if (!studentRequest.getUpdatedBy().equals("Admin")){
            throw new UnauthorizedException(studentRequest.getUpdatedBy()
                    + " is not authorized ! check your authority");
        }

        Student studentData = Student.builder()
                .studentFirstName(studentRequest.getStudentFirstName())
                .studentLastName(studentRequest.getStudentLastName())
                .age(studentRequest.getAge())
                .build();

        studentRepository.save(studentData);

        StudentResponse studentResponse = StudentResponse.builder()
                .studentId(studentData.getId())
                .studentFirstName(studentData.getStudentFirstName())
                .studentLastName(studentData.getStudentLastName())
                .age(studentData.getAge())
                .createdAt(LocalDateTime.now())
                .build();

        return studentResponse;
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

    public void deleteStudent(int id){
        studentRepository.deleteById(id);

    }

}
