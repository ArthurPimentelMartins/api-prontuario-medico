package com.prontuario.api.model.dto;

import java.math.BigDecimal;

public record FichaRequestDTO(
        String identificacao,
        String pa,
        Integer fc,
        BigDecimal temperatura,
        String o2,
        String mecanismoLesao,
        String principaisLesoes,
        String evolucaoTransporte,
        String intervencoesRealizadas,
        String medicacoes
) {
}
