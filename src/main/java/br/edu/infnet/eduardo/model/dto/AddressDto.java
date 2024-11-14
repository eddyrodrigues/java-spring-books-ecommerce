package br.edu.infnet.eduardo.model.dto;

import br.edu.infnet.eduardo.model.domain.Address;
import jakarta.validation.constraints.NotBlank;

public class AddressDto {

    public AddressDto() {}

    public AddressDto(Address address)
    {
        cep = address.getCep();
        rua = address.getRua();
        estado = address.getEstado();
    }
    @NotBlank(message = "É necessário informar o CEP")
    public String cep;
    public String rua;
    public String estado;
}