package com.fmi.repository;

import com.fmi.model.Book;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Setter
public class StoreDB implements CRUD {
    private Map<String, Book> db;

    @Override
    public void add(Book book) {
//        String isbn = UUID.randomUUID().toString();
//        book.setISBN(isbn);
//        db.put(isbn, book);

        db.put(book.getISBN(), book);
    }

    @Override
    public Book update(Book book) {
        Book bookFromDB = this.getByKey(book.getISBN());

        if (!book.equals(bookFromDB)) {
            db.put(book.getISBN(), book);
        }
        return book;
    }

    @Override
    public void remove(String isbn) {
        db.remove(isbn);
    }

    @Override
    public Book getByKey(String isbn) {
        return db.get(isbn);
    }

    @Override
    public List<Book> getAll() {
//    return db.values().stream().collect(Collectors.toList());
        return new ArrayList<>(db.values());
    }

    @Override
    public void clear() {
        this.db.clear();
    }
}
