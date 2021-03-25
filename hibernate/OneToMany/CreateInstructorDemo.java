package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateInstructorDemo {

	public static void main(String[] args) {
		
		//create session factory
		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory();
		
		
		
		Session session = factory.getCurrentSession();
		try {
			
			Instructor ins = new Instructor("Adriene", "Patt", "harry@hogwarts.edu");
			
			InstructorDetail det = new InstructorDetail("yogaWithAdriene","yoga");
			
			
			//associate objects in memory
			ins.setInstructorDetail(det);
			
		
			
			
			session.beginTransaction();
			
			
			session.save(ins);
			
			session.getTransaction().commit();
			
		}finally {
			
			session.close();
			factory.close();
			
		}

	}

}
