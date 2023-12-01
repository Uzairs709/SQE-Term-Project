package com.jtspringproject.JtSpringProject.dao;

import com.jtspringproject.JtSpringProject.HibernateConfiguration;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class userDaoTest {
    @Autowired
    private userDao userD =new userDao();
    HibernateConfiguration conf = new HibernateConfiguration();
    @BeforeClass
    public void setUp() throws Exception {
        conf.dataSource();
        conf.transactionManager();
        conf.sessionFactory();
    }
    @Test
    public void validUserTest() {


        assertThat(userD.getUser("admin", "123")).isNotEqualTo(null);
    }

}