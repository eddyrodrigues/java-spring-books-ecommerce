package br.edu.infnet.eduardo.model.domain;


import jakarta.persistence.*;

@Entity
@Table(name = "TLivro")
public abstract class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;
    protected String name;
    protected String author;
    protected String description;
    protected Boolean active;
    protected Float price;

    public void setPrice(Float price) {
        this.price = price;
    }


    public Integer getId()
    {
        return id;
    }
    public float GetPrice() {
        return 0f;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
