package test;

import controller.CourseController;
import controller.StudentController;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import model.Course;
import model.Instructor;
import model.PermanentInstructor;
import model.Student;
import utility.EntityManagerUtils;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class mainClass {
    public static void main(String[] args) {

        EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

        Course course1 = new Course("Phyton", "IT501", 3);
        Course course2 = new Course("Java", "IT524", 4);
        Course course3 = new Course("EE Java", "IT526", 99);


        Student student1 = new Student("Onur",
                LocalDate.of(1993,9,16),"Istanbul","E");
        Student student2 = new Student("Cem",
                LocalDate.of(1994,10,26),"Istanbul","E");
        Student student3 = new Student("Selim",
                LocalDate.of(1990,2,22),"Istanbul","E");
        Student student4 = new Student("Can",
                LocalDate.of(1989,1,11),"Istanbul","E");

        List<Student> studentList = new ArrayList<>();

        studentList.add(student1);
        studentList.add(student2);
        studentList.add(student3);
        studentList.add(student4);

        student1.getStudentCourseList().add(course1);
        student1.getStudentCourseList().add(course2);
        student2.getStudentCourseList().add(course3);
        student4.getStudentCourseList().add(course2);

        Instructor permanentInstructor1 = new Instructor("Koray",
                "Sabancı", "999 999 99 99");
        Instructor permanentInstructor2 = new Instructor("Ahmet",
                "Altunizade", "999 999 99 99");
        Instructor visitingResearcher1 = new Instructor("Yusuf", "Izmir",
                "111 111 11 11");
        Instructor visitingResearcher2 = new Instructor("Su", "Adana",
                "222 222 22 22");

        List<Instructor> instructorList = new ArrayList<>();

        instructorList.add(permanentInstructor1);
        instructorList.add(permanentInstructor2);
        instructorList.add(visitingResearcher1);
        instructorList.add(visitingResearcher2);

        //permanentInstructor1.getInstructorsCourseList().add(course1);
        //permanentInstructor1.getInstructorsCourseList().add(course2);
        //permanentInstructor2.getInstructorsCourseList().add(course2); //course2 already has instructor
        //visitingResearcher1.getInstructorsCourseList().add(course3);
        //visitingResearcher2.getInstructorsCourseList().add(course1); //course1 already has instructor

        List<Course> courseList = new ArrayList<>();

        courseList.add(course1);
        courseList.add(course2);
        courseList.add(course3);

        course1.setInstructor(permanentInstructor1);
        course2.setInstructor(permanentInstructor1);
        course3.setInstructor(visitingResearcher1);


        //saveInstructors(instructorList,entityManager);
        //saveCourses(courseList,entityManager);
        //saveStudents(studentList,entityManager);

        StudentController studentController = new StudentController();
        CourseController courseController = new CourseController();

        Student foundStudent = studentController.findStudent(10);
        System.out.println("============");
        System.out.println(foundStudent.getStudentName());
        System.out.println("============");

        Student manuelInsertStudent = new Student("Ichigo Kurosaki",
                LocalDate.of(1993,9,16),"Istanbul","E");

        Course manuelInsertCourse = new Course("Shinigami", "IT501", 3);

        studentController.saveStudent(manuelInsertStudent);
        courseController.saveCourse(manuelInsertCourse);


        EntityManagerUtils.closeEntityManager(entityManager);

    }

    private static void saveStudents(List<Student> studentList, EntityManager entityManager){
        try {
            entityManager.getTransaction().begin();
            for (Student student : studentList) {
                entityManager.persist(student);
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    private static void saveInstructors(List<Instructor> instructorList, EntityManager entityManager){
        try {
            entityManager.getTransaction().begin();
            for (Instructor instructor : instructorList) {
                entityManager.persist(instructor);
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

    private static void saveCourses(List<Course> courseList, EntityManager entityManager){
        try {
            entityManager.getTransaction().begin();
            for (Course course : courseList) {
                entityManager.persist(course);
            }
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }
    }

}
