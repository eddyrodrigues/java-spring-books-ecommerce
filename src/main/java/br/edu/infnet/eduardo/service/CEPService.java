package br.edu.infnet.eduardo.service;

import br.edu.infnet.eduardo.model.dto.ViaCepAddress;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@FeignClient(contextId = "cepClient", name = "tee", url = "https://viacep.com.br/ws")
//public interface CEPService {
//
//    @RequestMapping(method = RequestMethod.GET, value = "/{cep}/json", produces = "application/json")
//    public ViaCepAddress GetAddressByCep(@PathVariable("cep") String cep);
//
//}