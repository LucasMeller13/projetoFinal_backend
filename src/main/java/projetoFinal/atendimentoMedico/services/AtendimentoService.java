package projetoFinal.atendimentoMedico.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import projetoFinal.atendimentoMedico.dtos.AtendimentoDTO;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.mappers.AtendimentoMapper;
import projetoFinal.atendimentoMedico.mappers.MedicoMapper;
import projetoFinal.atendimentoMedico.models.Atendimento;
import projetoFinal.atendimentoMedico.models.Medico;
import projetoFinal.atendimentoMedico.repositorys.AtendimentoRepository;
import projetoFinal.atendimentoMedico.repositorys.MedicoRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class AtendimentoService {
    @Autowired
    private AtendimentoRepository atendimentoRepository;
    @Autowired
    private AtendimentoMapper atendimentoMapper;

    public List<AtendimentoDTO> getAllAtendimentos(Integer paginas, Integer resultados, List<String> sortBy){
        List<Sort.Order> orderByList = sortBy.stream().map((nomeAtributo) -> {
            return new Sort.Order(Sort.Direction.ASC, nomeAtributo);
        }).toList();

        Pageable pageConfig = PageRequest.of(paginas, resultados, Sort.by(orderByList));
        Page<Atendimento> listaAtendimentos = atendimentoRepository.findAll(pageConfig);
        List<AtendimentoDTO> listaAtendimentoDTO = listaAtendimentos.stream().map(atendimentoMapper::toDTO).toList();

        return listaAtendimentoDTO;
    }

    public AtendimentoDTO getAtendimentoById(UUID id){
        Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
        if(atendimento.isEmpty()) throw new RuntimeException("Id não encontrado no MedicoRepository");
        return atendimentoMapper.toDTO(atendimento.get());
    }

    public AtendimentoDTO saveAtendimento(AtendimentoDTO atendimentoDTO){
        Atendimento atendimento = atendimentoMapper.toEntity(atendimentoDTO);
        Atendimento atendimentoSalvo = atendimentoRepository.save(atendimento);

        return atendimentoMapper.toDTO(atendimentoSalvo);
    }

    public AtendimentoDTO updateAtendimento(AtendimentoDTO atendimentoDTO){
        Optional<Atendimento> atendimento = atendimentoRepository.findById(atendimentoDTO.id());
        if(atendimento.isEmpty()) throw new RuntimeException("Id não encontrado no AtendimentoRepository");
        Atendimento atendimentoExistente = atendimento.get();
        atendimentoMapper.updateEntityFromDTO(atendimentoDTO,atendimentoExistente);
        Atendimento atendimentoAtualizado = atendimentoRepository.save(atendimentoExistente);
        return atendimentoMapper.toDTO(atendimentoAtualizado);
    }

    public AtendimentoDTO deleteAtendimento(UUID id){
        Optional<Atendimento> atendimento = atendimentoRepository.findById(id);
        if(atendimento.isEmpty()) throw new RuntimeException("Id não encontrado no MedicoRepository");
        atendimentoRepository.delete(atendimento.get());
        return atendimentoMapper.toDTO(atendimento.get());
    }
}
