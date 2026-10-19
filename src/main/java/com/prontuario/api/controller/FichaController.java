package com.prontuario.api.controller;


import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import com.prontuario.api.model.dto.FichaRequestDTO;
import com.prontuario.api.model.entity.FichaAtendimento;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.prontuario.api.service.FichaService;

import java.util.List;

@RestController
@RequestMapping("/api/fichas")
public class FichaController {

    private final FichaService service;

    public FichaController(FichaService service) {
        this.service = service;
    }

    @GetMapping
    public List<FichaAtendimento> listar() {
        return service.listarTodos();
    }

    @PostMapping
    public FichaAtendimento salvar(@Valid @RequestBody FichaRequestDTO dto, HttpSession session) {
        String grupoLogado = (String) session.getAttribute("perfil");

        if (grupoLogado == null) {
            grupoLogado = "DESCONHECIDO";
        }
        return service.salvarFicha(dto, grupoLogado);
    }

    @PutMapping("/{id}")
    public FichaAtendimento atualizar(@PathVariable Long id, @Valid @RequestBody FichaRequestDTO dto) {
        return service.atualizar(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id) {
        service.deletar(id);
    }
}
