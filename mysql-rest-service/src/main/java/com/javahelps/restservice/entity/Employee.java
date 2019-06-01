package com.javahelps.restservice.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Employee {

    @Id
    private String firstname;
    private Integer salary;
    private String  lastname;
    private String email;

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String username) {
        this.firstname= username;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary= salary;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String name) {
        this.lastname = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" + "firstname='" + firstname+ '\'' + ", salary='" + salary + '\'' + ", lastname='" + lastname + '\''
                + ", email='" + email + '\'' + '}';
    }
}