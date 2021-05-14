package com.bigjava18.mybatis.mapper;

import com.bigjava18.mybatis.model.T_User;

import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -05 -14 15 :42
 * @Description
 */
public interface UserMapper {

    public List<T_User> getAllUserWithRole();
}
