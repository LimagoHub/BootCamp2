package de.limago.jpademo;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import de.limago.jpademo.models.Hund;
import de.limago.jpademo.models.Katze;
import de.limago.jpademo.models.Tier;

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
    	
    	EntityManager em = entityManagerFactory.createEntityManager();
    	EntityTransaction transaction = em.getTransaction();
    	transaction.begin();
    	
    	Hund fiffi = new Hund();
    	fiffi.setName("Fiffi");
    	
    	em.persist(fiffi);
    	
    	Hund hasso = new Hund();
    	hasso.setName("Hasso");
    	
    	em.persist(hasso);
    	
    	Katze katze = new Katze();
    	katze.setName("Mietzie");
    	
    	em.persist(katze);
    	
    	
//    	Hund h = em.find(Hund.class, 1);
//    	System.out.println(h);
    	
//    	Tier t = em.find(Tier.class, 3);
//    	System.out.println(t);
//    	
//    	
    	transaction.commit();
    	em.close();
    	
    }
}
