package br.edu.infnet.eduardo.model.dto;

import br.edu.infnet.eduardo.model.domain.Ebook;
import br.edu.infnet.eduardo.model.domain.PhysicalBook;

public class EbookDto
{
    public EbookDto(Ebook ebook)
    {
        id = ebook.getId();
        name = ebook.getName();
        author = ebook.getAuthor();
        description = ebook.getDescription();
        active = ebook.getActive();
        price = ebook.getPrice();
        visualizationLink = ebook.getVisualizationLink();
    }
    public EbookDto(){}

    public Integer id;
    public String name;
    public String author;
    public String description;
    public Boolean active;
    public Float price;
    public String visualizationLink;
}

