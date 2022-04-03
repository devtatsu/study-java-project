package com.example.demo.application.domain.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.demo.application.domain.models.DeptQuery;
import org.springframework.stereotype.Repository;
import com.example.demo.application.common.constants.QueryName;

@Repository
public class DeptQueryRepository {

    @PersistenceContext
    EntityManager entityMgr;

    public List<DeptQuery> findTest(long id) {

        return this.entityMgr.createNamedQuery(QueryName.GET_DEPT, DeptQuery.class)
                .setParameter("id", id)
                .getResultList();

    }

}
