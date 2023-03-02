package edu.sabanciuniv.homework4.Initialize;


import edu.sabanciuniv.homework4.model.Faculty;
import edu.sabanciuniv.homework4.model.Student;
import edu.sabanciuniv.homework4.repository.FacultyRepository;
import edu.sabanciuniv.homework4.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
@RequiredArgsConstructor
public class TestDataInitializer implements CommandLineRunner{
    private final StudentRepository studentRepository;
    private final FacultyRepository facultyRepository;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        if (studentRepository.count() == 0){
            Student student1 = new Student("Naruto", "Uzumaki", 17);
            Student student2 = new Student("Sasuke", "Uchiha", 18);
            Student student3 = new Student("Kakashi", "Hatake", 32);
            Student student4 = new Student("Gaara", "Kazekage", 32);

            Faculty faculty1 = new Faculty("Konohagakure");
            Faculty faculty2 = new Faculty("Sunagakure");

            student1.setFaculty(faculty1);
            student2.setFaculty(faculty1);
            student3.setFaculty(faculty1);
            student4.setFaculty(faculty2);

            facultyRepository.save(faculty1);
            facultyRepository.save(faculty2);

            studentRepository.save(student1);
            studentRepository.save(student2);
            studentRepository.save(student3);
            studentRepository.save(student4);

    }
}
}
