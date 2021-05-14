package com.bigjava18.mybatis.model;

/**
 * @Author zgp
 * @Since 2021 -05 -08 09 :49
 * @Description 文章-作者 构成一对一查询 每篇文章都可以对应一个作者
 */
public class Article {

    private Integer id;
    private String title;
    private String content;
    private Author author;

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", author=" + author +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
