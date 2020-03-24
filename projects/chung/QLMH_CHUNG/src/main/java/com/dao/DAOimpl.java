package com.dao;

import com.model.entity.TblTeacherEntity;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public class DAOimpl<T> implements DAO<T> {
    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("persistence");
    EntityManager entityManager = entityManagerFactory.createEntityManager();
    Class<T> persistantClass = getPersistantClass();
    Class<T> getPersistantClass() {
        Class<T> classType = (Class<T>) ((ParameterizedType)getClass()
                .getGenericSuperclass())
                . getActualTypeArguments()[0];
        return classType;
    }
    String getPersistantClassName() {
        return this.persistantClass.getSimpleName();
    }
    @Override
    public List<T> listAll() {
        return entityManager.createQuery("SELECT t FROM "+ getPersistantClassName()+" t",persistantClass ).getResultList();
    }

    @Override
    public void create(T t) {
    entityManager.getTransaction().begin();
    entityManager.persist(t);
    entityManager.getTransaction().commit();
    }

    @Override
    public T findByID(int id) {
        entityManager.getTransaction().begin();
        entityManager.find(persistantClass,id);
        entityManager.getTransaction().commit();
        return null;
    }

    @Override
    public void update(T t) {
        entityManager.getTransaction().begin();
        entityManager.merge(t);
        entityManager.getTransaction().commit();
    }

    @Override
    public void delete(T t) {
        entityManager.getTransaction().begin();
        entityManager.remove(t);
        entityManager.getTransaction().commit();
    }
}
