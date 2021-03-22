package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Student;

public class QueryStudentDemo {

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
			
			List<Student> students = session.createQuery("from Student").getResultList();
			
			//for(Student std: students)System.out.println(std);
			
			
			//find all students with lastName = doe
			students = session.createQuery("from Student s where s.lastName='Wall'").getResultList();
			for(Student std: students)System.out.println(std);
			
			session.getTransaction().commit();
			
			
		}finally {
			factory.close();
		}

	}

}
