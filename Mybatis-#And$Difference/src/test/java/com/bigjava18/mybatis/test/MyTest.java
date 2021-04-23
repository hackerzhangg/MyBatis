package com.bigjava18.mybatis.test;

import com.bigjava18.mybatis.mapper.BookMapper;
import com.bigjava18.mybatis.mapper.UserMapper;
import com.bigjava18.mybatis.model.Book;
import com.bigjava18.mybatis.model.User;
import javafx.beans.binding.ListBinding;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zgp
 * @Since 2021 -04 -22 15 :32
 * @Description
 */
public class MyTest {
    SqlSession sqlSession=null;

    @Before
    public void Before(){
        try {
            sqlSession=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 查询所有的用户
     */
    @Test
    public void getUseAll(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList = userMapper.queryAllUser();
        for (User user : userList){
            System.out.println(user);
        }
    }

    /**
     * 通过$查询用户
     * 日志打印sql：select * from user where id=1
     * 有可能出现sql注入
     */
    @Test
    public void getUserById(){
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=userMapper.getUserById(1);
        System.out.println(user);
    }

    /**
     * 按顺序查询所有用户
     */
    @Test
    public void getUserOrderBy(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.getUserOrderBy("id");
        for (User user : userList){
            System.out.println("user="+user);
        }
    }

    /**
     * 根据用户名称，模糊查询用户
     */
    @Test
    public void getUsernameByLike(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> userList=userMapper.getUsernameByLike("c");
        for (User user : userList){

            System.out.println(user);
        }
    }

    /**
     * 根据id更新用户名的，多参数配置
     */
    @Test
    public void updateUsernameById(){
        UserMapper sqlSessionMapper = sqlSession.getMapper(UserMapper.class);
        sqlSessionMapper.updateUsernameById(1,"tom");
        sqlSession.commit();
        System.out.println("更新成功");
    }

    /**
     * 添加用户1 分析
     */
    @Test
    public void addUser1(){
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("xiaofang");
        user.setPassword("3434");
        Integer addUser=userMapper.addUser1(user);
        sqlSession.commit();
        System.out.println("addUser:"+addUser);
    }

    /**
     * 添加用户2 分析
     */
    @Test
    public void addUser2(){
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("xiaobin");
        user.setPassword("3434");
        Integer addUser=userMapper.addUser2(user);
        sqlSession.commit();
        System.out.println("addUser:"+addUser);
    }

    /**
     * 添加用户3 分析 使用HashMap
     */
    @Test
    public void addUser3(){
        UserMapper userMapper=sqlSession.getMapper(UserMapper.class);
        HashMap<String,String> stringMap=new HashMap<String, String>();
        stringMap.put("username","tom1");
        stringMap.put("password","5689");
        Integer addUser3 = userMapper.addUser3(stringMap);
        sqlSession.commit();
        System.out.println("addUser3:"+addUser3);
    }

    /**
     * 添加用户4 分析 主键回填
     */
    @Test
    public void addUser4(){
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        User user=new User();
        user.setUsername("Alberta");
        user.setPassword("9090");
        int retUser=userMapper.addUser4(user);
        sqlSession.commit();
        System.out.println("retUser:"+retUser);
        System.out.println("user="+user);
    }

    /**
     * 查询所有用户 分析 resultType返回map
     */
    @Test
    public void selectUser(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        List<HashMap<String,Object>> mapList=mapper.selectUser();
        for (HashMap<String,Object> map : mapList){
            System.out.println(map);
        }
    }

    /**
     * 查询用户总数
     */
    @Test
    public void getUserCount(){
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        Long userCount=mapper.getUserCount();
        System.out.println("userCount = " + userCount);
    }

    /**
     * 查询所有得书籍,当实体类book和数据库字段不一致时，
     * 查询数据可能对应不上，要做特殊处理，可以为sql语句设置别名，也可以使用resultMap来处理
     */
    @Test
    public void getAllBook(){
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        List<Book> bookList=bookMapper.getAllBooks();
        for (Book book : bookList) {
            System.out.println("book = " + book);
        }
    }

    @After
    public void After(){
        sqlSession.close();
    }
}
