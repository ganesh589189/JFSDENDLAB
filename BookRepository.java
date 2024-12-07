package com.klef.jfsd.exam.repository;

import com.klef.jfsd.exam.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer> {
    // Additional custom query methods can be added here if needed
}