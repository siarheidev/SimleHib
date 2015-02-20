package com.dev.dao;

import com.dev.domain.Classes;
import com.dev.domain.Head;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import com.dev.util.HibernateUtil;
import org.hibernate.proxy.HibernateProxy;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TestClasses {

    Session session = null;
    public void met (){
        String getHeadQuery = "FROM Head where id = :id";
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery(getHeadQuery);
        query.setParameter("id", 0);
        List result = query.list();

        Head h = (Head) result.get(0);
        Set<Classes> set = h.getClasses();

        Hibernate.initialize(set);

        session.getTransaction().commit();
        session.close();

        System.out.println("name: " + h.getName());
        for (Classes classes : set) {
            System.out.println("class: " + classes.getName());
        }

    }

    public void metCr(){

        session = HibernateUtil.getSessionFactory().openSession();

        List list = session.createCriteria(Head.class).add(Restrictions.like("id", new Integer(1)))
                .createCriteria("classes", "c").add(Restrictions.like("c.id", 1)).list();
        Head head = (Head) list.get(0);

        System.out.println("Name after: " + head.getName());
        for (Classes classes : head.getClasses()) {
            System.out.println("Name: " + classes.getName());
        }


        session.close();

    }


    public void metSave(){

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Head newHead = new Head();
        Classes newClasses = new Classes();
        Set <Classes> setClasses = new HashSet();

        Head h1 = (Head) session.createCriteria(Head.class).add(Restrictions
                .like("id", new Integer(1))).list().get(0);
        Classes c1 = new Classes();
        Classes c2 = new Classes();

        initializeAndUnproxy(h1);

        session.getTransaction().commit();

    }

    public Head getHead(){

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Head newHead = new Head();
        Classes newClasses = new Classes();
        Set <Classes> setClasses = new HashSet();

        Head h1 = (Head) session.createCriteria(Head.class).add(Restrictions
                .like("id", new Integer(13))).list().get(0);
        Classes c1 = new Classes();
        Classes c2 = new Classes();

        h1 = initializeAndUnproxy(h1);

        session.getTransaction().commit();

        return h1;


    }



    public  <T> T initializeAndUnproxy(T entity) {
        if (entity == null) {
            throw new
                    NullPointerException("Entity passed for initialization is null");
        }

        Hibernate.initialize(entity);
        if (entity instanceof HibernateProxy) {
            entity = (T) ((HibernateProxy) entity).getHibernateLazyInitializer()
                    .getImplementation();
        }
        return entity;
    }


}
