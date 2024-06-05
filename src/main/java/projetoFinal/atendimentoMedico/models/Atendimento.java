package projetoFinal.atendimentoMedico.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.UUID;

@Entity
@Table(name = "atendimento")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Atendimento {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    private Medico medico;
    private Paciente paciente;
    private Date data;
    private String descricao;
    private String remedios;
    private String sala;
    private String status;
    private int duracao;
}
