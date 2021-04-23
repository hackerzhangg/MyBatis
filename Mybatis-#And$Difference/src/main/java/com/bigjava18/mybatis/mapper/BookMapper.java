package com.bigjava18.mybatis.mapper;

import com.bigjava18.mybatis.model.Book;

import java.util.List;

/**
 * @Author zgp
 * @Since 2021 -04 -23 10 :10
 * @Description
 */
public interface BookMapper {
    List<Book> getAllBooks();
}
