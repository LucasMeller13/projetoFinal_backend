package projetoFinal.atendimentoMedico.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "medico")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Medico {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private String nome;
    private Integer idade;
    private String genero;
    private String cep;
    private String cpf;
    private String alergias;
    private String tiposanguineo;
    private String telefone;
    private String email;
    private String especializacao;
    private String crm;
}
