package br.edu.infnet.eduardo;

import br.edu.infnet.eduardo.model.domain.*;
import br.edu.infnet.eduardo.model.repository.IBookRepository;
import br.edu.infnet.eduardo.model.repository.ICustomerRepository;
import br.edu.infnet.eduardo.service.apiCepService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class Loader implements ApplicationRunner {

    @Autowired
    private IBookRepository bookRepository;

    @Autowired
    private apiCepService cepService;
    @Autowired
    private ICustomerRepository customerRepository;
    public void loadData()
    {

    }

    @Override
    public void run(ApplicationArguments args) throws Exception {

        bookRepository.deleteAll();

        var book1 = new Ebook();
        book1.setName("nome1");
        book1.setDescription("description1");
        book1.setActive(true);
        book1.setVisualizationLink("https://");
        book1.setPrice(1000f);
        bookRepository.save(book1);
        var book2 = new PhysicalBook();
        book2.setName("nome2");
        book2.setDescription("description2");
        book2.setActive(true);
        book2.setWeight("22kg ");
        book2.setPrice(1020f);
        bookRepository.save(book2);

        var add = cepService.GetAddressByCep("01001000");

        var addr1 = new Address();
        addr1.setRua(add.logradouro);
        addr1.setEstado(add.uf);
        addr1.setCep(add.cep);

        var customer = new Customer();
        customer.setAddress(addr1);
        customer.getBoughtEBooks().add(book1);
        customer.getBoughtPhysicalBooks().add(book2);
        customer.setName("nome usuario 1");
        customerRepository.save(customer);




        var add2 = cepService.GetAddressByCep("01001000");

        var addr2 = new Address();
        addr2.setRua(add2.logradouro);
        addr2.setEstado(add2.uf);
        addr2.setCep(add2.cep);

        var customer2 = new Customer();
        customer2.setAddress(addr2);
        customer2.getBoughtPhysicalBooks().add(book2);
        customer2.setName("nome usuario 2");

        customerRepository.save(customer2);
    }
}
