package projetoFinal.atendimentoMedico.mappers;

import org.springframework.stereotype.Component;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.models.Medico;

@Component
public class MedicoMapper {
    public MedicoDTO toDTO(Medico medico){
        return new MedicoDTO(
                medico.getId(),
                medico.getNome(),
                medico.getIdade(),
                medico.getGenero(),
                medico.getCep(),
                medico.getCpf(),
                medico.getAlergias(),
                medico.getTiposanguineo(),
                medico.getTelefone(),
                medico.getEmail(),
                medico.getEspecializacao(),
                medico.getCrm()
        );
    }

    public Medico toEntity(MedicoDTO medicoDTO){
        return Medico.builder()
                .nome(medicoDTO.nome())
                .idade(medicoDTO.idade())
                .genero(medicoDTO.genero())
                .cep(medicoDTO.cep())
                .cpf(medicoDTO.cpf())
                .alergias(medicoDTO.alergias())
                .tiposanguineo(medicoDTO.tiposanguineo())
                .telefone(medicoDTO.telefone())
                .email(medicoDTO.email())
                .especializacao(medicoDTO.especializacao())
                .crm(medicoDTO.crm()).build();
    }

    public void updateEntityFromDTO(MedicoDTO medicoDTO, Medico medico) {
        medico.setNome(medicoDTO.nome());
        medico.setIdade(medicoDTO.idade());
        medico.setGenero(medicoDTO.genero());
        medico.setCep(medicoDTO.cep());
        medico.setCpf(medicoDTO.cpf());
        medico.setAlergias(medicoDTO.alergias());
        medico.setTiposanguineo(medicoDTO.tiposanguineo());
        medico.setTelefone(medicoDTO.telefone());
        medico.setEmail(medicoDTO.email());
        medico.setEspecializacao(medicoDTO.especializacao());
        medico.setCrm(medicoDTO.crm());
    }
}
