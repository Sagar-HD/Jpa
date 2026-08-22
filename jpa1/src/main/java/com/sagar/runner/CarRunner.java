package com.sagar.runner;

import com.sagar.entity.Car;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;

import java.time.Year;

public class CarRunner {
    public static void main(String[] args) {
        EntityTransaction tx=null;
        try(EntityManagerFactory emf= Persistence.createEntityManagerFactory("xworkz");
            EntityManager em= emf.createEntityManager();

        ){
           tx =em.getTransaction();
            tx.begin();
            Car car=new Car();
            car.setCarName("audi");
            car.setModelYear(Year.of(2022));
            em.persist(car);

            tx.commit();
            System.out.println("data saved");
        }
        catch (Exception e){

            tx.rollback();
            System.out.println("data rollbacked");

        }
    }
}
