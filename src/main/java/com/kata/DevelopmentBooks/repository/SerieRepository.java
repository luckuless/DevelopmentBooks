package com.kata.DevelopmentBooks.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kata.DevelopmentBooks.entity.Serie;

public interface SerieRepository extends JpaRepository<Serie, String> {
    
    Optional<Serie> findById(String id);
}
