package projetoFinal.atendimentoMedico.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import projetoFinal.atendimentoMedico.dtos.PacienteDTO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Arrays;

@RestController
@RequestMapping("/")
public class ProjetoController {

    @GetMapping("/ajuda")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getProjetoInfo() {
        Map<String, Object> response = new HashMap<>();

        List<String> estudantes = Arrays.asList("Igor Rocha", "Lucas Meller");
        response.put("estudantes", estudantes);
        response.put("projeto", "Atendimento em consultório");
        response.put("tema", "Sistema de atendimento médico");

        return response;
    }
}
