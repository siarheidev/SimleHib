package dao;

import com.dev.domain.Classes;
import com.dev.domain.Head;
import org.hibernate.Criteria;
import org.hibernate.Hibernate;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import javax.persistence.criteria.Expression;
import java.util.List;
import java.util.Set;


public class TestClasses {

    Session session = null;
    public void met (){
        String getHeadQuery = "FROM Head where id = :id";
        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        Query query = session.createQuery(getHeadQuery);
        query.setParameter("id", 1);
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

        Head head = (Head)session.get(Head.class, 2);

        System.out.println("Name: " + head.getName());

        session.close();

        System.out.println("Name after: " + head.getName());
//        for (Classes classes : head.getClasses()) {
//            System.out.println("Name: " + classes.getName());
//        }


//        session.getTransaction().commit();


    }


}
