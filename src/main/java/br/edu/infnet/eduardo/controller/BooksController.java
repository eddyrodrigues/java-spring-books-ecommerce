package br.edu.infnet.eduardo.controller;

import br.edu.infnet.eduardo.model.domain.Book;
import br.edu.infnet.eduardo.service.BooksService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class BooksController {

    @Autowired
    private BooksService booksService;

    @GetMapping("/books")
    public ArrayList<Book> TestRoute()
    {
        return booksService.GetAll();
    }
}
