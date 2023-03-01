package edu.sabanciuniv.homework4.service;

import edu.sabanciuniv.homework4.model.Faculty;
import edu.sabanciuniv.homework4.model.Student;
import edu.sabanciuniv.homework4.repository.FacultyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FacultyService {

    private final FacultyRepository facultyRepository;

    public List<Student> findFacultiesStudent(int id) {
        Faculty faculty = facultyRepository.findFacultiesStudents(id);
        return faculty.getStudentListOfFaculty();
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public List<Faculty> findAllFaculties() {
        return facultyRepository.findAll();
    }
}
