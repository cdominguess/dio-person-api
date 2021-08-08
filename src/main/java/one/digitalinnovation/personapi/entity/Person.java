package one.digitalinnovation.personapi.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

/**
 * Explicando as annotations do projeto lombok abaixo, para fixar o aprendizado:
 * - @Data: Cria em tempo de execução os getters e setters de todos os atributos da classe
 * - @Builder: Possibilita a criação de objetos sem necessidade de haver construtor definido na classe
 * - @AllArgsConstructor: Cria em tempo de execução um construtor com todos os atributos da classe
 * - @NoArgsContructor: Cria em tempo de execução um construtor vazio da classe
 */
@Entity
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    // Adicionando a propriedade "unique", o JPA irá inserir no banco um unique index para este campo
    @Column(nullable = false, unique = true)
    private String lastName;

    @Column(nullable = false)
    private String cpf;

    @Column(nullable = false)
    private LocalDate birthDate;

    @OneToMany(fetch = FetchType.LAZY, cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REMOVE})
    private List<Phone> phones;
}