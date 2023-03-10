package edu.sabanciuniv.homework4.controller;

import edu.sabanciuniv.homework4.model.Faculty;
import edu.sabanciuniv.homework4.model.Student;
import edu.sabanciuniv.homework4.service.FacultyService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class FacultyController {

    private final FacultyService facultyService;

    @GetMapping("/faculty/{id}")
    public List<Student> findFacultiesStudent(@PathVariable int id){
        return facultyService.findFacultiesStudent(id);
    }

    @PostMapping("/faculty")
    public Faculty addFaculty(@RequestBody Faculty faculty){
        return facultyService.addFaculty(faculty);
    }

    @GetMapping("/faculty")
    public List<Faculty> findAllFaculties(){
        return facultyService.findAllFaculties();
    }

}
