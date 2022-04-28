package com.example.demo.jpa.domain.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.jpa.domain.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    List<Employee> findByHireDate(Integer hireDate);

}
