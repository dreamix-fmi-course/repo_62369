package com.fmi.configuration;

import com.fmi.model.Book;
import com.fmi.repository.StoreDB;
import com.fmi.service.BookStore;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class AppConfiguration {
    @Bean
    @Primary
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Book defaultBook() {
        return new Book("0-0000-00-0000-0",
                "Default title",
                "Default author",
                new BigDecimal("0"),
                "Default publisher",
                LocalDate.ofEpochDay(0)
        );
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Book classicBook() {
        return new Book("1-2310-01-8713-1",
                "King Rat",
                "James Clavell",
                new BigDecimal("3389.90"),
                "Little, Brown and Company",
                LocalDate.ofYearDay(1968, 101)
        );
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Book mathBook() {
        return new Book("0-1290-31-2342-8",
                "102 Combinatorial Problems",
                "Titu Andrescu",
                new BigDecimal("28.90"),
                "Birkhauser",
                LocalDate.ofYearDay(2015, 114)
        );
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public StoreDB storeDB() {
        StoreDB storeDB = new StoreDB();
        storeDB.setDb(new ConcurrentHashMap<>());

        return storeDB;
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public BookStore bookStore() {
        BookStore bookStore = new BookStore();
        bookStore.setDbCrud(new StoreDB());

        return bookStore;
    }
}
