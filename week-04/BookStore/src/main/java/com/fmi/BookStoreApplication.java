package com.fmi;

import com.fmi.model.Book;
import com.fmi.service.BookStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Predicate;

@SpringBootApplication
public class BookStoreApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BookStoreApplication.class, args);
    }

    @Autowired
    Book book;

    @Autowired
    @Qualifier("mathBook")
    Book mathBook;

    @Autowired
    @Qualifier("classicBook")
    Book classicBook;

    @Autowired
    BookStore bookStore;

    @Override
    public void run(String... args) {
        bookStore.add(book);
        bookStore.add(mathBook);
        bookStore.add(classicBook);
        bookStore.add(book);

        Predicate<Book> allBooksPredicate = b -> b.getPublishedYear().isBefore(LocalDate.now());
        List<Book> allBooks = bookStore.getAllBooksFilterBy(allBooksPredicate);

        System.out.println(allBooks.size());
    }
}
