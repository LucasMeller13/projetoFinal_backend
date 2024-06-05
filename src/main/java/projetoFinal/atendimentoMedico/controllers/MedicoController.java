package projetoFinal.atendimentoMedico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.services.MedicoService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/medico/")
public class MedicoController {
    @Autowired
    private MedicoService medicoService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MedicoDTO> getAllMedicos(
            @RequestParam(defaultValue = "0") Integer paginas,
            @RequestParam(defaultValue = "5") Integer resultados,
            @RequestParam(defaultValue = "nome") List<String> sortBy){
        return medicoService.getAllMedicos(paginas,resultados,sortBy);
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicoDTO getMedicoById(@PathVariable UUID id){
        return medicoService.getMedicoById(id);
    }


    @GetMapping("/cpf/{cpf}")
    @ResponseStatus(HttpStatus.OK)
    public MedicoDTO getMedicoByCpf(@PathVariable String cpf){
        return medicoService.getMedicoByCpf(cpf);
    }


    @GetMapping("/crm/{crm}")
    @ResponseStatus(HttpStatus.OK)
    public MedicoDTO getMedicoByCrm(@PathVariable String crm){
        return medicoService.getMedicoByCrm(crm);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public MedicoDTO saveMedico(@RequestBody MedicoDTO medicoDTO){
        return medicoService.saveMedico(medicoDTO);
    }

    @PatchMapping
    @ResponseStatus(HttpStatus.OK)
    public MedicoDTO updateMedico(@RequestBody MedicoDTO medicoDTO){
        return medicoService.updateMedico(medicoDTO);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public MedicoDTO deleteMedico(@PathVariable UUID id){
        return medicoService.deleteMedico(id);
    }
}
