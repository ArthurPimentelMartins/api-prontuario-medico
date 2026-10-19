package com.prontuario.api.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/login")
public class LoginController {

    @PostMapping
    public ResponseEntity<String> fazerLogin(@RequestParam String codigoAcesso, HttpSession session) {

        String perfil = descobrirPerfil(codigoAcesso);

        if (perfil != null) {
            session.setAttribute("perfil", perfil);
            return ResponseEntity.ok("Login realizado com sucesso. Grupo: " + perfil);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Código de acesso inválido!");
        }
    }

    private String descobrirPerfil(String codigoAcesso) {

        return switch (codigoAcesso) {
            case "00" -> "Ambulância";
            case "01" -> "Telefonista";
            case "02" -> "Triagem";
            case "03" -> "UPA";
            case "04" -> "Regional";
            case "05" -> "Santa Casa";
            default -> null;
        };

    }
}

