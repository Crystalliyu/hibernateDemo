package hibernateDemo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import hibernateDemo.hibernate.Config;
import hibernateDemo.hibernate.model.Address;
import hibernateDemo.hibernate.model.Person;
import hibernateDemo.hibernate.model.Phone;
import hibernateDemo.hibernate.model.PhoneDetail;

public class Main {
	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);

		SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");

		Session session = sessionFactory.openSession();

		session.beginTransaction();

		
//		 One to one mapping example
		  
		 Phone phone = new Phone(); 
		 phone.setNumber("123");
		  
		 PhoneDetail detail = new PhoneDetail(); 
		 detail.setProvider("ATT");
		 
		 detail.setPhone(phone); 
		 phone.setDetails(detail);
		  
		 session.save(detail); 
		 session.save(phone);
		  
		 session.getTransaction().commit(); 
		 session.close();
		 

		/*
		 * One to Many example
		 * 
		 * Person person1 = new Person(); 
		 * Person person2 = new Person();
		 * 
		 * person1.setName("stefan"); 
		 * person2.setName("sean");
		 * 
		 * 
		 * Phone phone1 = new Phone(); 
		 * phone1.setNumber("123");
		 * 
		 * Phone phone2 = new Phone(); 
		 * phone2.setNumber("456");
		 * 
		 * Phone phone3 = new Phone(); 
		 * phone3.setNumber("789");
		 * 
		 *
		 * phone1.setPerson(person1); 
		 * phone2.setPerson(person1);
		 * phone3.setPerson(person2);
		 * 
		 * 
		 * person1.getPhone().add(phone1); 
		 * person1.getPhone().add(phone2);
		 * person2.getPhone().add(phone3);
		 * 
		 * session.save(person1); 
		 * session.save(person2);
		 * 
		 * 
		 * session.getTransaction().commit(); 
		 * session.close();
		 * 
		 * System.out.println("------------"); 
		 * session = sessionFactory.openSession();
		 * session.beginTransaction();
		 * 
		 * Phone phone4 = new Phone(); 
		 * phone4.setNumber("0000");
		 * 
		 * person1 = session.get(Person.class, 1); 
		 * phone4.setPerson(person1);
		 * person1.getPhone().add(phone4); 
		 * session.save(person1);
		 * 
		 * 
		 */

		/*
		 * Many to Many example
		 * 
		 * Person stefan = new Person();
		 * Person sean = new Person();
		 * 
		 * Address address1 = new Address();
		 * Address address2 = new Address();
		 * 
		 * address1.setName("san jose");
		 * address2.setName("sunnyvale");
		 * 
		 * stefan.getAddresses().add(address1);
		 * stefan.getAddresses().add(address2);
		 * 
		 * sean.getAddresses().add(address1);
		 * sean.getAddresses().add(address2);
		 * 
		 * address1.getPersons().add(stefan);
		 * address1.getPersons().add(sean);
		 * 
		 * address2.getPersons().add(stefan);
		 * address2.getPersons().add(sean);
		 * 
		 * session.save(address1);
		 * session.save(address2);
		 * session.save(stefan);
		 * session.save(sean);
		 * 
		 * session.getTransaction().commit();
		 * session.close();
		 */
			
	}
}
