package in.co.rays.pojo;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class TestUser {

	public static void main(String[] args) {
		// testAdd();
		// testUpdate();
		// testDelete();
		// testGet();
		// testList();
		// testAgregate();
		testGroupBy();
	}

	private static void testGroupBy() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Query q = s.createQuery("select u.firstName ,count(*) from User u group by u.firstName");

		List col = q.list();
		Iterator it = col.iterator();

		while (it.hasNext()) {

			Object[] pojo = (Object[]) it.next();
			System.out.println(pojo[0] + " = " + pojo[1]);
		}
		s.close();
	}

	private static void testAgregate() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		Query q = s.createQuery("select count(*)from User");
		List rows = q.list();
		Long row = (Long) rows.get(0);
		System.out.println(row);
		s.close();
	}

	private static void testList() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();
		// Query q= s.createQuery("from User");
		// Query q= s.createQuery("from User where LastName like '%par%'");
		// Query q= s.createQuery("select u.firstName from User u");
		// Query q= s.createQuery("select u.id, u.firstName from User u");
		Query q = s.createQuery("from User where lastName like '%pa%' order by firstName");
		List l = q.list();
		Iterator it = l.iterator();

		while (it.hasNext()) {

			/*
			 * Object[] pojo=(Object[]) it.next(); System.out.println(pojo[0]);
			 * System.out.println(pojo[1]);
			 */
			/*
			 * String pojo= (String)it.next(); System.out.println(pojo);
			 */

			User pojo = (User) it.next();
			System.out.println(pojo.getId());
			System.out.println(pojo.getFirstName());
			System.out.println(pojo.getLastName());
			System.out.println(pojo.getLoginId());
			System.out.println(pojo.getPassword());

		}
		s.close();
	}

	private static void testGet() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		User pojo = (User) s.get(User.class, 1);
		System.out.println(pojo.getId());
		System.out.println(pojo.getFirstName());
		System.out.println(pojo.getLastName());
		System.out.println(pojo.getLoginId());
		System.out.println(pojo.getPassword());

		s.close();
	}

	private static void testDelete() {
		User pojo = new User();
		pojo.setId(3);

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.delete(pojo);

		tx.commit();
		s.close();

	}

	private static void testUpdate() {
		User pojo = new User();
		pojo.setId(1);
		pojo.setFirstName("Nidhi");
		pojo.setLastName("Pardhi");
		pojo.setLoginId("N@gmail.com");
		pojo.setPassword("NNN@12345");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.update(pojo);
		tx.commit();
		s.close();

	}

	private static void testAdd() {
		User pojo = new User();
		pojo.setFirstName("Preeti");
		pojo.setLastName("Pardhi");
		pojo.setLoginId("ppp@gmail.com");
		pojo.setPassword("ppp@12345");

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session s = sessionFactory.openSession();
		Transaction tx = s.beginTransaction();

		s.save(pojo);
		tx.commit();
		s.close();

	}

}
