package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


@Component
public class BookService {

    @Autowired
    private BookRepository repo;

    public void nonTransactionMethod() {
        transactionalMethod();
    }

    @Transactional
    public void transactionalMethod() {
        Book book1 = Book.of("1", "1");
        repo.save(book1);

        Book book2 = Book.of("2", "2");
        repo.save(book2);

        if (true) {
            throw new IllegalStateException("simulated");
        }
    }


}
