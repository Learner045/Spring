package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Course;
import com.luv2code.hibernate.demo.entity.Instructor;
import com.luv2code.hibernate.demo.entity.InstructorDetail;
import com.luv2code.hibernate.demo.entity.Student;

public class GetInstructorCoursesDemo {

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
			/*
			//get instructor from db
			int id = 1;
			Instructor ins = session.get(Instructor.class, id);
			
			System.out.println(ins);
			
			//getting courses for instr
			List<Course> courses = ins.getCourses();
			System.out.println(courses);*/
			
			//get course from db
			Course course = session.get(Course.class, 10);
			
			//delete the course
			session.delete(course);
			
			session.getTransaction().commit();
			
		}finally {
			
			session.close();
			factory.close();
			
		}

	}

}
