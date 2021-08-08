package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.repository.PersonApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonApiService {
    private PersonApiRepository personApiRepository;

    @Autowired
    public PersonApiService(PersonApiRepository personApiRepository) {
        this.personApiRepository = personApiRepository;
    }

    public ResponseEntity<Person> createPerson(Person person) {
        Person saved = personApiRepository.save(person);

        return new ResponseEntity(saved, HttpStatus.CREATED);
    }
}
