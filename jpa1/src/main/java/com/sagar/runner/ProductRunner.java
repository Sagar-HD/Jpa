package com.sagar.runner;

import com.sagar.entity.Product;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class ProductRunner {
    public static void main(String[] args) {
        EntityTransaction tx=null;
        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("xworkz");
            EntityManager em= emf.createEntityManager();

        ){
            tx =em.getTransaction();
            tx.begin();
            Product product=new Product();
            product.setProductName("shoes");
   em.persist(product);
            tx.commit();
            System.out.println("data saved");
        }
        catch (Exception e){

            tx.rollback();
            System.out.println("data rollbacked");

        }
    }
}
