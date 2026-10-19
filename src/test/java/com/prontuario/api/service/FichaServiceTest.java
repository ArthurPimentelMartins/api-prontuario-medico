package com.prontuario.api.service;

import com.prontuario.api.model.dto.FichaRequestDTO;
import com.prontuario.api.model.entity.FichaAtendimento;
import com.prontuario.api.model.exception.ResourceNotFoundException;
import com.prontuario.api.model.repository.FichaAtendimentoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FichaServiceTest {

    @Mock
    private FichaAtendimentoRepository repository;

    @InjectMocks
    private FichaService service;

    @Test
    void deveSalvarFichaComSucesso() {
        FichaRequestDTO dto = new FichaRequestDTO(
                "Paciente Teste", "120/80", 80, new BigDecimal("37.5"), "98%",
                "Queda", "Braço", "Estável", "Gelo", "Nenhuma"
        );
        String grupoUsuario = "Triagem";

        FichaAtendimento fichaSimulada = new FichaAtendimento();
        fichaSimulada.setId(1L);
        fichaSimulada.setIdentificacao("Paciente Teste");
        fichaSimulada.setGrupoResponsavel("Triagem");

        when(repository.save(any(FichaAtendimento.class))).thenReturn(fichaSimulada);

        // 2. EXECUTAR (Act): Chamamos o método do nosso Service de verdade!
        FichaAtendimento resultado = service.salvarFicha(dto, grupoUsuario);

        // 3. VALIDAR (Assert): O momento da verdade! O Service fez tudo certo?
        assertNotNull(resultado);
        assertEquals(1L, resultado.getId());
        assertEquals("Triagem", resultado.getGrupoResponsavel());
        assertEquals("Paciente Teste", resultado.getIdentificacao());
    }

    @Test
    void deveLancarExcecaoQuandoFichaNaoEncontrada() {
        // 1. PREPARAR (Arrange): Definimos um ID falso e ensinamos o Mockito a retornar "vazio"
        Long idInexistente = 99L;

        when(repository.findById(idInexistente)).thenReturn(java.util.Optional.empty());

        ResourceNotFoundException excecao = org.junit.jupiter.api.Assertions.assertThrows(
                ResourceNotFoundException.class,
                () -> service.buscarPorId(idInexistente)
        );

        org.junit.jupiter.api.Assertions.assertEquals("Ficha com id 99 não encontrada", excecao.getMessage());
    }
}