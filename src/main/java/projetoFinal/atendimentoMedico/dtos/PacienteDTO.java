package projetoFinal.atendimentoMedico.dtos;

import jakarta.validation.constraints.*;

import java.util.UUID;

public record PacienteDTO(
        UUID id,

        @NotBlank( message = "Precisa de um nome")
        String nome,

        @NotNull
        @Positive(message = "A idade precisa ser um numero positivo")
        Integer idade,

        @NotBlank( message = "Precisa de um gênero")
        String genero,

        @NotBlank( message = "Precisa de um cep")
        @Digits(message = "CEP precisa ser um número inteiro", integer = 8, fraction = 0)
        String cep,

        @NotBlank( message = "Precisa de um cpf")
        @Digits(message = "CPF precisa ser um número inteiro", integer = 11, fraction = 0)
        String cpf,

        String alergias,

        @NotBlank( message = "Precisa de um tipo sanguíneo")
        String tiposanguineo,

        @NotBlank( message = "Precisa de um telefone")
        @Digits(message = "Telefone precisa ser um número inteiro", integer = 9, fraction = 0)
        String telefone,

        @NotBlank( message = "Precisa de um email")
        @Email
        String email
) {
}
