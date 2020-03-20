package com.dao;

import com.myutils.HibernateUtils;
import com.model.entity.TblAssistantEntity;
import com.model.entity.TblClassEntity;
import com.model.entity.TblStudentEntity;
import com.model.entity.TblTeacherEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;
import java.util.Set;

public class ClassDAOImpl implements DAO {
    SessionFactory factory = new HibernateUtils().getSessionFactory();
    @Override
    public List<TblClassEntity> uc_ListAll() {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String sql = "Select s from "+ TblStudentEntity.class.getName() + " s";
        Query<TblClassEntity> query = session.createQuery(sql);
        List<TblClassEntity> classEntities = query.getResultList();
        session.getTransaction().commit();
        return classEntities;
    }

    @Override
    public void uc_ShowAll() {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String sql = "Select s from "+ TblClassEntity.class.getName() + " s";
        Query<TblClassEntity> query = session.createQuery(sql);
        List<TblClassEntity> ClassEntities = query.getResultList();
        for (TblClassEntity Clazz :
                ClassEntities)   {
            System.out.println("ID:" + Clazz. getId()+" Class "+ Clazz.getName());
        }
        session.getTransaction().commit();

    }

    @Override
    public void uc_Create(String name) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblClassEntity Clazz = new TblClassEntity();
        Clazz.setName(name);
        session.save(Clazz);
        session.getTransaction().commit();

    }

    @Override
    public void uc_UpdateName(String name) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblClassEntity Clazz = new TblClassEntity();
        Clazz.setName(name);
        session.saveOrUpdate(Clazz);
        session.getTransaction().commit();

    }

    @Override
    public void uc_DeleteByID(int id) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblClassEntity Clazz = session.get(TblClassEntity.class,id);
        Clazz.getTblStudentEntities().clear();
        session.delete(Clazz);
        session.getTransaction().commit();

    }
    public void uc_AddStudentToClass(int clazz_id, int student_id)
    {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblClassEntity tblClassEntity = session.get(TblClassEntity.class,clazz_id);
        TblStudentEntity tblStudentEntity=session.get(TblStudentEntity.class,student_id);
        tblClassEntity.getTblStudentEntities().add(tblStudentEntity);
        session.getTransaction().commit();
    }
    public void uc_AddAssistantToClass(int clazz_id, int assistant_id)
    {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblClassEntity tblClassEntity = session.get(TblClassEntity.class,clazz_id);
        TblAssistantEntity tblAssistantEntity=session.get(TblAssistantEntity.class,assistant_id);
        tblClassEntity.getTblAssistantEntities().add(tblAssistantEntity);
        session.getTransaction().commit();
    }
    public void uc_AddTeacherToClass(int clazz_id, int teacher_id)
    {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblClassEntity tblClassEntity = session.get(TblClassEntity.class,clazz_id);
        TblTeacherEntity tblTeacherEntity=session.get(TblTeacherEntity.class,teacher_id);
        tblClassEntity.getTblTeacherEntities().add(tblTeacherEntity);
        session.getTransaction().commit();
    }

    public void uc_findClassInfo( int clazz_id)
    {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblClassEntity tblClassEntity = session.get(TblClassEntity.class,clazz_id);;
        tblClassEntity.getTblTeacherEntities();
        Set<TblTeacherEntity> tblTeacherEntities = tblClassEntity.getTblTeacherEntities();
        for (TblTeacherEntity teacher :
                tblTeacherEntities) {
            System.out.println(teacher.getId());
            System.out.println(teacher.getName());
        }
        session.getTransaction().commit();
    }


}
