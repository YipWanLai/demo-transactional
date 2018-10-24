package com.example.demo;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class BookServiceTest {

    @Autowired
    private BookRepository repo;

    @Autowired
    private BookService service;

    @After
    public void teardown() {
        repo.deleteAll();
    }

    @Test
    public void testTransactionalMethod() {
        try {
            service.transactionalMethod();
        } catch (Exception ex) {
            System.out.println("opss");
        }

        assert repo.findById("1").isPresent() == false;
        assert repo.findById("2").isPresent() == false;
    }

    @Test
    public void testNonTransactionalMethod() {
        try {
            service.nonTransactionMethod();
        } catch (Exception ex) {
            System.out.println("opss");
        }

        assert repo.findById("1").isPresent() == true;
        assert repo.findById("2").isPresent() == true;
    }

}
