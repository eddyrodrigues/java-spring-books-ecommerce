package br.edu.infnet.eduardo.model.domain;

import java.util.List;

public class Customer {
    private String Name;
    private Address Address;
    private List<Book> BoughtBooks;

    public List<Book> getBoughtBooks() {
        return BoughtBooks;
    }

    public void setBoughtBooks(List<Book> boughtBooks) {
        BoughtBooks = boughtBooks;
    }

    public br.edu.infnet.eduardo.model.domain.Address getAddress() {
        return Address;
    }

    public void setAddress(br.edu.infnet.eduardo.model.domain.Address address) {
        Address = address;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
