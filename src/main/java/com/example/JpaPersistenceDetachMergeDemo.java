package com.example;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.Date;

public class JpaPersistenceDetachMergeDemo {

    public static void main(String[] args) {

        Employee employee1 = new Employee();
        employee1.setName("New Employee");
        employee1.setSsn("76543");
        employee1.setDob(new Date());
        employee1.setAge(25);
        employee1.setType(EmployeeType.FULL_TIME);

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("myApp");
        EntityManager entityManager = entityManagerFactory.createEntityManager();
        EntityTransaction transaction = entityManager.getTransaction();
        transaction.begin();

        entityManager.persist(employee1);

        employee1.setAge(45);
        entityManager.flush();
        entityManager.detach(employee1);
//        entityManager.clear();
        debugEmployee(employee1);

        Employee managedEmployee = entityManager.find(Employee.class, 1);

        managedEmployee.setAge(24);
        managedEmployee.setDob(null);

        entityManager.refresh(managedEmployee); // Any above change in the managedEmployee has lost here

//        fixEmployee(employee1);
//
//        entityManager.merge(employee1);

        transaction.commit();
        entityManager.close();
        entityManagerFactory.close();

    }

    private static void fixEmployee(Employee employee1) {
        employee1.setAge(50);
    }
    private static void debugEmployee(Employee employee1) {
        employee1.setAge(55);
        employee1.setSsn("99999");
    }
}
