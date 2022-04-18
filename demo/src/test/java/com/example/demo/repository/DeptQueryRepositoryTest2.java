package com.example.demo.repository;

import java.util.List;
import com.example.demo.application.domain.models.DeptQuery;
import com.example.demo.application.domain.repositories.DeptQueryRepository;
import com.example.demo.repository.base.QueryBaseRepositoryTest;

import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import org.springframework.test.context.jdbc.Sql;

public class DeptQueryRepositoryTest2 extends QueryBaseRepositoryTest<DeptQueryRepository, DeptQueryRepositoryTest2> {

    @Override
    public void setProperty() {
        super.logCls = DeptQueryRepositoryTest2.class;
        super.repositoryTest = new DeptQueryRepository();
    }

    @Test
    @DisplayName("▼▼▼▼▼ test001 DisplayName ▼▼▼▼▼")
    @Sql(scripts = "/deptquery/setUpData.sql")
    public void test0001() {

        List<DeptQuery> resultList = this.repositoryTest.findTest(1);

        super.logger.info("> 件数: {}", resultList.size());

    }

}
