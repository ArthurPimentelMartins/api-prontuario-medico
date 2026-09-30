package model.repository;

import model.entity.FichaAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface FichaAtendimentoEntity extends JpaRepository<FichaAtendimento, Long> {
    List<FichaAtendimento> findByIdentificacao(String identificacao);
}
