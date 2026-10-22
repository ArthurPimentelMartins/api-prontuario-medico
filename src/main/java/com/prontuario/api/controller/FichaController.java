package com.prontuario.api.controller;

import jakarta.validation.Valid;
import com.prontuario.api.model.dto.FichaRequestDTO;
import com.prontuario.api.model.entity.FichaAtendimento;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import com.prontuario.api.service.FichaService;

import java.util.List;

@RestController
@RequestMapping("/api/fichas")
@CrossOrigin(origins = "*")
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
    public FichaAtendimento salvar(@Valid @RequestBody FichaRequestDTO dto) {
        String grupo = dto.grupoResponsavel() != null ? dto.grupoResponsavel() : "DESCONHECIDO";
        return service.salvarFicha(dto, grupo);
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