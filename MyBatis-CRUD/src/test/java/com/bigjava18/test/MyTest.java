package com.bigjava18.test;

import com.bigjava18.mybatis.common.SqlSessionFactoryUtils;
import com.bigjava18.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author zgp
 * @Since 2021 -04 -16 15 :21
 * @Description 测试Mybatis Crud
 */
public class MyTest {

    private SqlSession sqlSession;

    @Before
    public void Before(){
        sqlSession=SqlSessionFactoryUtils.getInstance().openSession();
    }

    @Test
    public void addUser(){
        User user=new User();
        user.setUsername("lili");
        user.setPassword("1212");

        int retInsert = sqlSession.insert("com.bigjava18.mybatis.mapper.UserMapper.addUser", user);

        System.out.println("retInsert:"+retInsert);
        sqlSession.commit();
    }

    @After
    public void After(){
        sqlSession.close();
    }
}
