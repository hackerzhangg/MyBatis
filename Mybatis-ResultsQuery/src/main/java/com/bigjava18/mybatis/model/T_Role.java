package com.bigjava18.mybatis.model;

/**
 * @Author zgp
 * @Since 2021 -05 -14 15 :34
 * @Description
 */
public class T_Role {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "T_Role{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
