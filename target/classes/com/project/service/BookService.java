package com.project.service;

import com.project.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface BookService {
    List<Books> queryBooksList(int first, int second);

    List<Books> fuzzyQuery(@Param("bookName") String bookName, @Param("author") String author, @Param("publisher") String publisher, int first, int second);

    Books queryBooksById(int id);

    Books queryBooksByBookName(String bookName);

    Integer addBook(Books book);

    Integer updateBook(Books book);

    Integer deleteBook(int id);

    List<HashMap> queryCartByUserId(int id);

    Integer deleteCartById(int id);

}
