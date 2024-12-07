package com.klef.jfsd.exam.service;

import com.klef.jfsd.exam.model.Book;
import com.klef.jfsd.exam.repository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {
    private static final Logger logger = LoggerFactory.getLogger(BookServiceImpl.class);

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book updateBook(int bookId, Book bookDetails) {
        Book book = bookRepository.findById(bookId)
            .orElseThrow(() -> new RuntimeException("Book not found with id: " + bookId));
        
        book.setTitle(bookDetails.getTitle());
        book.setAuthor(bookDetails.getAuthor());
        book.setGenre(bookDetails.getGenre());
        book.setPrice(bookDetails.getPrice());
        book.setPublishedYear(bookDetails.getPublishedYear());
        
        return bookRepository.save(book);
    }

    @Override
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> getBookById(int bookId) {
        return bookRepository.findById(bookId);
    }

    @Override
    @Transactional
    public void insertBooks() {
        try {
            // Manually insert some books
            Book book1 = new Book();
            book1.setTitle("Java Programming");
            book1.setAuthor("John Smith");
            book1.setGenre("Programming");
            book1.setPrice(49.99);
            book1.setPublishedYear(2022);

            Book book2 = new Book();
            book2.setTitle("Spring Boot Essentials");
            book2.setAuthor("Emily Brown");
            book2.setGenre("Technology");
            book2.setPrice(59.99);
            book2.setPublishedYear(2023);
            
            bookRepository.save(book1);
            bookRepository.save(book2);
            
            logger.info("Books inserted successfully");
        } catch (Exception e) {
            logger.error("Error inserting books", e);
            throw new RuntimeException("Failed to insert books", e);
        }
    }
}