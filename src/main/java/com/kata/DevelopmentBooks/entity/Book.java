package com.kata.DevelopmentBooks.entity;

import java.math.BigDecimal;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
public class Book {
    @Id
    String ISBN;
    String name;    
    String Author;
    BigDecimal price;

    @ManyToOne(optional = false)
    @JoinColumn(name = "serie_id", nullable = false,
        referencedColumnName = "id")
    private Serie serie;
}
