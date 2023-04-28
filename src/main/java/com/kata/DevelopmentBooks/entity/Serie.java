package com.kata.DevelopmentBooks.entity;

import java.util.List;

import com.kata.DevelopmentBooks.enums.DiscountCode;

import io.micrometer.common.lang.Nullable;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name="serie")
public class Serie {
    
    @Id
    String id;
    String name;
    DiscountCode discountCode;

    @OneToMany(mappedBy = "serie", cascade = CascadeType.ALL)
    private List<Book> books;
}
