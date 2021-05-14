package com.bigjava18.mybatis.model;

/**
 * @Author zgp
 * @Since 2021 -05 -08 09 :49
 * @Description
 */
public class Author {

    private Integer id;
    private String name;
    private String age;

    @Override
    public String toString() {
        return "Author{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age='" + age + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}
