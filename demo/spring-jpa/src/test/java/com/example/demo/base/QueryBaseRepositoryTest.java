package com.example.demo.base;

import javax.persistence.EntityManager;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.Field;

@RunWith(SpringRunner.class)
@DataJpaTest
public abstract class QueryBaseRepositoryTest<T1, T2> {

    @Autowired
    private EntityManager testEntityManager;

    private static final String ENTITY_MGR = "entityMgr";

    protected T1 repositoryTest;
    protected Logger logger;
    protected String entityMgrName;
    protected Class<T2> logCls;
    private boolean sign;

    public abstract void setProperty();

    @Before
    public void setUp() {

        if (sign) {
            return;
        }

        setProperty();

        this.logger = LoggerFactory.getLogger(logCls);

        if (entityMgrName == null) {
            this.entityMgrName = ENTITY_MGR;
        }

        createTestModule();

        logger.info("■■■■■ START ■■■■■");

        sign = true;

    }

    @After
    public void endtMsg() {
        logger.info("■■■■■ END ■■■■■");
    }

    private void createTestModule() {

        try {

            Field field = this.repositoryTest.getClass().getDeclaredField(entityMgrName);
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
