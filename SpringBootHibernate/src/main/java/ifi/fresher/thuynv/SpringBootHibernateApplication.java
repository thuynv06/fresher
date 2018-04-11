package ifi.fresher.thuynv;


//import java.util.Arrays;
//
//import org.hibernate.Session;
//import org.hibernate.SessionFactory;
//import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
//import org.hibernate.cfg.Configuration;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;



@SpringBootApplication
@ComponentScan({ "ifi.fresher.thuynv" })
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class,
		DataSourceTransactionManagerAutoConfiguration.class, HibernateJpaAutoConfiguration.class })
public class SpringBootHibernateApplication {
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHibernateApplication.class, args);
		
//		createStudent();
		
		
	}

//	public static SessionFactory getSessionFactory() {
//		Configuration configuration = new Configuration().configure();
//		StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder()
//				.applySettings(configuration.getProperties());
//		SessionFactory sessionFactory = configuration
//				.buildSessionFactory(builder.build());
//		return sessionFactory;
//	}
//	public static void createStudent() {
//		System.out.println("****************Creating Student*************");
//		Student student = new Student();
//		student.setName("John");
//		student.setAge(23);
//		student.setPhone("34023490");
//		Course course1 = new Course("John");
//		Course course2 = new Course("Rohan");
//		student.setCourses(Arrays.asList(course1, course2));
//		Session session = getSessionFactory().openSession();
//		session.beginTransaction();
//		session.save(student);
//		session.save(course1);
//		session.save(course2);
//		session.getTransaction().commit();
//		session.close();
//		System.out.println("Student Created Successfully" + student.toString());
//
//	}
}