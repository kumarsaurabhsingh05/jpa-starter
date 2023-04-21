package com.example;

import javax.persistence.*;
import java.util.List;

import static java.lang.System.out;

public class JpaJPQLExample {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();

//        TypedQuery<Employee> query1 = entityManager.createQuery(
////                "select e from Employee e where e.age between 20 and 25", // <- e.g.
////                "select e from Employee e where e.card.isActive = false", // <- e.g.
//                "select e from Employee e",
//                Employee.class
//        );
//        List<Employee> resultList1 = query1.getResultList();
//        resultList1.forEach(System.out::println);

//        TypedQuery<Object[]> query2 = entityManager.createQuery(
//                "select e.name, e.card.issuedDate from Employee e",
//                Object[].class
//        );
//
//        List<Object[]> resultList2 =  query2.getResultList();
//        resultList2.forEach(e -> System.out.println(e[0] + " " + e[1]));

        // Avoiding SQL injection with JPQL parameters

//        int minAge = 20;
//        TypedQuery<Employee> query3 = entityManager.createQuery(
//                "select e from Employee e where e.age > :minAge",
//                Employee.class
//        );
//
//        query3.setParameter("minAge", minAge);

        // @NamedQuery - 1

        TypedQuery<Employee>  query4 = entityManager.createNamedQuery("emp name and age asc", Employee.class);
        query4.setParameter("age", 20);

        List<Employee> resultList4 =  query4.getResultList();
        resultList4.forEach(out::println);

        // @NamedQuery - 2

        TypedQuery<Employee>  query5 = entityManager.createNamedQuery("emp name desc", Employee.class);

        List<Employee> resultList5 =  query5.getResultList();
        resultList5.forEach(out::println);

        entityManager.clear();
        entityManagerFactory.close();
    }
}
