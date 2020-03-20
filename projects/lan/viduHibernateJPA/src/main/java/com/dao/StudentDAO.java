package com.dao;

import com.entity.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;
public class StudentDAO {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();

    public void save(Student Student) {
        entityManager.getTransaction().begin();
        entityManager.persist(Student);
        entityManager.getTransaction().commit();
    }

    public Student findById(int id) {
        Student Student = entityManager.find(Student.class, id);
        return Student;
    }

    public List<Student> findAll() {
        return entityManager.createQuery("SELECT c FROM Student c", Student.class).getResultList();
    }

    public void delete(Student Student) {
        entityManager.getTransaction().begin();
        entityManager.remove(Student);
        entityManager.getTransaction().commit();
    }

    public void close() {
        entityManager.close();
        entityManagerFactory.close();
    }
}
