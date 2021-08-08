package one.digitalinnovation.personapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.NoHandlerFoundException;

/**
 * Classe global para tratar com diversos tipos de exceções.
 * PARA FIXAR APRENDIZADO: A anotação @ControllerAdvice pelo que entendi faz com que os métodos anotados com
 * @ExceptionHandler dessa classe sejam invodados para exceções lançadas por qualquer controller da aplicação.
 */
@ControllerAdvice
public class GlobalExceptionGandler {

    /**
     * Método que será invocado quando uma Exception do tipo NoHandlerFoundException for lançada.
     * Criado para caso o usuário digitar um recurso não mapeado nas controllers da API.
     * Retorna um objeto JSON no body da aplicação.
     * @param ex
     * @return
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ErrorMessage> handleNotFound(NoHandlerFoundException ex) {
        String message = "HTTP " + ex.getHttpMethod() + " for " + ex.getRequestURL() + " is not supported.";
        ErrorMessage error = new ErrorMessage(HttpStatus.NOT_FOUND.value(), message);

        return new ResponseEntity<ErrorMessage>(error, HttpStatus.NOT_FOUND);
    }
}
