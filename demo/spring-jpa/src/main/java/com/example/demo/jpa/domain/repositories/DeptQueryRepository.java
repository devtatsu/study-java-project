package com.example.demo.jpa.domain.repositories;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import com.example.demo.jpa.domain.models.DeptQuery;

import org.springframework.stereotype.Repository;
import com.example.demo.jpa.common.constants.QueryName;

@Repository
public class DeptQueryRepository {

    /** EntityManager. */
    @PersistenceContext
    private EntityManager entityMgr;

    /**
     * 部門情報検索.
     * 
     * @param id 検索キー
     * @return 検索結果リスト
     * 
     */
    public List<DeptQuery> findTest(final long id) {

        // @formatter:off
        return this.entityMgr.createNamedQuery(
                                QueryName.GET_DEPT,
                    DeptQuery.class)
                            .setParameter("paramId", id).getResultList();
        // @formatter:on

    }

}
