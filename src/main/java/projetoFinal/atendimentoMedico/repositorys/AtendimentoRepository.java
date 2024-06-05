package projetoFinal.atendimentoMedico.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoFinal.atendimentoMedico.models.Atendimento;

import java.util.UUID;

public interface AtendimentoRepository extends JpaRepository<Atendimento, UUID> {
}
