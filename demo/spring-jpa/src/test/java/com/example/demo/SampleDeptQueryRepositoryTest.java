package com.example.demo;

import java.util.List;

import javax.persistence.EntityManager;

import com.example.demo.jpa.domain.models.DeptQuery;
import com.example.demo.jpa.domain.repositories.DeptQueryRepository;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@DataJpaTest
public class SampleDeptQueryRepositoryTest {

    private static final String ENTITY_MGR = "entityMgr";

    @Autowired
    private EntityManager testEntityManager;

    private DeptQueryRepository repositoryTest;

    private static final Logger logger = LoggerFactory.getLogger(SampleDeptQueryRepositoryTest.class);

    @Test
    public void test0001() {

        createTestModule();

        List<DeptQuery> resultList = this.repositoryTest.findTest(1);

        logger.info("> 件数: {}", resultList.size());

    }

    private void createTestModule() {

        this.repositoryTest = new DeptQueryRepository();

        try {

            Field field = this.repositoryTest.getClass().getDeclaredField(ENTITY_MGR);
            field.setAccessible(true);
            field.set(this.repositoryTest, this.testEntityManager);

        } catch (NoSuchFieldException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (SecurityException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
