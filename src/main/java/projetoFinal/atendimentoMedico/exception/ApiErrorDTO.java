package projetoFinal.atendimentoMedico.exception;

import java.time.Instant;

public record ApiErrorDTO(String name,
                          String description,
                          Instant date) {
}
