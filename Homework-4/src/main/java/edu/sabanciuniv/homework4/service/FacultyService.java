package edu.sabanciuniv.homework4.service;

import edu.sabanciuniv.homework4.exceptions.FacultyNotFoundException;
import edu.sabanciuniv.homework4.model.Faculty;
import edu.sabanciuniv.homework4.model.Student;
import edu.sabanciuniv.homework4.model.dto.StudentDto;
import edu.sabanciuniv.homework4.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public List<Student> findFacultiesStudent(int id) {
        Faculty faculty = facultyRepository.findFacultiesStudents(id);

        if(faculty == null){
            throw new FacultyNotFoundException("There is no such Faculty with " + id + " id");
        }
        return faculty.getStudentListOfFaculty();
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Faculty> findAllFaculties() {
        return facultyRepository.findAll();
    }

    public List<StudentDto> findFacultiesStudentWithDto(int id) {
        Faculty faculty = facultyRepository.findFacultiesStudents(id);
        List<StudentDto> studentDtoList = new ArrayList<>();
        for(Student student : faculty.getStudentListOfFaculty()){
            StudentDto studentDto = StudentDto.builder()
                    .studentFirstName(student.getStudentFirstName())
                    .studentLastName(student.getStudentLastName())
                    .build();

            studentDtoList.add(studentDto);
        }
        return studentDtoList;

    }


}
