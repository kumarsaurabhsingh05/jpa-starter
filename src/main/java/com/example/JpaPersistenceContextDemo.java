package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaPersistenceContextDemo {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("New Employee");
        employee1.setSsn("76543");
        employee1.setDob(new Date());
        employee1.setAge(25);
        employee1.setType(EmployeeType.FULL_TIME);

        System.out.println("***************************** Created Employee Instance");

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        System.out.println("***************************** Starting the transaction");

        entityManager.persist(employee1);

        System.out.println("***************************** After persist() method called");

        Employee employeeFound = entityManager.find(Employee.class, 1);

        System.out.println(employee1);
        System.out.println(employeeFound);

        System.out.println(employee1 == employeeFound);

        transaction.commit();

        System.out.println("***************************** After transaction closed");


        entityManager.close();
        entityManagerFactory.close();

    }

    /* public static void main(String[] args) {

        // Create operation

//        Employee employee = new Employee();
//        employee.setName("Foo Bar");
//        employee.setSsn("123");
//        employee.setDob(new Date());
//        employee.setAge(19);
//        employee.setType(EmployeeType.FULL_TIME);
//
//        Employee employee1 = new Employee();
//        employee1.setName("Bar Baz");
//        employee1.setSsn("1234");
//        employee1.setDob(new Date());
//        employee1.setAge(21);
//        employee1.setType(EmployeeType.CONTRACTOR);
//
//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//
//        entityTransaction.begin();
//
//        entityManager.persist(employee);
//        entityManager.persist(employee1);
//
//        entityTransaction.commit();
//
//        entityManager.close();
//        entityManagerFactory.close();

        // Read Operation

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        Employee employee1 = entityManager.find(Employee.class, 1); // select * from EMPLOYEE_DATA where id = 1;
//        Employee employee2 = entityManager.find(Employee.class, 2);
//        System.out.println(employee1);
//        System.out.println(employee2);
//        Employee employee3 = entityManager.find(Employee.class, 3); // return null because it's not available in the db
//        System.out.println(employee3);

        // Update Operation

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        Employee employee1 = entityManager.find(Employee.class, 1); // select * from EMPLOYEE_DATA where id = 1;
//        System.out.println(employee1);
//        employee1.setAge(30);
//        employee1.setType(EmployeeType.CONTRACTOR);
//
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//        entityManager.persist(employee1);
//        entityTransaction.commit();
//        entityManager.close();
//        entityManagerFactory.close();



        // Delete Operation

//        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
//        EntityManager entityManager = entityManagerFactory.createEntityManager();
//
//        Employee employee1 = entityManager.find(Employee.class, 1); // select * from EMPLOYEE_DATA where id = 1;
//        System.out.println(employee1);
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        entityTransaction.begin();
//        entityManager.remove(employee1);
//        entityTransaction.commit();
//        entityManager.close();
//        entityManagerFactory.close();
    }

     */

}
