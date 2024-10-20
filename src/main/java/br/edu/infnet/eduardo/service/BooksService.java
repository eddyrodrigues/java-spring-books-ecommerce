package br.edu.infnet.eduardo.service;

import br.edu.infnet.eduardo.model.domain.Book;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BooksService {
    public ArrayList<Book> GetAll()
    {
        return new ArrayList<Book>();
    }
}
