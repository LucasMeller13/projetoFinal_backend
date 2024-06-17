package projetoFinal.atendimentoMedico.controllers;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projetoFinal.atendimentoMedico.dtos.AtendimentoDTO;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.services.AtendimentoService;
import projetoFinal.atendimentoMedico.services.MedicoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/atendimento/")
public class AtendimentoController {
    @Autowired
    private AtendimentoService atendimentoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AtendimentoDTO> getAllAtendimentos(
            @RequestParam(defaultValue = "0") Integer paginas,
            @RequestParam(defaultValue = "5") Integer resultados,
            @RequestParam(defaultValue = "status") List<String> sortBy){
        return atendimentoService.getAllAtendimentos(paginas,resultados,sortBy);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AtendimentoDTO getAtendimentoById(@PathVariable UUID id){
        return atendimentoService.getAtendimentoById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AtendimentoDTO saveAtendimento(@RequestBody @Valid AtendimentoDTO atendimentoDTO){
        return atendimentoService.saveAtendimento(atendimentoDTO);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public AtendimentoDTO updateAtendimento(@RequestBody @Valid AtendimentoDTO atendimentoDTO){
        return atendimentoService.updateAtendimento(atendimentoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public AtendimentoDTO deleteAtendimento(@PathVariable UUID id){
        return atendimentoService.deleteAtendimento(id);
    }
}
