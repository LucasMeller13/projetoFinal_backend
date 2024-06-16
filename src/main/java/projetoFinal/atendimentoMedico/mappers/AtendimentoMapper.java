package projetoFinal.atendimentoMedico.mappers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import projetoFinal.atendimentoMedico.dtos.AtendimentoDTO;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.models.Atendimento;
import projetoFinal.atendimentoMedico.models.Medico;
import projetoFinal.atendimentoMedico.models.Paciente;
import projetoFinal.atendimentoMedico.services.MedicoService;
import projetoFinal.atendimentoMedico.services.PacienteService;

@Component
public class AtendimentoMapper {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private MedicoMapper medicoMapper;

    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private PacienteMapper pacienteMapper;

    public AtendimentoDTO toDTO(Atendimento atendimento){
        return new AtendimentoDTO(
                atendimento.getId(),
                atendimento.getIdMedico(),
                atendimento.getIdPaciente(),
                medicoService.getMedicoById(atendimento.getIdMedico()),
                pacienteService.getPacienteById(atendimento.getIdPaciente()),
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
                .idMedico(atendimentoDTO.idMedico())
                .idPaciente(atendimentoDTO.idPaciente())
                .data(atendimentoDTO.data())
                .descricao(atendimentoDTO.descricao())
                .remedios(atendimentoDTO.remedios())
                .sala(atendimentoDTO.sala())
                .status(atendimentoDTO.status())
                .duracao(atendimentoDTO.duracao()).build();
    }

    public void updateEntityFromDTO(AtendimentoDTO atendimentoDTO, Atendimento atendimento) {
        atendimento.setIdMedico(atendimentoDTO.idMedico());
        atendimento.setIdPaciente(atendimentoDTO.idPaciente());
        atendimento.setData(atendimentoDTO.data());
        atendimento.setDescricao(atendimentoDTO.descricao());
        atendimento.setRemedios(atendimentoDTO.remedios());
        atendimento.setSala(atendimentoDTO.sala());
        atendimento.setStatus(atendimentoDTO.status());
        atendimento.setDuracao(atendimentoDTO.duracao());
    }
}
