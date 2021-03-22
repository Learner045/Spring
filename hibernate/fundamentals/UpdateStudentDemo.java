package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		try {
			
			//create session
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
		
			/*
			int studentId = 1;
			Student s = session.get(Student.class, studentId);
	     	s.setEmail("xyz@yahyah.com");//updated in memory
	     	*/
			
			//Update
			session.createQuery("update Student set email='foo@gmail.com'").executeUpdate();
			
			//Delete
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			session.getTransaction().commit();//updated in db
			
		}finally {
			factory.close();
		}

	}

}
