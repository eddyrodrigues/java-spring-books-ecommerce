package br.edu.infnet.eduardo.model.domain;

import jakarta.persistence.Entity;

@Entity
public class Ebook extends Book{
    protected String visualizationLink;

//    @Override
    public Float getPrice()
    {
        return this.price * 1.3f;
    }

    public String getVisualizationLink() {
        return visualizationLink;
    }

    public void setVisualizationLink(String visualizationLink) {
        this.visualizationLink = visualizationLink;
    }
}
