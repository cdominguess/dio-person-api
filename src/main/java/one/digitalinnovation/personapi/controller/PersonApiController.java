package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.dto.PersonRequest;
import one.digitalinnovation.personapi.dto.PersonResponse;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.service.PersonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/v1/people")
public class PersonApiController {

    private PersonApiService personApiService;

    /**
     * Usando a anotação @Autowired, o spring ao executar o projeto irá instanciar esta controller e fazer
     * automaticamente a injeção da dependência, no caso injetar uma instância do service PersonApiService
     * @param personApiService
     */
    @Autowired
    public PersonApiController(PersonApiService personApiService) {
        this.personApiService = personApiService;
    }


    @PostMapping
    public ResponseEntity<PersonResponse> createPerson(@RequestBody @Valid PersonRequest person) {
        return personApiService.createPerson(person);
    }


}
