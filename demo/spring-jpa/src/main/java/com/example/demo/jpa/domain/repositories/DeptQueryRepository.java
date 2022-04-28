package com.example.demo.jpa.domain.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.demo.jpa.domain.models.DeptQuery;

import org.springframework.stereotype.Repository;
import com.example.demo.jpa.common.constants.QueryName;

@Repository
public class DeptQueryRepository {

    @PersistenceContext
    EntityManager entityMgr;

    public List<DeptQuery> findTest(long id) {

        return this.entityMgr.createNamedQuery(QueryName.GET_DEPT, DeptQuery.class)
                .setParameter("paramId", id)
                .getResultList();

    }

}
