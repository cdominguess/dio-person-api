package one.digitalinnovation.personapi.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Objeto simples para definir mensagens de erro a ser retornado no tratamento de exceções
 */
@Data
@AllArgsConstructor
public class ErrorMessage {
    private Integer status;
    private String message;
}
