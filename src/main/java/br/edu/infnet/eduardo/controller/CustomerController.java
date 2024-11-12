package br.edu.infnet.eduardo.controller;

import br.edu.infnet.eduardo.model.domain.Address;
import br.edu.infnet.eduardo.model.domain.Book;
import br.edu.infnet.eduardo.model.domain.Customer;
import br.edu.infnet.eduardo.model.dto.CustomerDto;
import br.edu.infnet.eduardo.model.repository.IBookRepository;
import br.edu.infnet.eduardo.model.repository.ICustomerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/customers")
public class CustomerController {
    @Autowired
    private ICustomerRepository customerRepository;

    @Autowired
    private IBookRepository bookRepository;



    @GetMapping
    public ResponseEntity<Iterable<CustomerDto>> CreateBook()
    {
        var customers = customerRepository.findAll();
        var customersDto = new ArrayList<CustomerDto>();
        for(Customer cust : customers)
        {
            customersDto.add(new CustomerDto(cust));
        }
        return ResponseEntity.ok(customersDto);
    }
    @GetMapping("{name}/books")
    public ResponseEntity<ArrayList<Book>> GetCustomerBooks(@PathVariable String name)
    {
        if (name.isBlank() || name.isEmpty())
        {
            return ResponseEntity.badRequest().body(null);
        }

        var customer = customerRepository.findByNameContaining(name).get(0);

        if (customer == null) {
            return ResponseEntity.badRequest().body(null);
        }

        var listOutput = new ArrayList<Book>((customer.getBoughtPhysicalBooks()));
        listOutput.addAll(customer.getBoughtEBooks());
        return ResponseEntity.ok(listOutput);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<CustomerDto> DeleteCustomerById(@PathVariable Integer id)
    {
        if (id <= 0)
        {
            return ResponseEntity.badRequest().build();
        }

        var customer = customerRepository.findById(id);

        if (customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var deleted = new CustomerDto(customer.get());
        var output = ResponseEntity.ok(deleted);
        customerRepository.deleteById(id);
        return output;
    }

    @GetMapping("{id}")
    public ResponseEntity<CustomerDto> GetCustomerById(@PathVariable Integer id)
    {
        if (id <= 0)
        {
            return ResponseEntity.badRequest().build();
        }

        var customer = customerRepository.findById(id);

        if (customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var customerDto = new CustomerDto(customer.get());
        return ResponseEntity.ok(customerDto);
    }

    @PutMapping("{customerId}")
    public ResponseEntity<String> PutCustomerById(@Valid @RequestBody CustomerDto customerDto, @PathVariable Integer customerId)
    {
        if (customerId != customerDto.Id)
        {
            return ResponseEntity.badRequest().build();
        }
        var customer = customerRepository.findById(customerDto.Id);

        if (customer.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        var editableCustomer = customer.get();

        editableCustomer.setName(customerDto.name);
        var addr = editableCustomer.getAddress();
        addr.setEstado(customerDto.Address.getEstado());
        addr.setRua(customerDto.Address.getRua());

        customerRepository.save(editableCustomer);


        var customerDtoOut = new CustomerDto(editableCustomer );
        return ResponseEntity.noContent().build();
    }

    @PostMapping("")
    public ResponseEntity<String> PostCustomer(@Valid @RequestBody CustomerDto customerDto)
    {

        var customer = customerRepository.findById(customerDto.Id);

        var editableCustomer = new Customer();

        editableCustomer.setName(customerDto.name);
        var addr = new Address();
        addr.setEstado(customerDto.Address.getEstado());
        addr.setRua(customerDto.Address.getRua());
        editableCustomer.setAddress(addr);

        customerRepository.save(editableCustomer);

        return ResponseEntity.noContent().build();
    }
    @PostMapping("/{customerId}/comprar-livro/{bookId}")
    public ResponseEntity<String> ComprarLivro(@PathVariable Integer customerId, @PathVariable Integer bookId)
    {

        var customer = customerRepository.findById(customerId).orElse(null);

        if (customer == null)
        {
            return ResponseEntity.status(404).body("customer nao encontrado");
        }

        var book = bookRepository.findById(bookId).orElse(null);

        if (book == null)
        {
            return ResponseEntity.status(404).body("livro não encontrado");
        }

        customer.getBoughtBook().add(book);

        customerRepository.save(customer);

        return ResponseEntity.noContent().build();
    }

}
