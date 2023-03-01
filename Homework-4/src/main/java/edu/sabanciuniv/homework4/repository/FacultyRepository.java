package edu.sabanciuniv.homework4.repository;

import edu.sabanciuniv.homework4.model.Faculty;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface FacultyRepository extends JpaRepository<Faculty, Integer> {

    @Query("select f From Faculty f where f.Id =:id")
    Faculty findFacultiesStudents(int id);
}
