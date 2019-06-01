package com.javahelps.restservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.javahelps.restservice.entity.Employee;

@RepositoryRestResource(path = "/emp")
public interface EmpRepository extends JpaRepository<Employee, String> {
}


