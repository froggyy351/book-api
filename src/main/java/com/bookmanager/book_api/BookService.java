package com.bookmanager.book_api;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class BookService {
    private BookDAO dao;

    public BookService(
        BookDAO dao){
        this.dao = dao;
    }

    public List<Book> getAll(){
        return dao.findAll();
    }

    public Book create(Book book){
        dao.insert(book);
        return book;
    }

    public boolean delete(int id){
        return dao.deleteById(id);
    }

    public boolean update(int id, Book book){
        return dao.updateById(id, book);
    }
}
