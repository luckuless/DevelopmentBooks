package com.kata.DevelopmentBooks.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.DevelopmentBooks.entity.Serie;
import com.kata.DevelopmentBooks.enums.DiscountCode;

public interface SerieRepository extends JpaRepository<Serie, String> {
    
    Optional<Serie> findById(String id);

    List<Serie> findByDiscountCode(DiscountCode discountCode);
}
