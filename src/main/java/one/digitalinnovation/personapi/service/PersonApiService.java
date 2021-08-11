package one.digitalinnovation.personapi.service;

import one.digitalinnovation.personapi.dto.PersonRequest;
import one.digitalinnovation.personapi.dto.PersonResponse;
import one.digitalinnovation.personapi.entity.Person;
import one.digitalinnovation.personapi.exception.ErrorMessage;
import one.digitalinnovation.personapi.mapper.PersonApiMapper;
import one.digitalinnovation.personapi.repository.PersonApiRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PersonApiService {
    private PersonApiRepository personApiRepository;

    private final PersonApiMapper personApiMapper = PersonApiMapper.INSTANCE;

    @Autowired
    public PersonApiService(PersonApiRepository personApiRepository) {
        this.personApiRepository = personApiRepository;
    }

    public ResponseEntity createPerson(PersonRequest personRequest) {
        // Converte o objeto DTO em Entity antes de persistir
        Person objToSave = personApiMapper.toModel(personRequest);

        // Tudo em um: persite o Person, converte para DTO e atribui numa variável que será enviada para exibição
        PersonRequest objToRequest = personApiMapper.toDTO(personApiRepository.save(objToSave));

        return PersonResponse.builder().build().displayPerson(objToRequest);
    }

    public ResponseEntity listPeople() {
        // Todos os métodos do repository retornam objetos Person
        List<Person> arrPeople = personApiRepository.findAll();

        // Porém a listagem deve ser feita com objetos tipo DTO PersonRequest, daí tem que fazer a conversão dos itens do List
        List<PersonRequest> newArrPeople = arrPeople.stream()
                .map((person) -> personApiMapper.toDTO(person))
                .collect(Collectors.toList());

        return PersonResponse.builder().build().listPerson(newArrPeople);
    }

    public ResponseEntity listPersonById(Long id) {
        /*
         * Para fixar aprendizado:
         *
         * Depois de quase três horas tentando fazer este método sozinho, e confuso do porquê do findById
         * retornar um optional com type parameter Person, ao assistir o vídeo o instrutor falou justamente isso, e que para retornar
         * o próprio objeto Person para o momento de converter em DTO, bastava chamar o método objPersonOptional.get() !!!!!
         * Concluindo, há coisas que o curso muito básico não mostra, nem a explicação resumida do instrutor no vídeo "Parte 9".
         *
         * Em uma busca mais aprofundada, achei em sites gringos pessoas com a mesma dúvida, então uma resposta
         * no fórum https://qastack.com.br/programming/24482117/when-use-getone-and-findone-methods-spring-data-jpa
         * constatei que posso usar o método getById, este sim retorna o objeto da entidade parametrizada no repository, e não um optional.
         */
        Person objPersonOptional = personApiRepository.getById(id);

        try {
            PersonRequest objPersonRequest = personApiMapper.toDTO(objPersonOptional);
            return PersonResponse.builder().build().displayPerson(objPersonRequest);
        } catch(Exception ex) {
            ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(), "Person ID " + id + " not exists.");

            /*
             * A maneira que achei de retornar um objeto personalizado que no response fosse exibido como JSON foi com
             * esta maneira de instanciar o objeto ResponseEntity, passando um objeto que será o JSON e um HttpStatus válido
             * Antes disso usava assim: return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Person ID " + id + " not exists.");
             */
            return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
        }
    }
}
