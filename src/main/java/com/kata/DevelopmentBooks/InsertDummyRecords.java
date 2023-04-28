package com.kata.DevelopmentBooks;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import com.kata.DevelopmentBooks.entity.Book;
import com.kata.DevelopmentBooks.entity.Serie;
import com.kata.DevelopmentBooks.enums.DiscountCode;
import com.kata.DevelopmentBooks.repository.BookRepository;
import com.kata.DevelopmentBooks.repository.SerieRepository;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
@Profile("dev")
public class InsertDummyRecords implements ApplicationRunner{

    @Autowired
    SerieRepository serieRepository;

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        Serie serie = new Serie();
        serie.setId("developmentBooks");
        serie.setName("developmentBooks");
        serie.setDiscountCode(DiscountCode.DISCOUNT_SINGLE_DIFFERENT_BOOKS);

        Serie serie2 = new Serie();
        serie2.setId("Normal");
        serie2.setName("Normal");

        serieRepository.save(serie);
        serieRepository.save(serie2);


        log.info("serie count:{}", serieRepository.count());

        Book book1 = new Book();
        book1.setISBN("isbn1");
        book1.setName("Clean Code");
        book1.setPrice(BigDecimal.valueOf(50));
        book1.setSerie(serie);

        Book book2 = new Book();
        book2.setISBN("isbn2");
        book2.setName("The Clean Code");
        book2.setPrice(BigDecimal.valueOf(50));
        book2.setSerie(serie);

        Book book3 = new Book();
        book3.setISBN("isbn3");
        book3.setName("Clean Architecture");
        book3.setPrice(BigDecimal.valueOf(50));
        book3.setSerie(serie);

        Book book4 = new Book();
        book4.setISBN("isbn4");
        book4.setName("Test Driven Development by Example");
        book4.setPrice(BigDecimal.valueOf(50));
        book4.setSerie(serie);

        Book book5 = new Book();
        book5.setISBN("isbn5");
        book5.setName("Working Effectively With Legacy Code");
        book5.setPrice(BigDecimal.valueOf(50));
        book5.setSerie(serie);

        Book book6 = new Book();
        book6.setISBN("isbn6");
        book6.setName("Book without discount");
        book6.setPrice(BigDecimal.valueOf(50));
        book6.setSerie(serie2);

        bookRepository.save(book1);
        bookRepository.save(book2);
        bookRepository.save(book3);
        bookRepository.save(book4);
        bookRepository.save(book5);
        bookRepository.save(book6);


        log.info("book count:{}", bookRepository.count());



    }
    
}

