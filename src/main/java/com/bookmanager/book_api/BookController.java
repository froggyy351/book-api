package com.bookmanager.book_api;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.PutMapping;


@RestController
@RequestMapping("/books")
public class BookController {
    private BookService service;

    public BookController(BookService service){
        this.service = service;
    }

    @GetMapping
    public List<Book> getAll(){
        return service.getAll();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Book create(@Valid @RequestBody Book book){
        service.create(book);
        return book;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable int id){
        if(service.delete(id)){
            //204 No Content
            return ResponseEntity.noContent().build();
        } else {
            //404 Not Found 
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@PathVariable int id, @Valid @RequestBody Book book) {
        if(service.update(id, book)){
            //204 No Content
            return ResponseEntity.noContent().build();
        } else {
            //404 Not Found
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public Book getBook(@PathVariable int id){
        return service.getBook(id);
    }

}
