package one.digitalinnovation.personapi.controller;

import lombok.AllArgsConstructor;
import one.digitalinnovation.personapi.dto.PersonRequest;
import one.digitalinnovation.personapi.service.PersonApiService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Usando a anotação @AllArgsConstructor(onConstructor = @__(@Autowired)), o spring ao executar o projeto irá instanciar
 * esta controller e fazer automaticamente a injeção de dependência para qualquer atributo que seja algum objeto
 */
@RestController
@RequestMapping("/api/v1/people")
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class PersonApiController {

    private PersonApiService personApiService;

    @PostMapping
    public ResponseEntity createPerson(@RequestBody @Valid PersonRequest person) {
        return personApiService.createPerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity updatePerson(@PathVariable Long id, @RequestBody @Valid PersonRequest person) {
        return personApiService.updatePerson(id, person);
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity deletePerson(@PathVariable Long id) {
        return personApiService.deletePerson(id);
    }

    @GetMapping
    public ResponseEntity listPeople() {
        return personApiService.listPeople();
    }

    @GetMapping("/{id}")
    public ResponseEntity listPersonById(@PathVariable Long id) {
        return personApiService.listPersonById(id);
    }
}