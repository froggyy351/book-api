package com.bookmanager.book_api;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookDAO dao;

    public BookService(
        BookDAO dao){
        this.dao = dao;
    }
}
