package br.edu.infnet.eduardo.model.dto;

import br.edu.infnet.eduardo.model.domain.Customer;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CustomerDto {
    public CustomerDto()
    {}

    public CustomerDto(Customer customer)
    {
        Id = customer.getId();
        name = customer.getName();
        Address = customer.getAddress();
        for (int i = 0; i < customer.getBoughtEBooks().size(); i++) {
            BoughtEbooks.add(new EbookDto(customer.getBoughtEBooks().get(i)));
        }
        for (int i = 0; i < customer.getBoughtPhysicalBooks().size(); i++) {
            BoughtPhysicalBooks.add(new PhysicalBookDto(customer.getBoughtPhysicalBooks().get(i)));
        }
    }

    public int Id;

    @NotNull(message = "O nome não pode ser nulo")
    public String name;

    public br.edu.infnet.eduardo.model.domain.Address Address;

    public List<EbookDto> BoughtEbooks = new ArrayList<>();

    public List<PhysicalBookDto> BoughtPhysicalBooks = new ArrayList<>();

}

