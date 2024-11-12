package br.edu.infnet.eduardo.service;

import br.edu.infnet.eduardo.model.domain.Book;
import br.edu.infnet.eduardo.model.domain.Ebook;
import br.edu.infnet.eduardo.model.domain.PhysicalBook;
import br.edu.infnet.eduardo.model.dto.BookDto;
import br.edu.infnet.eduardo.model.repository.IBookRepository;
import br.edu.infnet.eduardo.model.repository.IEbookRepository;
import br.edu.infnet.eduardo.model.repository.IPhysicalBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BooksService {
    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private IPhysicalBookRepository physicalBookRepository;

    @Autowired
    private IEbookRepository ebooksRepository;


    public List<Book> GetAll()
    {
        return (List<Book>) bookRepository.findAll();
    }

    public List<Ebook> GetAllEbooks() {  return (List<Ebook>)ebooksRepository.findAll(); }

    public Iterable<PhysicalBook> GetAllPhysical()
    {
        return physicalBookRepository.findAll();
    }

    public Iterable<Book> BuscarPorNome(String nome)
    {
        return bookRepository.findByNameContaining(nome);
    }

    public Optional<Book> GetById(Integer id)
    {
        return bookRepository.findById(id);
    }

    public BookDto UpdateBook(Integer id, BookDto bookDto) {

        var bookDb = bookRepository.findById(id);

        if (bookDb.isEmpty())
        {
            return null;
        }

        var bookDbEntity = bookDb.get();

        bookDbEntity.setActive(bookDto.active);
        bookDbEntity.setAuthor(bookDto.author);
        bookDbEntity.setDescription(bookDto.description);
        bookDbEntity.setPrice(bookDto.price);
        bookDbEntity.setName(bookDto.name);

        bookRepository.save(bookDbEntity);

        return bookDto;
    }
}
