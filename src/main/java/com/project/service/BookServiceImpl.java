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
    public List<HashMap> queryCartByUserId(int id) {
        return bookMapper.queryCartByUserId(id);
    }

    @Override
    public Integer deleteCartById(int id) {
        return bookMapper.deleteCartById(id);
    }
}
