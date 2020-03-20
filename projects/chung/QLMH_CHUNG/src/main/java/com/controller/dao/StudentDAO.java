package com.controller.dao;

import com.controller.HibernateUtils;
import com.model.entity.TblClassEntity;
import com.model.entity.TblStudentEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class StudentDAO implements DAO{
    SessionFactory factory = new HibernateUtils().getSessionFactory();
    @Override
    public List<TblStudentEntity> uc_ListAll() {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String sql = "Select s from "+ TblStudentEntity.class.getName() + " s";
        Query<TblStudentEntity> query = session.createQuery(sql);
        List<TblStudentEntity> studentEntities = query.getResultList();
        session.getTransaction().commit();
        return studentEntities;
    }

    public void uc_ShowAll()
    {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String sql = "Select s from "+ TblStudentEntity.class.getName() + " s";
        Query<TblStudentEntity> query = session.createQuery(sql);
        List<TblStudentEntity> studentEntities = query.getResultList();
        for (TblStudentEntity student :
                studentEntities)   {
            System.out.println("ID:" + student.getId() + " sinh vien "+ student.getName());
        }
        session.getTransaction().commit();
    }


    @Override
    public void uc_Create(String name) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblStudentEntity student = new TblStudentEntity();
        student.setName(name);
        session.save(student);
        session.getTransaction().commit();
    }


    @Override
    public void uc_UpdateName(String name) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblStudentEntity student = new TblStudentEntity();
        student.setName(name);
        session.saveOrUpdate(student);
        session.getTransaction().commit();
    }

    @Override
    public void uc_DeleteByID(int id) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblStudentEntity student = session.get(TblStudentEntity.class,id);
        student.getClassEntities().clear();
        session.delete(student);
        session.getTransaction().commit();
    }



}
