package com.bigjava18.mybatis.mapper;

import com.bigjava18.mybatis.model.Book;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author zgp
 * @Since 2021 -04 -23 14 :12
 * @Description
 */
public interface BookMapper {

    List<Book> getAllBook();

    List<Book> getAllBookPage(@Param("start") Integer start, @Param("page") Integer page);

    List<Book> getBookNameOrAuthor(Book book);
    List<Book> getBookNameOrAuthor1(Book book);

    Integer updateBook(Book book);
    Integer updateBook1(Book book);

    List<Book> getBooksByIds(@Param("ids") List<Integer> ids);

    /**
     * 使用foreach批量插入数据
     * @param bookList
     * @return
     */
    Integer batchBooks(@Param("bookList") List<Book> bookList);

    /**
     * 使用foreach批量update数据
     * @param map
     * @param id
     * @return
     */
    Integer updateBook2(@Param("map") Map<String,Object> map, @Param("id") Integer id);

    List<Book> getBooksByAuthorFirstName(String author);
}
