package projetoFinal.atendimentoMedico.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.util.Date;
import java.util.UUID;

public record AtendimentoDTO(
        UUID id,

        @NotNull(message = "Precisa de um idMedico")
        UUID idMedico,

        @NotNull(message = "Precisa de um idPaciente")
        UUID idPaciente,

        MedicoDTO medicoById,

        PacienteDTO pacienteById,

        @NotNull(message = "Precisa de uma data")
        Date data,

        @NotBlank(message = "Precisa de uma descrição")
        String descricao,

        String remedios,

        @NotBlank(message = "Precisa de uma sala")
        String sala,

        @NotBlank(message = "Precisa de um status")
        String status,

        Integer duracao
) {
}
