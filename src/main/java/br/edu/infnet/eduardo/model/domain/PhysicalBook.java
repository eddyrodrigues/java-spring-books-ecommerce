package br.edu.infnet.eduardo.model.domain;

import jakarta.persistence.Entity;

@Entity
public class PhysicalBook extends Book {

    private String weight;
    @Override
    public float GetPrice()
    {
        return this.price * 1.5f;
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weight) {
        this.weight = weight;
    }
}
