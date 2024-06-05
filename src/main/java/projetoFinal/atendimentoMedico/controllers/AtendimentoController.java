package projetoFinal.atendimentoMedico.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projetoFinal.atendimentoMedico.dtos.AtendimentoDTO;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.services.AtendimentoService;
import projetoFinal.atendimentoMedico.services.MedicoService;

import java.util.List;

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
            @RequestParam(defaultValue = "nome") List<String> sortBy){
        return atendimentoService.getAllAtendimentos(paginas,resultados,sortBy);
    }
}
