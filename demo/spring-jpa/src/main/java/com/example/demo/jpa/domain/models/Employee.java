package com.example.demo.jpa.domain.models;

import java.io.Serializable;

import lombok.Data;
import javax.persistence.Entity;

import javax.persistence.Id;
import javax.persistence.Column;

@Data
@Entity(name = "employee")
public class Employee implements Serializable {

    private static final long serialVersionUID = 1l;

    // 社員ID
    @Id
    @Column(name = "employee_id")
    private long employeeId;

    // 氏名（姓）
    @Column(name = "firstname")
    private String firstname;

    // 氏名（名）
    @Column(name = "lastname")
    private String lastname;

    // 所属部署
    @Column(name = "department")
    private String department;

    // 入社日
    @Column(name = "hire_date")
    private int hireDate;

    // 連番
    @Column(name = "serial_no")
    private int serialNo;

}
