package br.edu.infnet.eduardo.model.domain;

public class Ebook extends Book{
    private String visualizationLink;

    @Override
    public float GetPrice()
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
