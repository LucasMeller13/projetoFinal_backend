package projetoFinal.atendimentoMedico.mappers;

import org.springframework.stereotype.Component;
import projetoFinal.atendimentoMedico.dtos.PacienteDTO;
import projetoFinal.atendimentoMedico.dtos.PacienteDTO;
import projetoFinal.atendimentoMedico.models.Medico;
import projetoFinal.atendimentoMedico.models.Paciente;

@Component
public class PacienteMapper {
    public PacienteDTO toDTO(Paciente paciente){
        return new PacienteDTO(
                paciente.getId(),
                paciente.getNome(),
                paciente.getIdade(),
                paciente.getGenero(),
                paciente.getCep(),
                paciente.getCpf(),
                paciente.getAlergias(),
                paciente.getTiposanguineo(),
                paciente.getTelefone(),
                paciente.getEmail()
        );
    }

    public Paciente toEntity(PacienteDTO pacienteDTO){
        return Paciente.builder()
                .nome(pacienteDTO.nome())
                .idade(pacienteDTO.idade())
                .genero(pacienteDTO.genero())
                .cep(pacienteDTO.cep())
                .cpf(pacienteDTO.cpf())
                .alergias(pacienteDTO.alergias())
                .tiposanguineo(pacienteDTO.tiposanguineo())
                .telefone(pacienteDTO.telefone())
                .email(pacienteDTO.email()).build();
    }

    public void updateEntityFromDTO(PacienteDTO pacienteDTO, Paciente paciente) {
        paciente.setNome(pacienteDTO.nome());
        paciente.setIdade(pacienteDTO.idade());
        paciente.setGenero(pacienteDTO.genero());
        paciente.setCep(pacienteDTO.cep());
        paciente.setCpf(pacienteDTO.cpf());
        paciente.setAlergias(pacienteDTO.alergias());
        paciente.setTiposanguineo(pacienteDTO.tiposanguineo());
        paciente.setTelefone(pacienteDTO.telefone());
        paciente.setEmail(pacienteDTO.email());
    }
}
