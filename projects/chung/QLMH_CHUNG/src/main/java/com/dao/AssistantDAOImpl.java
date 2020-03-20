package com.dao;

import com.myutils.HibernateUtils;
import com.model.entity.TblAssistantEntity;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

import java.util.List;

public class AssistantDAOImpl implements AssistantDao {
    SessionFactory factory = new HibernateUtils().getSessionFactory();
    @Override
    public List<TblAssistantEntity> uc_ListAll() {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String sql = "Select s from "+ TblAssistantEntity.class.getName() + " s";
        Query<TblAssistantEntity> query = session.createQuery(sql);
        List<TblAssistantEntity> assistantEntities = query.getResultList();
        session.getTransaction().commit();
        return assistantEntities;
    }

    @Override
    public void uc_ShowAll() {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        String sql = "Select s from "+ TblAssistantEntity.class.getName() + " s";
        Query<TblAssistantEntity> query = session.createQuery(sql);
        List<TblAssistantEntity> AssistantEntities = query.getResultList();
        for (TblAssistantEntity Assistant :
                AssistantEntities)   {
            System.out.println("ID: " + Assistant.getId() + "Tro giang: "+Assistant.getName());
        }
        session.getTransaction().commit();

    }

    @Override
    public void uc_Create(String name) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblAssistantEntity Assistant = new TblAssistantEntity();
        Assistant.setName(name);
        session.save(Assistant);
        session.getTransaction().commit();

    }

    @Override
    public void uc_UpdateName(String name) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblAssistantEntity Assistant = new TblAssistantEntity();
        Assistant.setName(name);
        session.saveOrUpdate(Assistant);
        session.getTransaction().commit();

    }

    @Override
    public void uc_DeleteByID(int id) {
        Session session = factory.getCurrentSession();
        session.getTransaction().begin();
        TblAssistantEntity Assistant = session.get(TblAssistantEntity.class,id);
        Assistant.getClassEntities().clear();
        session.delete(Assistant);
        session.getTransaction().commit();

    }

}

