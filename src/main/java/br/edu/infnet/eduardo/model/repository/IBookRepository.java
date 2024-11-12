package br.edu.infnet.eduardo.model.repository;

import br.edu.infnet.eduardo.model.domain.Book;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBookRepository extends CrudRepository<Book, Integer> {
    public Iterable<Book> findByNameContaining(String nome);
}
