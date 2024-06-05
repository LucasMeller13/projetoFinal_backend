package projetoFinal.atendimentoMedico.dtos;

import projetoFinal.atendimentoMedico.models.Medico;
import projetoFinal.atendimentoMedico.models.Paciente;

import java.util.Date;
import java.util.UUID;

public record AtendimentoDTO(
        UUID id,
        Medico medico,
        Paciente paciente,
        Date data,
        String descricao,
        String remedios,
        String sala,
        String status,
        Integer duracao
) {
}
