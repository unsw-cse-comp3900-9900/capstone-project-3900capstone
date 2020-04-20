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

    List<Books> queryBooksByAdminId(int adminId);

    Books queryBooksByBookName(String bookName);

    Integer addBook(Books book);

    Integer updateBook(Books book);

    Integer deleteBook(int id);

    List<Books> cartItems(int userId);

    Books oneBook(int userId, int bookId);

    Integer addToCart(int userId, int bookId);

    Integer updateCart(int userId, int bookId, int numbers);

    Integer removeItem(int userId, int bookId);

    Integer addAllBook(Books book);

    Integer updateAllBook(Books book);

    Integer deleteAllBook(int id);

    List<HashMap> queryCartByUserId(int id);

    Integer deleteCartById(int id);

    Integer updateCartStatus(int userId, int bookId);

    Integer updateStock(int bookCounts, int bookId);

    List<HashMap> queryBookViewTime();

    List<HashMap> queryBookSold();

    Integer updateClickTime(Integer bookId);

    Books recommendation(String department, int first, int second);

    Integer queryCartItem(int userId, int bookId);
}
