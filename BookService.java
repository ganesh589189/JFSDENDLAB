package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Book;
import java.util.List;
import java.util.Optional;

public interface BookService {
    Book updateBook(int bookId, Book bookDetails);
    List<Book> getAllBooks();
    Optional<Book> getBookById(int bookId);
    void insertBooks();
}