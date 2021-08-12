package one.digitalinnovation.personapi.dto;

import lombok.Builder;
import lombok.Data;
import one.digitalinnovation.personapi.entity.Person;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * Classe criada para retornar objetos de pessoas ou listas,
 * e seus respectivos status conforme recurso que está fazendo uso esta classe
 */
@Data
@Builder
public class PersonResponse {
    public ResponseEntity displayPerson(PersonRequest objPerson, HttpStatus httpStatus) {
        return new ResponseEntity(objPerson, httpStatus);
    }

    public ResponseEntity listPerson(List<PersonRequest> arrPeople) {
        return new ResponseEntity(arrPeople, HttpStatus.OK);
    }
}
