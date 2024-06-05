package projetoFinal.atendimentoMedico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.dtos.PacienteDTO;
import projetoFinal.atendimentoMedico.services.MedicoService;
import projetoFinal.atendimentoMedico.services.PacienteService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/paciente/")
public class PacienteController {
    @Autowired
    private PacienteService pacienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<PacienteDTO> getAllPacientes(
            @RequestParam(defaultValue = "0") Integer paginas,
            @RequestParam(defaultValue = "5") Integer resultados,
            @RequestParam(defaultValue = "nome") List<String> sortBy){
        return pacienteService.getAllPacientes(paginas,resultados,sortBy);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteDTO getPacienteById(@PathVariable UUID id){
        return pacienteService.getPacienteById(id);
    }

    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteDTO getPacienteByCpf(@PathVariable String cpf){
        return pacienteService.getPacienteByCpf(cpf);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PacienteDTO savePaciente(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.savePaciente(pacienteDTO);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public PacienteDTO updatePaciente(@RequestBody PacienteDTO pacienteDTO){
        return pacienteService.updatePaciente(pacienteDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public PacienteDTO deletePaciente(@PathVariable UUID id){
        return pacienteService.deletePaciente(id);
    }
}
