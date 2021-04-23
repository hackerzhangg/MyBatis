package com.bigjava18.mybatis.mapper;

import com.bigjava18.mybatis.model.User;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -04 -22 15 :27
 * @Description
 */
public interface UserMapper {
    List<User> queryAllUser();

    User getUserById(int id);

    List<User> getUserOrderBy(String id);

    List<User> getUsernameByLike(String username);

    /**
     * 多参数配置
     * @param id
     * @param username
     * Param:指定参数名称
     */
    void updateUsernameById(@Param("id") int id, @Param("username") String username);

    /**
     * 用户添加方法1
     * @param user
     * @return
     */
    Integer addUser1(User user);

    /**
     * 用户添加方法2
     * @param user
     * @return
     */
    Integer addUser2(@Param("user") User user);

    /**
     * 用户添加方法3
     * @param map
     * @return
     */
    Integer addUser3(HashMap<String,String> map);

    int addUser4(User user);

    List<HashMap<String, Object>> selectUser();

    Long getUserCount();
}
