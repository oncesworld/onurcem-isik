package utility;

import jakarta.persistence.EntityManager;
import model.Course;
import model.Student;
import repository.CrudRepository;

import java.util.List;

public class CourseService implements CrudRepository<Course> {
    EntityManager entityManager = EntityManagerUtils.getEntityManager("mysqlPU");

    @Override
    public List<Course> findAll() {

        return entityManager.createQuery("SELECT c FROM Course c", Course.class).getResultList();
    }

    @Override
    public Course find(int id) {
        return entityManager.find(Course.class,id);
    }

    @Override
    public void save(Course course) {

        try {
            entityManager.getTransaction().begin();
            entityManager.persist(course);
            entityManager.getTransaction().commit();
        }catch (Exception e){
            entityManager.getTransaction().rollback();
        }finally {
            EntityManagerUtils.closeEntityManager(entityManager);
        }

    }
}
