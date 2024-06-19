package projetoFinal.atendimentoMedico.services;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.mappers.MedicoMapper;
import projetoFinal.atendimentoMedico.models.Medico;
import projetoFinal.atendimentoMedico.repositorys.MedicoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicoService {
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private MedicoMapper medicoMapper;

    public List<MedicoDTO> getAllMedicos(Integer paginas, Integer resultados, List<String> sortBy){
        List<Sort.Order> orderByList = sortBy.stream().map((nomeAtributo) -> {
            return new Sort.Order(Sort.Direction.ASC, nomeAtributo);
        }).toList();

        Pageable pageConfig = PageRequest.of(paginas, resultados, Sort.by(orderByList));
        Page<Medico> listaMedicos = medicoRepository.findAll(pageConfig);
        List<MedicoDTO> listaMedicosDTO = listaMedicos.stream().map(medicoMapper::toDTO).toList();

        return listaMedicosDTO;
    }

    public MedicoDTO getMedicoById(UUID id){
        Optional<Medico> medico = medicoRepository.findById(id);
        if(medico.isEmpty()) throw new EntityNotFoundException("Id não encontrado no MedicoRepository");
        return medicoMapper.toDTO(medico.get());
    }


    public MedicoDTO getMedicoByCpf(String cpf){
        Optional<Medico> medico = medicoRepository.findByCpf(cpf);
        if(medico.isEmpty()) throw new EntityNotFoundException("CPF não encontrado no MedicoRepository");
        return medicoMapper.toDTO(medico.get());
    }

    public MedicoDTO getMedicoByCrm(String crm){
        Optional<Medico> medico = medicoRepository.findByCrm(crm);
        if(medico.isEmpty()) throw new EntityNotFoundException("CRM não encontrado no MedicoRepository");
        return medicoMapper.toDTO(medico.get());
    }

    public MedicoDTO saveMedico(MedicoDTO medicoDTO){
        if((medicoRepository.findByCpf(medicoDTO.cpf())).isPresent()) throw new RuntimeException("CPF já cadastrado no MedicoRepository");
        if((medicoRepository.findByCrm(medicoDTO.crm())).isPresent()) throw new RuntimeException("CRM já cadastrado no MedicoRepository");
        Medico medico = medicoMapper.toEntity(medicoDTO);
        Medico medicoSalvo = medicoRepository.save(medico);

        return medicoMapper.toDTO(medicoSalvo);
    }

    public MedicoDTO updateMedico(MedicoDTO medicoDTO){
        Optional<Medico> medico = medicoRepository.findById(medicoDTO.id());
        if(medico.isEmpty()) throw new EntityNotFoundException("Id não encontrado no MedicoRepository");
        Medico medidoExistente = medico.get();
        medicoMapper.updateEntityFromDTO(medicoDTO,medidoExistente);
        Medico medicoAtualizado = medicoRepository.save(medidoExistente);
        return medicoMapper.toDTO(medicoAtualizado);
    }

    public MedicoDTO deleteMedico(UUID id){
        Optional<Medico> medico = medicoRepository.findById(id);
        if(medico.isEmpty()) throw new EntityNotFoundException("Id não encontrado no MedicoRepository");
        medicoRepository.delete(medico.get());
        return medicoMapper.toDTO(medico.get());
    }


}
