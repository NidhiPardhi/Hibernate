package in.co.rays.pojo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;

public class TestCriteria {

	public static void main(String[] args) {
		// testList();
		// testRestrictions();
		// testProjection();
		testAggr();
	}

	private static void testAggr() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Criteria c = s.createCriteria(User.class);
		ProjectionList p = Projections.projectionList();

		 p.add(Projections.count("lastName"));//int i
		//p.add(Projections.rowCount());//int i
		 p.add(Projections.groupProperty("lastName"));
		c.setProjection(p);
		List l = c.list();
        Iterator it= l.iterator();
        while (it.hasNext()) {
        	Object[] st=(Object[]) it.next();
        	System.out.println(st[1]+" = "+st[0]);
        
        	
			/*
			 * String st=(String) it.next(); System.out.println(st);
			 */
        	
        }
        
		
		/*
		 * int i = (int) l.get(0); System.out.println(i);
		 */

		s.close();

	}

	private static void testProjection() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Criteria c = s.createCriteria(User.class);
		ProjectionList p = Projections.projectionList();
		// p.add(Projections.property("firstName"));
		p.add(Projections.property("id"));
		c.setProjection(p);
		List l = c.list();
		Iterator it = l.iterator();

		while (it.hasNext()) {
			Integer pojo = (Integer) it.next();
			System.out.println(pojo);
		}
		s.close();

	}

	private static void testRestrictions() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Criteria c = s.createCriteria(User.class);
		c.add(Restrictions.like("lastName", "Pardhi"));
		c.add(Restrictions.eq("firstName", "Preeti"));
		List l = c.list();
		Iterator<User> it = l.iterator();

		while (it.hasNext()) {
			User pojo = (User) it.next();
			System.out.println(pojo.getId());
			System.out.println(pojo.getFirstName());
			System.out.println(pojo.getLastName());
			System.out.println(pojo.getLoginId());
			System.out.println(pojo.getPassword());
		}
		s.close();

	}

	private static void testList() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		Criteria c = s.createCriteria(User.class);
		List l = c.list();
		Iterator<User> it = l.iterator();

		while (it.hasNext()) {
			User pojo = (User) it.next();
			System.out.println(pojo.getId());
			System.out.println(pojo.getFirstName());
			System.out.println(pojo.getLastName());
			System.out.println(pojo.getLoginId());
			System.out.println(pojo.getPassword());
		}
		s.close();
	}

}
