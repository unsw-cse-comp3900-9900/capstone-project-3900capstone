package com.project.service;

import com.project.pojo.Books;

import java.util.List;

public interface BookService {
    List<Books> queryBooksList();

    Books queryBooksById(int id);

    Books queryBooksByBookName(String bookName);

    Integer addBook(Books book);

    Integer updateBook(Books book);

    Integer deleteBook(int id);

}
