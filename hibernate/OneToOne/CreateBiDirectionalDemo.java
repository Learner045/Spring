package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateBiDirectionalDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		try {
			
			
			//create session
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			InstructorDetail detail = session.get(InstructorDetail.class, 2);
			
			Instructor instr = detail.getInstructor();
			
			System.out.println(instr);
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
