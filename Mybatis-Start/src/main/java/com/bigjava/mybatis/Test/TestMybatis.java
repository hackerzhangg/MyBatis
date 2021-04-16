package com.bigjava.mybatis.Test;

import com.bigjava.mybatis.common.SqlSessionFactoryUtils;
import com.bigjava.mybatis.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.util.List;

//import javax.annotation.Resource;

/**
 * @Author zgp
 * @Since 2021 -04 -15 16 :16
 * @Description
 */
public class TestMybatis {

    public static void main(String[] args) throws IOException {
        //SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml"));
        SqlSessionFactory factory= SqlSessionFactoryUtils.getInstance();

        SqlSession sqlSession = factory.openSession();
        List<User> userList = sqlSession.selectList("com.bigjava.mybatis.mapper.UserMapper.getUserAll");
        for (User user: userList){
            System.out.println(user.getId()+":"+user.getPassword()+":"+user.getUsername());
        }
    }
}
