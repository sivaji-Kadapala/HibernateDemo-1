package com.tony.Hibernate_1;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		System.out.println("Project Started!");
		Configuration cfg = new Configuration();
		cfg.configure("hibernate.cfg.xml");
		// crreate sessionFactory object
		SessionFactory factory = cfg.buildSessionFactory();
		// creating student
		Student student = new Student();
		student.setId(101);
		student.setName("Jhon");
		student.setCity("Delhi");
		System.out.println(student);
		// current session
		Session session = factory.openSession();
		org.hibernate.Transaction tx = session.beginTransaction();
		session.save(student);
		tx.commit();

		session.close();
		factory.close();

	}
}
