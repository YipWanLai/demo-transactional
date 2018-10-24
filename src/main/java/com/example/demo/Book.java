package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Book {
    @Id
    private String id;

    private String title;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public static Book of(String id, String title) {
        Book result = new Book();
        result.id = id;
        result.title = title;
        return result;
    }
}
