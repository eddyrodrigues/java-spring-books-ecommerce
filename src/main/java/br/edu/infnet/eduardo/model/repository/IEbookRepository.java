package br.edu.infnet.eduardo.model.repository;

import br.edu.infnet.eduardo.model.domain.Ebook;
import org.springframework.data.repository.CrudRepository;

public interface IEbookRepository extends CrudRepository<Ebook, Integer> {
}
