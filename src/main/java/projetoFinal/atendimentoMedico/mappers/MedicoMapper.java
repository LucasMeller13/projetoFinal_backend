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
}
