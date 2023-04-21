package com.example;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_DATA")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "employeename", length = 120)
    private String name;
    private int age;
    @Temporal(TemporalType.TIMESTAMP)
    private Date dob;

    @Enumerated(EnumType.STRING)
    private EmployeeType type;

    @Column(unique = true, length = 10, nullable = false, updatable = false)
    private String ssn;

    @Transient // this will not save this member variable into database as table column
    private String debugString;

    @OneToOne
    private AccessCard card;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.REMOVE) // By default, it's FetchType is Lazy in case of @OneToMany relationship
    private List<PayStub> payStubs = new ArrayList<>();

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "EMAIL_GROUP_SUBSCRIPTIONS",
        joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "SUBSCRIPTION_EMAIL_ID")
    )
    private List<EmailGroup> emailGroups = new ArrayList<>();

    public List<EmailGroup> getEmailGroups() {
        return emailGroups;
    }

    public void setEmailGroups(List<EmailGroup> emailGroups) {
        this.emailGroups = emailGroups;
    }

    public List<PayStub> getPayStubs() {
        return payStubs;
    }

    public void setPayStubs(List<PayStub> payStubs) {
        this.payStubs = payStubs;
    }

    public AccessCard getCard() {
        return card;
    }

    public void setCard(AccessCard card) {
        this.card = card;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public EmployeeType getType() {
        return type;
    }

    public void setType(EmployeeType type) {
        this.type = type;
    }

//    @Override
//    public String toString() {
//        return "Employee{" +
//                "id=" + id +
//                ", name='" + name + '\'' +
//                ", age=" + age +
//                ", dob=" + dob +
//                ", type=" + type +
//                ", ssn='" + ssn + '\'' +
//                ", card=" + card +
//                '}';
//    }

    public void addPayStub(PayStub payStub) {
        this.payStubs.add(payStub);
    }

    public void addEmailSubscription(EmailGroup group) {
        this.emailGroups.add(group);
    }
}
