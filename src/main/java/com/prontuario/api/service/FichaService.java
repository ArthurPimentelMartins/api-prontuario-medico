package com.prontuario.api.service;

import com.prontuario.api.model.dto.FichaRequestDTO;
import org.springframework.transaction.annotation.Transactional;
import com.prontuario.api.model.entity.FichaAtendimento;
import com.prontuario.api.model.exception.ResourceNotFoundException;
import com.prontuario.api.model.repository.FichaAtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaService {

    private final FichaAtendimentoRepository repository;

    public FichaService(FichaAtendimentoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public FichaAtendimento salvarFicha(FichaRequestDTO dto, String grupoUsuario) {

        FichaAtendimento ficha = new FichaAtendimento();

        ficha.setIdentificacao(dto.identificacao());
        ficha.setPa(dto.pa());
        ficha.setFc(dto.fc());
        ficha.setTemperatura(dto.temperatura());
        ficha.setO2(dto.o2());
        ficha.setMecanismoLesao(dto.mecanismoLesao());
        ficha.setPrincipaisLesoes(dto.principaisLesoes());
        ficha.setEvolucaoTransporte(dto.evolucaoTransporte());
        ficha.setIntervencoesRealizadas(dto.intervencoesRealizadas());
        ficha.setMedicacoes(dto.medicacoes());

        ficha.setGrupoResponsavel(grupoUsuario);
        validarFicha(ficha);
        return repository.save(ficha);
    }

    @Transactional
    public FichaAtendimento atualizar(Long id, FichaRequestDTO dto) {
        FichaAtendimento fichaExistente = buscarPorId(id);

        fichaExistente.setIdentificacao(dto.identificacao());
        fichaExistente.setPa(dto.pa());
        fichaExistente.setFc(dto.fc());
        fichaExistente.setTemperatura(dto.temperatura());
        fichaExistente.setO2(dto.o2());
        fichaExistente.setMecanismoLesao(dto.mecanismoLesao());
        fichaExistente.setPrincipaisLesoes(dto.principaisLesoes());
        fichaExistente.setEvolucaoTransporte(dto.evolucaoTransporte());
        fichaExistente.setIntervencoesRealizadas(dto.intervencoesRealizadas());
        fichaExistente.setMedicacoes(dto.medicacoes());

        validarFicha(fichaExistente);
        return repository.save(fichaExistente);
    }

    @Transactional
    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Ficha com id " + id + " não encontrada");
        }
        repository.deleteById(id);
    }

    @Transactional(readOnly = true)
    public List<FichaAtendimento> listarTodos() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public FichaAtendimento buscarPorId(Long id) {
        return repository .findById(id).
                orElseThrow(() -> new ResourceNotFoundException(
                        "Ficha com id " + id + " não encontrada"
        ));
    }

    private void validarFicha(FichaAtendimento ficha) {

    }
}
