package projetoFinal.atendimentoMedico.dtos;

import java.util.Date;
import java.util.UUID;

public record AtendimentoDTO(
        UUID id,
        UUID idMedico,
        UUID idPaciente,
        MedicoDTO medicoById,
        PacienteDTO pacienteById,
        Date data,
        String descricao,
        String remedios,
        String sala,
        String status,
        Integer duracao
) {
}
