package com.bigjava18.mybatis.test;

import com.bigjava18.mybatis.common.SqlSessionFactoryUtils;
import com.bigjava18.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -04 -16 15 :05
 * @Description
 */
public class MybatisTest {

    public static void main(String[] args){
        SqlSessionFactory sqlSessionFactory= SqlSessionFactoryUtils.getInstance();
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<User> userList = sqlSession.selectList("com.bigjava18.mybatis.mapper.UserMapper.getUserAll");

        for(User user : userList){
            System.out.println(user.getId()+":"+user.getUsername()+":"+user.getUsername());
        }
    }
}
