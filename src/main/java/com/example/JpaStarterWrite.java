package com.example;

import javafx.beans.binding.ListExpression;
import org.hibernate.mapping.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Arrays;
import java.util.Date;

public class JpaStarterWrite {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("Bar Baz");
        employee1.setSsn("1234");
        employee1.setDob(new Date());
        employee1.setAge(21);
        employee1.setType(EmployeeType.CONTRACTOR);

        Employee employee2 = new Employee();
        employee2.setName("Foo Bar");
        employee2.setSsn("123");
        employee2.setDob(new Date());
        employee2.setAge(19);
        employee2.setType(EmployeeType.FULL_TIME);

        AccessCard card1 = new AccessCard();
        card1.setIssuedDate(new Date());
        card1.setActive(true);
        card1.setFirmwareVersion("1.0.0");
        card1.setOwner(employee1);
        employee1.setCard(card1);

        AccessCard card2 = new AccessCard();
        card2.setIssuedDate(new Date());
        card2.setActive(false);
        card2.setFirmwareVersion("1.2.0");
        card2.setOwner(employee2);
        employee2.setCard(card2);

        PayStub payStub1 = new PayStub();
        payStub1.setPayPeriodStart(new Date());
        payStub1.setPayPeriodEnd(new Date());
        payStub1.setEmployee(employee1);
        employee1.addPayStub(payStub1);
        payStub1.setSalary(1000);

        PayStub payStub2 = new PayStub();
        payStub2.setPayPeriodStart(new Date());
        payStub2.setPayPeriodEnd(new Date());
        payStub2.setEmployee(employee1);
        employee1.addPayStub(payStub2);
        payStub2.setSalary(2000);

        EmailGroup group1 = new EmailGroup();
        group1.setName("Company Watercooler Discussions");
        group1.addMember(employee1);
        group1.addMember(employee2);
        employee1.addEmailSubscription(group1);
        employee2.addEmailSubscription(group1);


        EmailGroup group2 = new EmailGroup();
        group2.setName("Engineering");
        employee1.addEmailSubscription(group2);
        group2.addMember(employee1);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee1);
        entityManager.persist(employee2);

        entityManager.persist(card1);
        entityManager.persist(card2);

        entityManager.persist(payStub1);
        entityManager.persist(payStub2);

        entityManager.persist(group1);
        entityManager.persist(group2);

        transaction.commit();
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
