package in.co.rays.pojo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestCache {
	
	public static void main(String[] args) {
		//testFirstCache();
		testSecondCache();
	}

	private static void testSecondCache() {

		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		User pojo = (User) s.get(User.class, 1);
		System.out.println(pojo.getId());
		System.out.println(pojo.getFirstName());
		System.out.println(pojo.getLastName());
		System.out.println(pojo.getLoginId());
		System.out.println(pojo.getPassword());
		
		User pojo1 = (User) s.get(User.class, 1);
		System.out.println(pojo1.getId());
		System.out.println(pojo1.getFirstName());
		System.out.println(pojo1.getLastName());
		System.out.println(pojo1.getLoginId());
		System.out.println(pojo1.getPassword());
		


		
	}

	private static void testFirstCache() {
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();

		Session s = sessionFactory.openSession();

		User pojo = (User) s.get(User.class, 1);
		System.out.println(pojo.getId());
		System.out.println(pojo.getFirstName());
		System.out.println(pojo.getLastName());
		System.out.println(pojo.getLoginId());
		System.out.println(pojo.getPassword());

        //s.evict(pojo);//remove single object given
		//s.clear();//remove all object
		s.close();
        
		Session s1 = sessionFactory.openSession();
		User pojo1 = (User) s1.get(User.class, 1);
		System.out.println(pojo1.getId());
		System.out.println(pojo1.getFirstName());
		System.out.println(pojo1.getLastName());
		System.out.println(pojo1.getLoginId());
		System.out.println(pojo1.getPassword());
		
		
		s1.close();
	}

}
