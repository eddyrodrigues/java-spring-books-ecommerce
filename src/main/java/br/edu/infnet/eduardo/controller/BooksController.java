package br.edu.infnet.eduardo.controller;

import br.edu.infnet.eduardo.model.domain.Book;
import br.edu.infnet.eduardo.model.domain.Customer;
import br.edu.infnet.eduardo.model.domain.Ebook;
import br.edu.infnet.eduardo.model.domain.PhysicalBook;
import br.edu.infnet.eduardo.model.dto.BookDto;
import br.edu.infnet.eduardo.model.repository.IBookRepository;
import br.edu.infnet.eduardo.model.repository.ICustomerRepository;
import br.edu.infnet.eduardo.service.BooksService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/books")
public class BooksController {

    @Autowired
    private BooksService booksService;



    @Autowired
    private IBookRepository _bookRepository;

    @GetMapping("/all-books")
    public ArrayList<Book> TestRoute()
    {
        return (ArrayList<Book>) booksService.GetAll();
    }

    @GetMapping("/physical-books")
    public Iterable<PhysicalBook> GetPhysicalBooks() { return booksService.GetAllPhysical(); }

    @GetMapping("/e-books")
    public Iterable<Ebook> GetEbooks() { return booksService.GetAllEbooks(); }
    @GetMapping("/{id}")
    public ResponseEntity<Book> GetEbooks(@PathVariable Integer id) {
        var book = booksService.GetById(id);

        if (book.isEmpty())
        {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(book.get());

    }

    @GetMapping(value = "/buscar/{nome}")
    public Iterable<Book> TestRoute2(@PathVariable String nome)
    {
        return booksService.BuscarPorNome(nome);
    }


    @PutMapping(value = "/{id}")
    public BookDto PutBookData(@PathVariable Integer id, @RequestBody BookDto bookDto)
    {
        return booksService.UpdateBook(id, bookDto);
    }

}
