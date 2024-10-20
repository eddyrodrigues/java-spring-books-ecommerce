package br.edu.infnet.eduardo.model.domain;

import jdk.jshell.spi.ExecutionControl;

public abstract class Book {
    private String name;
    private String author;
    private String description;
    private Boolean active;
    protected float price;

    public float GetPrice() throws ExecutionControl.NotImplementedException {
        throw new ExecutionControl.NotImplementedException("GetPrice was not defined");
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
