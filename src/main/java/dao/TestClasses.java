package dao;

import com.dev.domain.Classes;
import com.dev.domain.Head;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;
import util.HibernateUtil;

import javax.persistence.criteria.Expression;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


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


//        session.getTransaction().commit();


    }


    public void metSave(){

        session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();

        Head newHead = new Head();
        Classes newClasses = new Classes();
        Set <Classes> setClasses = new HashSet();

        Head h1 = (Head) session.createCriteria(Head.class).add(Restrictions.like("name", "Putin")).list().get(0);

        Classes [] arrClasseses = h1.getClasses().toArray(new Classes[]{});

        for (Classes classes : arrClasseses) {
           classes.setRoomNumber(120);
        }

//        session.delete(h1);

//        session.flush();
        session.getTransaction().commit();



    }


}
