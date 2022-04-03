package com.example.demo.application.domain.models;

import java.io.Serializable;
// import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "DEPT")
public class DeptModel implements Serializable {

    private static final long serialVersionUID = 1l;

    // ID
    @Id
    @Column(name = "id")
    private long id;

    // 氏名
    @Column(name = "name")
    private String name;

}
