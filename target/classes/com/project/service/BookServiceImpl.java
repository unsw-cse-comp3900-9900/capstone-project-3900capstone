package com.project.service;

import com.project.mapper.BookMapper;
import com.project.pojo.Books;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class BookServiceImpl implements BookService{

    @Autowired
    BookMapper bookMapper;

    @Override
    public List<Books> queryBooksList() {
        return bookMapper.queryBooksList();
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
}
