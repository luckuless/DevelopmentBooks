package com.kata.DevelopmentBooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.DevelopmentBooks.entity.Book;

public interface BookRepository extends JpaRepository<Book, String> {
    
    List<Book> findByISBN(String iSBN);
}
