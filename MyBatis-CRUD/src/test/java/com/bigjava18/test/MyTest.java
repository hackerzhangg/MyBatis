package com.bigjava18.test;

import com.bigjava18.mybatis.common.SqlSessionFactoryUtils;
import com.bigjava18.mybatis.mapper.TeacherMapper;
import com.bigjava18.mybatis.model.Student;
import com.bigjava18.mybatis.model.Teacher;
import com.bigjava18.mybatis.model.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.List;
import java.util.UUID;

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

    /**
     * 添加用户
     */
    @Test
    public void addUser(){
        User user=new User();
        user.setUsername("小胖");
        user.setPassword("1212");

        int retInsert = sqlSession.insert("com.bigjava18.mybatis.mapper.UserMapper.addUser", user);
        System.out.println("retInsert:"+retInsert);
        sqlSession.commit();
    }

    /**
     * 添加所有学生
     */
    @Test
    public void queryStudent(){
        Student student=new Student();
        student.setId(UUID.randomUUID().toString());
        student.setUsername("121212");
        student.setPassword("121212");

        List<Student> studentList=sqlSession.selectList("com.bigjava18.mybatis.mapper.StudentMapper.queryStudent");
        for (Student student1 : studentList){

            System.out.println(student1.toString());
        }
    }

    /**
     * 添加学生1
     */
    @Test
    public void addStudent1(){
        Student student=new Student();
        //使用uuid为id赋值
        student.setId(UUID.randomUUID().toString());
        student.setUsername("121212");
        student.setPassword("121212");

        int insertResult=sqlSession.insert("com.bigjava18.mybatis.mapper.StudentMapper.addStudent1",student);
        System.out.println("insertResult:"+insertResult);
        sqlSession.commit();
    }

    /**
     * 添加学生2
     */
    @Test
    public void addStuden2(){
        Student student=new Student();
        //使用uuid为id赋值
        //student.setId(UUID.randomUUID().toString());
        student.setUsername("343434");
        student.setPassword("343434");

        int insertResult=sqlSession.insert("com.bigjava18.mybatis.mapper.StudentMapper.addStudent2",student);
        System.out.println("insertResult:"+insertResult);
        sqlSession.commit();
    }

    /**
     * 删除用户
     */
    @Test
    public void deleteUserById(){
        int deleteUserById = sqlSession.delete("com.bigjava18.mybatis.mapper.UserMapper.deleteUserById", 9);
        sqlSession.commit();
        System.out.println("deleteUserById:"+deleteUserById);
    }

    /**
     * 更新用户
     */
    @Test
    public void updateUserById(){
        User user=new User();
        user.setId(8);
        user.setPassword("9999");
        int updateUserById=sqlSession.update("com.bigjava18.mybatis.mapper.UserMapper.updateUserById",user);
        sqlSession.commit();
        System.out.println("updateUserById:"+updateUserById);
    }

    /**
     * 通过用户id查询数据
     */
    @Test
    public void selectUserById(){
        User user = sqlSession.selectOne("com.bigjava18.mybatis.mapper.UserMapper.selectUserById", 1);
        System.out.println("user"+user);
    }

    /**
     * 通过id查询teacher的信息
     */
    @Test
    public void selectTeacherById(){
        TeacherMapper teacherMapper = sqlSession.getMapper(TeacherMapper.class);
        List<TeacherMapper> teacherMappers = teacherMapper.selectTeacherById(14);
        System.out.println(teacherMappers);
    }

    /**
     * 添加用户Teacher
     */
    @Test
    public void addTeacher(){
        Teacher teacher=new Teacher();
        teacher.setId(1);
        teacher.setUsername("cat");
        teacher.setPassword("1212");
        teacher.setAddress("ShangHai");
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        mapper.addTeacher(teacher);
        sqlSession.commit();
        System.out.println("添加成功！");
    }

    /**
     * 通过id删除Teacher
     */
    @Test
    public void deleteTeacherById(){
        TeacherMapper mapper = sqlSession.getMapper(TeacherMapper.class);
        mapper.deleteTeacherById(13);
        sqlSession.commit();
        System.out.println("删除成功");
    }

    @After
    public void After(){
        sqlSession.close();
    }
}
