package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class JpaStarterRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

        EmailGroup emailGroup = entityManager.find(EmailGroup.class, 7);
        System.out.println("Got email group. Now accessing members");
        System.out.println(emailGroup.getMembers());


    }
}









//    public static void main(String[] args) {
//
//
//        Employee employee = entityManager.find(Employee.class, 1);
//        System.out.println("********************************* Fetched Employee");
//        System.out.println(employee.getName());
//
//        // till the above line of code there is no join operation done
//        // -> its running the simple query : select name from employee_data where id = 1; that's it..!!
//        // -> this is because we set the property of the 1-1 relationship as : @OneToOne(fetch = "FetchType.LAZY")
//        // -> default is EAGER
//        // -> this means when we need that property then only we get the data from DB
//
//        System.out.println("********************************* Accessed Card");
//        System.out.println(employee.getCard());

//        PayStub payStub = entityManager.find(PayStub.class, 5);
//        System.out.println(payStub.getEmployee());

        // another step

//        System.out.println("************ Before Fetching Employee");
//        Employee employee = entityManager.find(Employee.class, 1);
//        System.out.println("************ Before Accessing Paystubs");
//        System.out.println(employee.getPayStubs());

//    }