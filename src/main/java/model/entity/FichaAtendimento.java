package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class FichaAtendimento {

    @Id
    private String identificacao;
    private String PA;
    private Integer FC;
    private BigDecimal temperatura;
    private String o2;
}
