package service;

import org.springframework.transaction.annotation.Transactional;
import model.entity.FichaAtendimento;
import model.exception.ResourceNotFoundException;
import model.repository.FichaAtendimentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FichaService {

    private final FichaAtendimentoRepository repository;

    public FichaService(FichaAtendimentoRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public FichaAtendimento salvarFicha(FichaAtendimento ficha, String grupoUsuario) {

        validarFicha(ficha);

        ficha.setGrupoResponsavel(grupoUsuario);

        return repository.save(ficha);
    }

    @Transactional
    public FichaAtendimento atualizar(Long id, FichaAtendimento fichaAtualizada) {
        FichaAtendimento fichaExistente = buscarPorId(id);

        validarFicha(fichaAtualizada);

        fichaExistente.setIdentificacao(fichaAtualizada.getIdentificacao());
        fichaExistente.setGrupoResponsavel(fichaAtualizada.getGrupoResponsavel());
        fichaExistente.setPa(fichaAtualizada.getPa());
        fichaExistente.setFc(fichaAtualizada.getFc());
        fichaExistente.setTemperatura(fichaAtualizada.getTemperatura());
        fichaExistente.setO2(fichaAtualizada.getO2());
        fichaExistente.setMecanismoLesao(fichaAtualizada.getMecanismoLesao());
        fichaExistente.setPrincipaisLesoes(fichaAtualizada.getPrincipaisLesoes());
        fichaExistente.setEvolucaoTransporte(fichaAtualizada.getEvolucaoTransporte());
        fichaExistente.setIntervencoesRealizadas(fichaAtualizada.getIntervencoesRealizadas());
        fichaExistente.setMedicacoes(fichaAtualizada.getMedicacoes());

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
