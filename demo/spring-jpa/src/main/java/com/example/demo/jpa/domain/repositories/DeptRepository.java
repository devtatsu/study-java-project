package com.example.demo.jpa.domain.repositories;

import com.example.demo.jpa.domain.models.DeptModel;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DeptRepository extends JpaRepository<DeptModel, String> {

}
