package com.sagar.runner;

import com.sagar.entity.User;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class UserRunner {
    public static void main(String[] args) {
        EntityTransaction tx=null;
        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("xworkz");
            EntityManager em= emf.createEntityManager();

        ){
            tx =em.getTransaction();
            tx.begin();
            User user=new User();
            user.setEmail("user@gmail.com");
            user.setPassword("test");
            user.setUsername("tester");
 em.persist(user);
            tx.commit();
            System.out.println("data saved");
        }
        catch (Exception e){

            tx.rollback();
            System.out.println("data rollbacked");

        }
    }
}
