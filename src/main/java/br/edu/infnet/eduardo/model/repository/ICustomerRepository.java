package br.edu.infnet.eduardo.model.repository;

import br.edu.infnet.eduardo.model.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ICustomerRepository extends CrudRepository<Customer, Integer> {
    public ArrayList<Customer> findByNameContaining (String name);
}
