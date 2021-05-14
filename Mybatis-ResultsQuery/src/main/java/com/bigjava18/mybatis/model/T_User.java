package com.bigjava18.mybatis.model;

import javax.management.relation.Role;
import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -05 -14 15 :33
 * @Description
 */
public class T_User {

    private int id;
    private String username;
    private String password;
    //一个用户可以对应多个角色
    private List<Role> roles;

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "T_User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roles=" + roles +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
