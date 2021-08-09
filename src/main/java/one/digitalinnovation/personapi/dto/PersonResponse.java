package one.digitalinnovation.personapi.dto;

import lombok.Builder;
import lombok.Data;
import one.digitalinnovation.personapi.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@Data
@Builder
public class PersonResponse {
    public ResponseEntity<Person> displayPerson(Person objPerson) {
        return new ResponseEntity<>(objPerson, HttpStatus.CREATED);
    }
}
