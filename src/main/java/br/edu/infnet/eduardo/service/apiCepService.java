package br.edu.infnet.eduardo.service;

import br.edu.infnet.eduardo.model.dto.ViaCepAddress;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import static org.springframework.http.MediaType.APPLICATION_JSON;

@Service
public class apiCepService {


    public ViaCepAddress GetAddressByCep(String cep)
    {
        RestClient defaultClient = RestClient.create();
        var response = defaultClient.get()
                .uri("https://viacep.com.br/ws/{cep}/json", cep)
                .accept(APPLICATION_JSON)
                .retrieve()
                .toEntity(ViaCepAddress.class);

        if (response.getStatusCode().is2xxSuccessful()){
            return response.getBody();
        } else {
            return null;
        }
    }
}
