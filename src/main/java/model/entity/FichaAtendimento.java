package model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.math.BigDecimal;

@Entity
public class FichaAtendimento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String identificacao;
    private String grupoResponsavel;
    private String pa;
    private Integer fc;
    private BigDecimal temperatura;
    private String o2;
    private String mecanismoLesao;
    private String principaisLesoes;
    private String evolucaoTransporte;
    private String intervencoesRealizadas;
    private String medicacoes;

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getIdentificacao() {
        return identificacao;
    }

    public void setIdentificacao(String identificacao) {
        this.identificacao = identificacao;
    }

    public String getGrupoResponsavel() {
        return grupoResponsavel;
    }

    public void setGrupoResponsavel(String grupoResponsavel) {
        this.grupoResponsavel = grupoResponsavel;
    }

    public String getPa() {
        return pa;
    }

    public void setPa(String pa) {
        this.pa = pa;
    }

    public Integer getFc() {
        return fc;
    }

    public void setFc(Integer fc) {
        this.fc = fc;
    }

    public BigDecimal getTemperatura() {
        return temperatura;
    }

    public void setTemperatura(BigDecimal temperatura) {
        this.temperatura = temperatura;
    }

    public String getO2() {
        return o2;
    }

    public void setO2(String o2) {
        this.o2 = o2;
    }

    public String getMecanismoLesao() {
        return mecanismoLesao;
    }

    public void setMecanismoLesao(String mecanismoLesao) {
        this.mecanismoLesao = mecanismoLesao;
    }

    public String getPrincipaisLesoes() {
        return principaisLesoes;
    }

    public void setPrincipaisLesoes(String principaisLesoes) {
        this.principaisLesoes = principaisLesoes;
    }

    public String getEvolucaoTransporte() {
        return evolucaoTransporte;
    }

    public void setEvolucaoTransporte(String evolucaoTransporte) {
        this.evolucaoTransporte = evolucaoTransporte;
    }

    public String getIntervencoesRealizadas() {
        return intervencoesRealizadas;
    }

    public void setIntervencoesRealizadas(String intervencoesRealizadas) {
        this.intervencoesRealizadas = intervencoesRealizadas;
    }

    public String getMedicacoes() {
        return medicacoes;
    }

    public void setMedicacoes(String medicacoes) {
        this.medicacoes = medicacoes;
    }
}
