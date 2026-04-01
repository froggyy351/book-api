package com.bookmanager.book_api;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
@RequestMapping("/view/books")
public class BookViewController {
    private BookService service;

    public BookViewController(BookService service){
        this.service = service;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("books", service.getAll());
        return "books/list";
    }
    
}
