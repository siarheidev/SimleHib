package util;

import org.hibernate.SessionFactory;
import org.hibernate.c3p0.internal.C3P0ConnectionProvider;
import org.hibernate.cfg.Configuration;
import org.hibernate.engine.jdbc.connections.spi.ConnectionProvider;
import org.hibernate.engine.spi.SessionFactoryImplementor;
import org.hibernate.internal.SessionFactoryImpl;
import org.hibernate.service.spi.Stoppable;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private HibernateUtil (){}
	
	static{
		try{
			sessionFactory = new Configuration().configure().buildSessionFactory();
		}catch (Throwable e){
			throw new ExceptionInInitializerError(e);
		}
	}

	public static SessionFactory getSessionFactory (){
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if(sessionFactory instanceof SessionFactoryImpl) {
			SessionFactoryImpl sf = (SessionFactoryImpl)sessionFactory;
			ConnectionProvider conn = sf.getConnectionProvider();
			if(conn instanceof C3P0ConnectionProvider) {
				((C3P0ConnectionProvider)conn).close();
			}
		}
		sessionFactory.close();
	}
}
