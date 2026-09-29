package model.repository;

import model.entity.FichaAtendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FichaAtendimentoEntity extends JpaRepository<FichaAtendimento, Long> {

}
