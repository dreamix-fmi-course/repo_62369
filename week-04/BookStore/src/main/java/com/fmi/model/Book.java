package com.fmi.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Book {
    private String ISBN;
    private String title;
    private String author;
    private BigDecimal price;
    private String publisher;
    private LocalDate publishedYear;
}