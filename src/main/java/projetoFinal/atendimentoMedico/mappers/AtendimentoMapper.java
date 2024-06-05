package projetoFinal.atendimentoMedico.mappers;

import org.springframework.stereotype.Component;
import projetoFinal.atendimentoMedico.dtos.AtendimentoDTO;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.models.Atendimento;
import projetoFinal.atendimentoMedico.models.Medico;

@Component
public class AtendimentoMapper {
    public AtendimentoDTO toDTO(Atendimento atendimento){
        return new AtendimentoDTO(
                atendimento.getId(),
                atendimento.getMedico(),
                atendimento.getPaciente(),
                atendimento.getData(),
                atendimento.getDescricao(),
                atendimento.getRemedios(),
                atendimento.getSala(),
                atendimento.getStatus(),
                atendimento.getDuracao()
        );
    }

    public Atendimento toEntity(AtendimentoDTO atendimentoDTO){
        return Atendimento.builder()
                .medico(atendimentoDTO.medico())
                .paciente(atendimentoDTO.paciente())
                .data(atendimentoDTO.data())
                .descricao(atendimentoDTO.descricao())
                .remedios(atendimentoDTO.remedios())
                .sala(atendimentoDTO.sala())
                .status(atendimentoDTO.status())
                .duracao(atendimentoDTO.duracao()).build();
    }

    public void updateEntityFromDTO(AtendimentoDTO atendimentoDTO, Atendimento atendimento) {
        atendimento.setMedico(atendimentoDTO.medico());
        atendimento.setPaciente(atendimentoDTO.paciente());
        atendimento.setData(atendimentoDTO.data());
        atendimento.setDescricao(atendimentoDTO.descricao());
        atendimento.setRemedios(atendimentoDTO.remedios());
        atendimento.setSala(atendimentoDTO.sala());
        atendimento.setStatus(atendimentoDTO.status());
        atendimento.setDuracao(atendimentoDTO.duracao());
    }
}
