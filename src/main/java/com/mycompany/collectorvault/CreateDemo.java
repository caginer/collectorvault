package com.mycompany.collectorvault;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mycompany.collectorvault.entity.ArticuloCol;
import com.mycompany.collectorvault.entity.Coleccion;
import com.mycompany.collectorvault.entity.Item;
import com.mycompany.collectorvault.entity.ItemEnVenta;
import com.mycompany.collectorvault.entity.ItemVendido;
import com.mycompany.collectorvault.entity.Plataforma;
import com.mycompany.collectorvault.entity.Usuario;



public class CreateDemo {

	public static void main(String[] args) {

		//create session  factory
		
		SessionFactory  factory =  new  Configuration() 
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(ArticuloCol.class)
				.addAnnotatedClass(Usuario.class)
				.addAnnotatedClass(Coleccion.class)
				.addAnnotatedClass(Item.class)
				.addAnnotatedClass(ItemEnVenta.class)
				.addAnnotatedClass(ItemVendido.class)
				.addAnnotatedClass(Plataforma.class)
				.buildSessionFactory();
		
		//create session
		
		Session  session = factory.getCurrentSession();
		
		try {
		
			//create   object
			
			Usuario tempInstructor =
					new Usuario("Chad","Darby","darby@lu2code.com", null);
			

			
			
			//associate objects
			


			
			// start a transaction
			
			session.beginTransaction();
			
			
			System.out.println("saving instructor: " + tempInstructor);
	
			session.save(tempInstructor);
			

			session.getTransaction().commit();
			
			System.out.println("Done");
		}
		finally {
			factory.close();
		}

	}

}
