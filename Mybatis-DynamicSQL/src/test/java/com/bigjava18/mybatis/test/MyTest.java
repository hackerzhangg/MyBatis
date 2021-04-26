package com.bigjava18.mybatis.test;

import com.bigjava18.mybatis.mapper.BookMapper;
import com.bigjava18.mybatis.model.Book;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.omg.PortableInterceptor.INACTIVE;

import java.io.IOException;
import java.util.*;

/**
 * @Author zgp
 * @Since 2021 -04 -23 14 :15
 * @Description
 */
public class MyTest {

    SqlSession sqlSession=null;
    BookMapper sqlSessionMapper;

    @Before
    public void before(){
        try {
            sqlSession=new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream("mybatis-config.xml")).openSession();
            sqlSessionMapper = sqlSession.getMapper(BookMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void getAllBook(){
        List<Book> bookList=sqlSessionMapper.getAllBook();
        for (Book book : bookList) {
            System.out.println("book = " + book);
        }
    }

    @Test
    public void getAllBookPage(){
        //当参数为null时查询全部数据
        //List<Book> bookList=sqlSessionMapper.getAllBookPage(null,null);
        List<Book> bookList=sqlSessionMapper.getAllBookPage(0,1);
        for (Book book : bookList){
            System.out.println("book = " + book);
        }
    }

    @Test
    public void getBookNameOrAuthor(){
        Book book=new Book();
        book.setAuthor("SpringBoot");
        book.setName("Alison");
        List<Book> bookList=sqlSessionMapper.getBookNameOrAuthor(book);
        for (Book book1 : bookList) {
            System.out.println("book1 = " + book1);
        }
    }

    @Test
    public void getBookNameOrAuthor1(){
        Book book=new Book();
        book.setAuthor("SpringBoot");
        book.setName("Alison");
        List<Book> bookList=sqlSessionMapper.getBookNameOrAuthor1(book);
        for (Book book1 : bookList) {
            System.out.println("book1 = " + book1);
        }
    }

    /**
     * 动态更新sql book
     */
    @Test
    public void updateBook(){
        Book book = new Book();
        book.setId(23);
        book.setName("spring");
        book.setAuthor("spring");
        Integer updateBookInt=sqlSessionMapper.updateBook(book);
        sqlSession.commit();
        System.out.println("updateBookInt:"+updateBookInt);
    }

    /**
     * 动态更新sql book 使用trim标签
     */
    @Test
    public void updateBook1(){
        Book book = new Book();
        book.setId(23);
        book.setName("spring");
        book.setAuthor("spring");
        Integer updateBookInt=sqlSessionMapper.updateBook1(book);
        sqlSession.commit();
        System.out.println("updateBookInt:"+updateBookInt);
    }

    /**
     * 使用foreach循环查询数据
     * select * from book where id in (21,23);
     */
    @Test
    public void getBooksByIds(){
        List<Integer> integerList=new ArrayList<Integer>();
        integerList.add(21);
        integerList.add(23);
        //方法一
        //List<Book> booksByIds = sqlSessionMapper.getBooksByIds(integerList);
        //方法二
        List<Book> booksByIds = sqlSessionMapper.getBooksByIds(Arrays.asList(21,23));
        for (Book book : booksByIds){
            System.out.println("book = " + book);
        }
    }

    /**
     * 使用foreach批量插入数据
     */
    @Test
    public void batchBooks(){
        List<Book> bookList=new ArrayList<Book>();
        Book book1=new Book();
        book1.setName("mali1");
        book1.setAuthor("1212");

        Book book2=new Book();
        book2.setName("mali2");
        book2.setAuthor("2323");

        //将数据添加到List集合中
        bookList.add(book1);
        bookList.add(book2);

        Integer integer = sqlSessionMapper.batchBooks(bookList);
        sqlSession.commit();
        System.out.println("integer:"+integer);
    }

    @Test
    public void updateBook2(){
        Map<String,Object> objectMap=new HashMap<String, Object>();
        objectMap.put("b_name","mali1");
        objectMap.put("author","mali1");
        Integer updateBook2 = sqlSessionMapper.updateBook2(objectMap, 25);
        sqlSession.commit();
        System.out.println("updateBook2 = " + updateBook2);
    }

    @Test
    public void getBooksByAuthorFirstName(){
        List<Book> firstName = sqlSessionMapper.getBooksByAuthorFirstName("mali");
        for (Book book : firstName) {
            System.out.println("book = " + book);
        }
    }

    @After
    public void after(){
        sqlSession.close();
    }
}
