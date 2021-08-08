package one.digitalinnovation.personapi.repository;

import one.digitalinnovation.personapi.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Interface criada estendendo da JpaRepository, que implementa todos os métodos para manipular uma entidade.
 * Para estender corretamente, tem que passar Type parameters: 1 - a entidade; 2 - o tipo de dado do Id da entidade.
 */
public interface PersonRepository extends JpaRepository<Person, Long> {

}
