package com.bigjava18.mybatis.mapper;

import com.bigjava18.mybatis.model.Teacher;

import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -04 -22 14 :08
 * @Description
 */
public interface TeacherMapper {

    public List<TeacherMapper> selectTeacherById(int id);

    public void addTeacher(Teacher teacher);

    public void deleteTeacherById(int id);
}
