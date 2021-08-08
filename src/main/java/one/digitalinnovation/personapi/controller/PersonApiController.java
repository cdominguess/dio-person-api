package one.digitalinnovation.personapi.controller;

import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.ErrorMessage;
import one.digitalinnovation.personapi.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonApiController {

    private PersonRepository personRepository;

    /**
     * Usando a anotação @Autowired, o spring ao executar o projeto irá instanciar esta controller e fazer
     * automaticamente a injeção da dependência, no caso injetar uma instância do repository PersonRepository
     * @param personRepository
     */
    @Autowired
    public PersonApiController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @PostMapping
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person saved = personRepository.save(person);

        return new ResponseEntity(saved, HttpStatus.CREATED);
    }


}
