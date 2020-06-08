package com.June2020.ProjectDemo.Entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@Table(name="employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
private Long id;


private String firstName;
private String lastName;
    @NotNull
private String emailAddress;
    @NotNull
private Long salary;


    //ID (Primary Key)
    //First Name
   // Last Name
   // Email Address
    //Salary


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Long getSalary() {
        return salary;
    }

    public void setSalary(Long salary) {
        this.salary = salary;
    }
/*
    public Employee(Long id, String firstName, String lastName, @NotNull String emailAddress, @NotNull Long salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.salary = salary;
    }*/

    public Employee(Long id, String firstName, String lastName, @NotNull String emailAddress, @NotNull Long salary, Set<Department> department) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
        this.salary = salary;
        this.department = department;
    }

    public Set<Department> getDepartment() {
        return department;
    }

    public void setDepartment(Set<Department> department) {
        this.department = department;
    }

    @OneToMany(mappedBy = "employee",cascade = CascadeType.ALL)
    Set<Department> department;
    public Employee() {
    }
}
