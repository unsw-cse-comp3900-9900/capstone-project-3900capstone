package com.project.mapper;

import com.project.pojo.Books;
import com.project.pojo.Books;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


import java.util.HashMap;
import java.util.List;

@Mapper
@Repository
public interface BookMapper {

    List<Books> queryBooksList(int first, int second);

    List<Books> fuzzyQuery(String bookName, String author, String publisher, int first, int second);

    Books queryBooksById(int id);

    Books queryBooksByBookName(String bookName);

    Integer addBook(Books book);

    Integer updateBook(Books book);

    Integer deleteBook(int id);

    List<HashMap> queryCartByUserId(int id);

    Integer deleteCartById(int id);

}
