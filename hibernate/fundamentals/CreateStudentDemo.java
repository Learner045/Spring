package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class CreateStudentDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
		
		
		//create session
		Session session = factory.getCurrentSession();
		
		try {
			
			//create student obj
			Student student = new Student("Paul", "Wall", "xyz@xyz.com");
			
			//save obj using session
			session.beginTransaction();
			session.save(student);
			session.getTransaction().commit();
			
			
			//reading obj from databse
			session = factory.getCurrentSession();
			
			session.beginTransaction();
		
			Student retrievedStudent = session.get(Student.class, 1);
			
			System.out.println(retrievedStudent);
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
