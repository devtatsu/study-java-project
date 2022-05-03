package com.example.demo.jpa.domain.repositories;

import org.springframework.stereotype.Repository;

import java.util.List;

import com.example.demo.jpa.domain.models.Employee;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

    /**
     * 社員情報検索.
     * 
     * @param hireDate 入社日
     * @return 検索結果リスト
     * 
     */
    List<Employee> findByHireDate(Integer hireDate);

}
