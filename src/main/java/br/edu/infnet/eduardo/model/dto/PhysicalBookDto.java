package br.edu.infnet.eduardo.model.dto;

import br.edu.infnet.eduardo.model.domain.PhysicalBook;

public class PhysicalBookDto
{
    public PhysicalBookDto(PhysicalBook pbook)
    {
        id = pbook.getId();
        name = pbook.getName();
        author = pbook.getAuthor();
        description = pbook.getDescription();
        active = pbook.getActive();
        price = pbook.GetPrice();
        weight = pbook.getWeight();
    }
    public PhysicalBookDto() {}

    public Integer id;
    public String name;
    public String author;
    public String description;
    public Boolean active;
    public Float price;
    public String weight;
}
