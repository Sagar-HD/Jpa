package com.sagar.runner;

import com.sagar.entity.Course;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

public class CourseRunner {
    public static void main(String[] args) {
        EntityTransaction tx=null;
        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("xworkz");
            EntityManager em= emf.createEntityManager();

        ){
            tx =em.getTransaction();
            tx.begin();
            Course course=new Course();
            course.setCourseName("java");
            course.setPrice(2000);
            em.persist(course);

            tx.commit();
            System.out.println("data saved");
        }
        catch (Exception e){

            tx.rollback();
            System.out.println("data rollbacked");

        }
    }
}
