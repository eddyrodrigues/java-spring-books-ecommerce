package br.edu.infnet.eduardo.model.repository;

import br.edu.infnet.eduardo.model.domain.PhysicalBook;
import org.springframework.data.repository.CrudRepository;

public interface IPhysicalBookRepository extends CrudRepository<PhysicalBook, Integer> {
}
