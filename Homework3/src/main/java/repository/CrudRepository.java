package repository;

import model.Student;

import java.util.List;

public interface CrudRepository<T> {

    List<T> findAll();

    T find(int id);

    void save(T object);
}
