package br.edu.infnet.eduardo.model.domain;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="TCustomer")
public class Customer {

    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;

    @NotBlank(message = "Name is mandatory")
    @Size(message = "Deve Ter o máximo", min = 0, max = 100)
    private String name;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name="idEndereco")
    private Address Address;

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idCustomer")
    private List<Book> BoughtBook = new ArrayList<>();

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idCustomer")
    private List<Ebook> BoughtEbooks = new ArrayList<>();

    @OneToMany(cascade = CascadeType.MERGE)
    @JoinColumn(name = "idCustomer")
    private List<PhysicalBook> BoughtPhysicalBooks = new ArrayList<>();

    public List<Ebook> getBoughtEBooks() {
        return BoughtEbooks;
    }

    public void setBoughtBooks(List<Ebook> boughtBooks) {
        BoughtEbooks = boughtBooks;
    }

    public br.edu.infnet.eduardo.model.domain.Address getAddress() {
        return Address;
    }

    public void setAddress(br.edu.infnet.eduardo.model.domain.Address address) {
        Address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<PhysicalBook> getBoughtPhysicalBooks() {
        return BoughtPhysicalBooks;
    }

    public void setBoughtPhysicalBooks(List<PhysicalBook> boughtPhysicalBooks) {
        BoughtPhysicalBooks = boughtPhysicalBooks;
    }

    public int getId() {
        return Id;
    }

    public List<Book> getBoughtBook() {
        return BoughtBook;
    }

    public void setBoughtBook(List<Book> boughtBook) {
        BoughtBook = boughtBook;
    }
}
