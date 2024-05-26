package com.jspiders.cardekho_case_study_hibernate.dao;

//import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jspiders.cardekho_case_study_hibernate.dto.Car;


public class CarOperation {
	private static  EntityManagerFactory entityManagerFactory;
	private static  EntityManager entityManager;
	private static  EntityTransaction entityTransaction;
	private static Scanner inp= new Scanner(System.in);
	
	private static void opanConnection() {
		entityManagerFactory = Persistence.createEntityManagerFactory("car");
		entityManager= entityManagerFactory.createEntityManager();
		entityTransaction= entityManager.getTransaction();
	}
	
	
	public static void closeConnection() {
		if (entityManagerFactory != null) {
			entityManagerFactory.close();
		}
		if (entityManager!= null) {
			entityManager.clear();
		}
		if (entityTransaction != null) {
			if (entityTransaction.isActive()) {
				entityTransaction.rollback();
			}
		}
	}
	
	public  void add() {
		opanConnection();
		entityTransaction.begin();
		 System.out.println("\n How Many Car's you want to add ? ");
		   int numcar= inp.nextInt();
		  
		   for (int i = 1; i <= numcar; i++) {
			   Car car= new Car();
				   System.out.print("Enter Car ID =");
				   car.setCarId(inp.nextInt());
				   System.out.print("Enter car name =");
				   car.setCarName(inp.next());
				   System.out.print("Enter car Model =");
				   car.setCarMod(inp.next());
				   System.out.print("Enter car Fueltype =");
				   car.setFuelt(inp.next());
				   System.out.print("Enter car Price =");
				   car.setPrice(inp.nextDouble());
				   entityManager.persist(car);
				   System.out.println("\n"+i+" Car Added Successfully\n");
		   }
		
		
		entityTransaction.commit();
	
	

}
	
	//////////////////////////////////////////////////////////////////////////////////
	public void searchCarId() {
		opanConnection();
		entityTransaction.begin();
		System.out.print("Enter Car ID = ");
		int carId= inp.nextInt();
	       Car car = entityManager.find(Car.class, carId);
	      
	          System.out.println(car);
	
		   
		}
	
	   public void	carName() {
       	
		   opanConnection();
			entityTransaction.begin();
			System.out.print("Enter Car Name = ");
			String carName= inp.next();
		       Car car = entityManager.find(Car.class, carName);
		      
		          System.out.println(car);
   	
       }
	   
	   
    public void carPrice() {
    	 opanConnection();
			entityTransaction.begin();
			System.out.print("Enter Car Price = ");
			String price= inp.next();
		       Car car = entityManager.find(Car.class, price);
		      
		          System.out.println(car);
    		}
        
        
        public void carMOd() {
        	  opanConnection();
  			entityTransaction.begin();
  			System.out.print("Enter Car Model = ");
			String carMod= inp.next();
		       Car car = entityManager.find(Car.class, carMod);
		      
		          System.out.println(car);	
        }
        
       
        public void  update() {
      	  showAllCars();
      	  opanConnection();
			entityTransaction.begin();
      	  
      	  
      	  
      	  
			entityTransaction.commit();
  	
        }
        
        
        
        
        public void delete() {
   
      		  showAllCars();
      		  
      		 opanConnection();
 			entityTransaction.begin();
 			System.out.println("Enter Car ID ");
 			int id =inp.nextInt();
  			Query query=entityManager.createQuery("Delete from car where carId ="+id);
  			int row =query.executeUpdate();
  			System.out.println(row+" Deleted Data ");
  			
  		
       	  
       	  
       	  
 			entityTransaction.commit();
   			
      		 
      	 
  		}

	
	
	
	
	
	
	//////////////////////////////////////////////////
	
	
    public void showAllCars() {
   	
			opanConnection();
			entityTransaction.begin();

			Query query=entityManager.createQuery("select car from Car car");
			@SuppressWarnings("unchecked")
			List<Car> cars=query.getResultList();
			for (Car car : cars) {
				System.out.println(car);
				
			}
			entityTransaction.commit();
   	       
      	  
		}

	
}
