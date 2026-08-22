package com.sagar.runner;

import com.sagar.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class BookRunner {
    public static void main(String[] args) {
        EntityTransaction tx=null;
        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("xworkz");
            EntityManager em= emf.createEntityManager();

        ){
            tx =em.getTransaction();
            tx.begin();
            Book book=new Book();
            book.setBookName("Mahapalayana");
            book.setAuthorName("sagar");
            book.setNoOfPages(100);
            em.persist(book);

            tx.commit();
            System.out.println("data saved");
        }
        catch (Exception e){

            tx.rollback();
            System.out.println("data roll backed");

        }
    }
}
