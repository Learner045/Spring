package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		
		
		
		
		try {
			
			Instructor ins = new Instructor("Harry", "Potter", "harry@hogwarts.edu");
			
			InstructorDetail det = new InstructorDetail("LetsPlayQuiddich","Quiddich");
			
			
			//associate objects in memory
			ins.setInstructorDetail(det);
			
			//create session
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			//this will also save detail as Cascading effect - ALL
			session.save(ins);
			
			session.getTransaction().commit();
			
		}finally {
			factory.close();
		}

	}

}
