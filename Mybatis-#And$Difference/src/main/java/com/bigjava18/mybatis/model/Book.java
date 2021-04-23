package com.bigjava18.mybatis.model;

import org.apache.ibatis.annotations.Param;

/**
 * @Author zgp
 * @Since 2021 -04 -23 10 :06
 * @Description 书籍实体类
 */
public class Book {

    private Integer id;
    private String name;
    private String author;

    public Book(){
        System.out.println("--------book------");
    }

    public Book(@Param("id") Integer id, @Param("name") String name, @Param("author") String author){
        System.out.println("--------book3-------");
        this.id=id;
        this.name=name;
        this.author=author;
    }

    /*public Book(Integer id,String name, String author){
        System.out.println("--------book3-------");
        this.id=id;
        this.name=name;
        this.author=author;
    }*/

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}
