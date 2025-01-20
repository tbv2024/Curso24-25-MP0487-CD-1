package neoqubit.net.pruebasMaven;


/**
 * Hello world!   
 *
 */
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import jakarta.persistence.NoResultException;
import neoqubit.net.pruebasMaven.entities.Persona;
import neoqubit.net.pruebasMaven.entities.Persona2;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;

public class App 
{
    public static void main( String[] args )
    {
    	System.out.println( "Iniciando configuración hibernate...");
        final StandardServiceRegistry registro = new StandardServiceRegistryBuilder().configure().build();
        final SessionFactory factory = new MetadataSources(registro).buildMetadata().buildSessionFactory();
        
        System.out.println( "Abriendo conexión a BD ...");
        final Session session = factory.openSession();
        System.out.println( "Conexión abierta a BD ...");
        
//        System.out.println( "Cerrando conexión a BD ...");
//        session.close();
//        System.out.println( "Conexión terminada a BD ...");
        
        
        /* GUARDAR DATOS */
//        session.beginTransaction();
//        // Creamos la Persona
//        Persona persona = new Persona("Alvaro", 27, new Date());
//        session.persist(persona);
//        session.getTransaction().commit();
//
//        session.beginTransaction();
//        // Creamos la Persona
//        Persona2 persona2 = new Persona2("Alvaro", 27, new Date());
//        session.persist(persona2);
//        session.getTransaction().commit();
        
        
        
        /* ACTUALIZAR DATOS */
//        session.beginTransaction();
//        // Creamos la Persona
//        Calendar calendar = new Calendar.Builder().build();
//        calendar.set(1993, Calendar.NOVEMBER, 25);
//        Persona2 persona2b = new Persona2(3,"Ana", 13, calendar.getTime());
//        // session.update(persona2b);
//        session.merge(persona2b);
//        session.getTransaction().commit();
        
        
        /* ELIMINAR DATOS */
//        session.beginTransaction();
//        // Creamos la Persona
//        Persona2 persona2c = new Persona2(1, "Ana", 13, calendar.getTime());
//        // session.delete(persona2c);
//        session.remove(persona2c);
//        session.getTransaction().commit();
                
        /* RECUPERAR DATOS */
        Query<Persona2> queryPersona2s = session.createQuery("FROM Persona2 ", Persona2.class);
        ArrayList<Persona2> persona2s = (ArrayList<Persona2>) queryPersona2s.getResultList();
        persona2s.forEach(persona2 -> System.out.println(persona2));
        
        
        Query<Persona2> query2Persona2s = session.createQuery("FROM Persona2 WHERE id = :id", Persona2.class);
        query2Persona2s.setParameter("id", 1);
        try {
	        Persona2 persona2Resultado = query2Persona2s.getSingleResult();
	        System.out.println(persona2Resultado);
        } catch (NoResultException ex) {
        	System.out.println("No se ha encontrado la persona2 con el ID indicado");
        }
        
        System.out.println( "Fin" );

    }
}
