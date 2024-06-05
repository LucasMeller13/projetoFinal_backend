package projetoFinal.atendimentoMedico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import projetoFinal.atendimentoMedico.dtos.PacienteDTO;
import projetoFinal.atendimentoMedico.mappers.PacienteMapper;
import projetoFinal.atendimentoMedico.models.Paciente;
import projetoFinal.atendimentoMedico.repositorys.PacienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PacienteService {
    @Autowired
    private PacienteRepository pacienteRepository;
    @Autowired
    private PacienteMapper pacienteMapper;

    public List<PacienteDTO> getAllPacientes(Integer paginas, Integer resultados, List<String> sortBy){
        List<Sort.Order> orderByList = sortBy.stream().map((nomeAtributo) -> {
            return new Sort.Order(Sort.Direction.ASC, nomeAtributo);
        }).toList();

        Pageable pageConfig = PageRequest.of(paginas, resultados, Sort.by(orderByList));
        Page<Paciente> listaPacientes = pacienteRepository.findAll(pageConfig);
        List<PacienteDTO> listaPacienteDTO = listaPacientes.stream().map(pacienteMapper::toDTO).toList();

        return listaPacienteDTO;
    }

    public PacienteDTO getPacienteById(UUID id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isEmpty()) throw new RuntimeException("Id não encontrado no PacienteRepository");
        return pacienteMapper.toDTO(paciente.get());
    }

    public PacienteDTO getPacienteByCpf(String cpf){
        Optional<Paciente> paciente = pacienteRepository.findByCpf(cpf);
        if(paciente.isEmpty()) throw new RuntimeException("CPF não encontrado no PacienteRepository");
        return pacienteMapper.toDTO(paciente.get());
    }

    public PacienteDTO savePaciente(PacienteDTO pacienteDTO){
        if((pacienteRepository.findByCpf(pacienteDTO.cpf())).isPresent()) throw new RuntimeException("CPF já cadastrado no PacienteRepository");
        Paciente paciente = pacienteMapper.toEntity(pacienteDTO);
        Paciente pacienteSalvo = pacienteRepository.save(paciente);

        return pacienteMapper.toDTO(pacienteSalvo);
    }

    public PacienteDTO updatePaciente(PacienteDTO pacienteDTO){
        Optional<Paciente> paciente = pacienteRepository.findById(pacienteDTO.id());
        if(paciente.isEmpty()) throw new RuntimeException("Id não encontrado no PacienteRepository");
        Paciente pacienteExistente = paciente.get();
        pacienteMapper.updateEntityFromDTO(pacienteDTO,pacienteExistente);
        Paciente pacienteAtualizado = pacienteRepository.save(pacienteExistente);
        return pacienteMapper.toDTO(pacienteAtualizado);
    }

    public PacienteDTO deletePaciente(UUID id){
        Optional<Paciente> paciente = pacienteRepository.findById(id);
        if(paciente.isEmpty()) throw new RuntimeException("Id não encontrado no PacienteRepository");
        pacienteRepository.delete(paciente.get());
        return pacienteMapper.toDTO(paciente.get());
    }
}
