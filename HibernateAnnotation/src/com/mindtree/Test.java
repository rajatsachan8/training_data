package com.mindtree;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
 
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        Student student = new Student();
        student.setId(1);
        student.setName("Rajat");
        student.setDegree("B.Tech");
 
        Transaction tx = session.beginTransaction();
        session.save(student);
        System.out.println("Object saved successfully.....!!");
        tx.commit();
        session.close();
        factory.close();
	}

}
