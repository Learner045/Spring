package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class CreateCoursesDemo {

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
			
		
			session.beginTransaction();
			
			//get instructor from db
			int id = 1;
			Instructor ins = session.get(Instructor.class, id);
			
			//create courses
			Course c1 = new Course("Physics");
			Course c2 = new Course("Aerial yoga");
			
			//add courses to instructor
			ins.addCourse(c1);
			ins.addCourse(c2);
			
			//save courses
			session.save(c1);
			session.save(c2);
			
			
			session.getTransaction().commit();
			
		}finally {
			
			session.close();
			factory.close();
			
		}

	}

}
