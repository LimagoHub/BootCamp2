package de.limago.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import de.limago.jpademo.models.Kontakt;
import de.limago.jpademo.models.Person;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("gothaer");
    	Runtime.getRuntime().addShutdownHook(new Thread() 
        { 
          public void run() 
          { 
            System.out.println("Shutdown Hook is running !"); 
            entityManagerFactory.close();
          } 
        }); 
    	
    	
    	EntityManager em = entityManagerFactory.createEntityManager(); // Session per Action
    	em.getTransaction().begin(); // Transaction per Session
    	
//    	Person john = new Person("Max", "Mustermann");
//    	john.getAdresse().setPlz("12345");
//    	john.getAdresse().setOrt("Nirgendwo");
//    	em.persist(john); // Speichert John // Attached
    	
//    	Person max = em.find(Person.class, 3); // Attached
//    	max.setVorname("Erika");
    	
//    	System.out.println(max);
//    	
//    	Person john = new Person("Max", "Mustermann");
//    	john.setId(3);
//    	john.setVersion(2);
//    	john.setVorname("Erika");
//    	Person attachedPerson = em.merge(john);
//    	
//    	attachedPerson.setVorname("Fritz");
//     	Person john = em.find(Person.class, 3); 
//     	
//    	em.remove(john);
//    	
//    	Person person = new Person();
//    	person.getAdresse().setPlz("123");
//    	person.getAdresse().setOrt("Nirgendwo");
//    	person.getKontakte().add(new Kontakt("Telefon","12345"));
//    	person.getKontakte().add(new Kontakt("Mobil","56477"));
//    	person.getKontakte().add(new Kontakt("e-mail","John@doe.de"));
//    	
//    	
//    	em.persist(person);
    	
    	Person person = em.find(Person.class, 1);
    	//System.out.println(person.getKontakte());
    	
    	em.getTransaction().commit();
    	em.close();
    	
    	System.out.println(person.getKontakte());

    	
    	// Person ist persistent
    	// Person ist Dettached
    	
    	    	
    	System.out.println("Programmende");
    }
}
