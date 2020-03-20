package com.dao;

import com.myutils.HibernateUtils;
import com.model.entity.TblTeacherEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class TeacherDAO implements DAO {
    SessionFactory factory = new HibernateUtils().getSessionFactory();
    @Override
    public List<TblTeacherEntity> uc_ListAll() {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String sql = "Select s from "+ TblTeacherEntity.class.getName() + " s";
        Query<TblTeacherEntity> query = session.createQuery(sql);
        List<TblTeacherEntity> TeacherEntities = query.getResultList();
        session.getTransaction().commit();
        return TeacherEntities;
    }

    @Override
    public void uc_ShowAll() {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String sql = "Select s from "+ TblTeacherEntity.class.getName() + " s";
        Query<TblTeacherEntity> query = session.createQuery(sql);
        List<TblTeacherEntity> TeacherEntities = query.getResultList();
        for (TblTeacherEntity Teacher :
                TeacherEntities)   {
            System.out.println("ID:" + Teacher.getId()+" giao vien: "+ Teacher.getName());
        }
        session.getTransaction().commit();

    }

    @Override
    public void uc_Create(String name) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblTeacherEntity Teacher = new TblTeacherEntity();
        Teacher.setName(name);
        session.save(Teacher);
        session.getTransaction().commit();

    }

    @Override
    public void uc_UpdateName(String name) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblTeacherEntity Teacher = new TblTeacherEntity();
        Teacher.setName(name);
        session.saveOrUpdate(Teacher);
        session.getTransaction().commit();

    }

    @Override
    public void uc_DeleteByID(int id) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblTeacherEntity Teacher = session.get(TblTeacherEntity.class,id);
        Teacher.getClassEntities().clear();
        session.delete(Teacher);
        session.getTransaction().commit();

    }

}
