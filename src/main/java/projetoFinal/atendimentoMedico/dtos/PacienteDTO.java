package projetoFinal.atendimentoMedico.dtos;

import java.util.UUID;

public record PacienteDTO(
        UUID id,
        String nome,
        Integer idade,
        String genero,
        String cep,
        String cpf,
        String alergias,
        String tiposanguineo,
        String telefone,
        String email
) {
}
