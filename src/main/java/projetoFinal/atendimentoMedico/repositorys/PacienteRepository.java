package projetoFinal.atendimentoMedico.repositorys;

import org.springframework.data.jpa.repository.JpaRepository;
import projetoFinal.atendimentoMedico.models.Paciente;

import java.util.Optional;
import java.util.UUID;

public interface PacienteRepository extends JpaRepository<Paciente, UUID> {
    Optional<Paciente> findByCpf(String cpf);
}
