package controller;

import model.repository.FichaAtendimentoRepository;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/fichas")
public class FichaController {

    private final FichaAtendimentoRepository repository;

    public FichaController(FichaAtendimentoRepository repository) {
        this.repository = repository;
    }


}
