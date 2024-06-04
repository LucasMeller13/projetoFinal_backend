package projetoFinal.atendimentoMedico.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.models.Medico;

import java.util.Optional;
import java.util.UUID;

public interface MedicoRepository extends JpaRepository<Medico, UUID> {
    Optional<Medico> findByCpf(String cpf);
    Optional<Medico> findByCrm(String crm);
}
