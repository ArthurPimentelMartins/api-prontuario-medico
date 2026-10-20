package com.prontuario.api.model.repository;

import com.prontuario.api.model.entity.FichaAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FichaAtendimentoRepository extends JpaRepository<FichaAtendimento, Long> {
    List<FichaAtendimento> findByIdentificacao(String identificacao);
}
