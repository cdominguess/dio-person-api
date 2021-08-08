package one.digitalinnovation.personapi.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/people")
public class PersonApiController {

    /**
     * Retorna a listagem de pessoas cadastradas
     * @return
     */
    @GetMapping
    public String index() {
        return "Recurso inicial da API.";
    }


}
