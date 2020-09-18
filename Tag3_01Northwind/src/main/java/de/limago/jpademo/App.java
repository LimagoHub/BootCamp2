package de.limago.jpademo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import de.gothaer.models.Customer;
import de.gothaer.models.Order;
import de.gothaer.models.Order_detail;
import de.gothaer.models.TinyCustomer;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	final EntityManagerFactory entityManagerFactory = 
    			Persistence.createEntityManagerFactory("northwind");
    	Runtime.getRuntime().addShutdownHook(new Thread() 
        { 
          public void run() 
          { 
            System.out.println("Shutdown Hook is running !"); 
            entityManagerFactory.close();
          } 
        }); 
    	
      	EntityManager em = entityManagerFactory.createEntityManager();
      	em.getTransaction().begin();
      	
//      	TypedQuery<Customer> query = em.createQuery("select c from Customer c where c.city=:city", Customer.class);
////      	query.setMaxResults(10);
////      	query.setFirstResult(70);
//      	
//     	query.setParameter("city", "London");
//      	
//      	List<Customer> customers = query.getResultList(); 
//      	customers.forEach(System.out::println);
//      	
//     	query.setParameter("city", "Paris");
//      	
//      	customers = query.getResultList(); 
//      	customers.forEach(System.out::println);
      	
      	
//      	TypedQuery<Long> query = em.createQuery("select count(c) from Customer c", Long.class);
//      	long anzahl = query.getSingleResult();
//      	
//      	System.out.println(anzahl);
  
      	
//  	TypedQuery<Order_detail> query = em.createQuery("select od from Order_detail od where od.getTotal() > 100.0", Order_detail.class);
////  	query.setMaxResults(10);
////  	query.setFirstResult(70);
//  	
// //	query.setParameter("city", "London");
//  	
//  	List<Order_detail> customers = query.getResultList(); 
//  	customers.forEach(System.out::println);
  	

      	TypedQuery<Object[]> query = em.createQuery("select count(c),c.companyName from Customer c inner join c.orders o group by c.companyName order by count(c) desc", Object[].class);
      	query.setMaxResults(1);
      	List<Object[]> result = query.getResultList();
      	
      	for (Object[] customer : result) {
      		for(Object object : customer) {
				System.out.println(object);
			}
		}
      	
      	em.getTransaction().commit();
      	em.close();
    	
    	
    	System.out.println("Hallo");
    	
    
    	
    }
}
