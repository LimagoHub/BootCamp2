package de.limago.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

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
    	// Transient -> heisst ist der Datenbank nicht bekannt
    	// Detached -> JPA nicht bekannt
    	Person john = new Person();
    	em.persist(john); // Speichert John 
    	// Person ist persistent
    	// Person ist Attached
    	
    	john.setVorname("Jane");
    	
    	em.getTransaction().commit();
    	em.close();
    	// Person ist persistent
    	// Person ist Dettached
    	john.setVorname("Max");
    	
    	System.out.println(john);
    	    	
    	System.out.println("Programmende");
    }
}
