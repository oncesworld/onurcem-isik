package utility;

import jakarta.persistence.EntityManager;
import model.Student;
import repository.CrudRepository;

import java.util.List;

public class StudentService implements CrudRepository<Student> {

    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Student> findAll() {

        return entityManager.createQuery("SELECT s FROM Student s",Student.class).getResultList();
    }

    @Override
    public Student find(int id) {

        Student response = entityManager.find(Student.class, id);

        return response;
    }

    @Override
    public void save(Student student) {
        try {
            entityManager.getTransaction().begin();
            entityManager.persist(student);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            System.out.println(student.getStudentName() + " is saved");
            EntityManagerUtils.closeEntityManager(entityManager);
        }
    }

}
