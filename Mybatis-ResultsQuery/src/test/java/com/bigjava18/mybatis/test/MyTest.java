package com.bigjava18.mybatis.test;

import com.bigjava18.mybatis.mapper.ArticleMapper;
import com.bigjava18.mybatis.mapper.UserMapper;
import com.bigjava18.mybatis.model.Article;
import com.bigjava18.mybatis.model.T_User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -05 -07 17 :38
 * @Description
 */
public class MyTest {

    SqlSession sqlSession;
    ArticleMapper articleMapper;
    UserMapper userMapper;

    @Before
    public void before(){
        try {
            sqlSession=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
            articleMapper = sqlSession.getMapper(ArticleMapper.class);
            userMapper = sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getArticleById1(){
        Article article = articleMapper.getArticleById2(1);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById2(){
        Article article = articleMapper.getArticleById2(1);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById3(){
        Article article = articleMapper.getArticleById3(1);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById4(){
        Article article = articleMapper.getArticleById4(1);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById5(){
        Article article = articleMapper.getArticleById5(1);
        System.out.println("article = " + article);
    }

    @Test
    public void getArticleById6(){
        Article article=articleMapper.getArticleById6(1);
        System.out.println("article = " + article);
    }

    @Test
    public void getAllUserWithRole(){
        List<T_User> allUserWithRole = userMapper.getAllUserWithRole();
        for (T_User t_user : allUserWithRole){
            System.out.println("t_user = " + t_user);
        }
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
