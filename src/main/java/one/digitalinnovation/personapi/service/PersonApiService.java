package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.PersonRequest;
import one.digitalinnovation.personapi.dto.PersonResponse;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.mapper.PersonApiMapper;
import one.digitalinnovation.personapi.repository.PersonApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PersonApiService {
    private PersonApiRepository personApiRepository;

    private final PersonApiMapper personApiMapper = PersonApiMapper.INSTANCE;

    @Autowired
    public PersonApiService(PersonApiRepository personApiRepository) {
        this.personApiRepository = personApiRepository;
    }

    public ResponseEntity createPerson(PersonRequest personRequest) {
        // Converte o objeto DTO em Entity
        Person objToSave = personApiMapper.toModel(personRequest);

        // Persiste este objeto e passa o mesmo como parâmetro para o método do PersonResponse
        Person objPersonSaved = personApiRepository.save(objToSave);

        return PersonResponse.builder().build().displayPerson(objPersonSaved);
    }
}
