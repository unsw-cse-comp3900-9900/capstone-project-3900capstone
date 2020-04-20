package com.project.service;

import com.project.mapper.BookMapper;
import com.project.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class BookServiceImpl implements BookService{

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Books> queryBooksList(int first, int second) {
        return bookMapper.queryBooksList(first, second);
    }

    @Override
    public List<Books> fuzzyQuery(String bookName, String author, String publisher, int first, int second) {
        return bookMapper.fuzzyQuery(bookName, author, publisher, first, second);
    }

    @Override
    public Books queryBooksById(int id) {
        return bookMapper.queryBooksById(id);
    }

    @Override
    public Books queryBooksByBookName(String bookName) {
        return bookMapper.queryBooksByBookName(bookName);
    }

    @Override
    public Integer addBook(Books book) {
        return bookMapper.addBook(book);
    }

    @Override
    public Integer updateBook(Books book) {
        return bookMapper.updateBook(book);
    }

    @Override
    public Integer deleteBook(int id) {
        return bookMapper.deleteBook(id);
    }

    @Override
    public List<Books> cartItems(int userId) {
        return bookMapper.cartItems(userId);
    }

    @Override
    public Books oneBook(int userId, int bookId) {
        return bookMapper.oneBook(userId, bookId);
    }

    @Override
    public Integer addToCart(int userId, int bookId) {
        return bookMapper.addToCart(userId, bookId);
    }

    @Override
    public Integer updateCart(int userId, int bookId, int numbers) {
        return bookMapper.updateCart(userId, bookId, numbers);
    }

    @Override
    public List<Books> queryBooksByAdminId(int adminId) {
        return bookMapper.queryBooksByAdminId(adminId);
    }

    @Override
    public Integer removeItem(int userId, int bookId) {
        return bookMapper.removeItem(userId, bookId);
    }

    @Override
    public Integer addAllBook(Books book) {
        return bookMapper.addAllBook(book);
    }

    @Override
    public Integer updateAllBook(Books book) {
        return bookMapper.updateAllBook(book);
    }

    @Override
    public Integer deleteAllBook(int id) {
        return bookMapper.deleteAllBook(id);
    }


    @Override
    public List<HashMap> queryCartByUserId(int id) {
        return bookMapper.queryCartByUserId(id);
    }

    @Override
    public Integer deleteCartById(int id) {
        return bookMapper.deleteCartById(id);
    }

    @Override
    public Integer updateStock(int bookCount, int bookId) {
        return bookMapper.updateStock(bookCount, bookId);
    }

    @Override
    public Integer updateCartStatus(int userId, int bookId) {
        return bookMapper.updateCartStatus(userId, bookId);
    }

    @Override
    public List<HashMap> queryBookViewTime() {
        return bookMapper.queryBookViewTime();
    }

    @Override
    public List<HashMap> queryBookSold() {
        return bookMapper.queryBookSold();
    }

    @Override
    public Integer updateClickTime(Integer bookId) {
        return bookMapper.updateClickTime(bookId);
    }

    @Override
    public Books recommendation(String department , int first, int second) {
        return bookMapper.recommendation(department, first, second);
    }

    @Override
    public Integer queryCartItem(int userId, int bookId) {
        return bookMapper.queryCartItem(userId, bookId);
    }
}
