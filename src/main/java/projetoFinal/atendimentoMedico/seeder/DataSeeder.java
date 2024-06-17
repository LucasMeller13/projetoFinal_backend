package projetoFinal.atendimentoMedico.seeder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.beans.factory.annotation.Autowired;
import projetoFinal.atendimentoMedico.dtos.AtendimentoDTO;
import projetoFinal.atendimentoMedico.dtos.PacienteDTO;
import projetoFinal.atendimentoMedico.services.AtendimentoService;
import projetoFinal.atendimentoMedico.services.MedicoService;
import projetoFinal.atendimentoMedico.dtos.MedicoDTO;
import projetoFinal.atendimentoMedico.services.PacienteService;

import java.util.Date;
import java.util.UUID;

@Configuration
public class DataSeeder {

    @Autowired
    private MedicoService medicoService;
    @Autowired
    private PacienteService pacienteService;
    @Autowired
    private AtendimentoService atendimentoService;

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {

            MedicoDTO medico1 = new MedicoDTO(
                    UUID.randomUUID(),
                    "Carlos Silva",
                    40,
                    "masculino",
                    "12345678",
                    "12345678901",
                    "lactose",
                    "a+",
                    "555-2345",
                    "carlosilva@example.com",
                    "Ortopedia",
                    "1234123"
            );

            MedicoDTO medico2 = new MedicoDTO(
                    UUID.randomUUID(),
                    "Marina Ferreira",
                    35,
                    "feminino",
                    "87654321",
                    "23456789012",
                    "caseina",
                    "o-",
                    "555-6789",
                    "marinaferreira@example.com",
                    "Pediatria",
                    "42365423"
            );

            MedicoDTO med1 = medicoService.saveMedico(medico1);
            MedicoDTO med2 = medicoService.saveMedico(medico2);

            PacienteDTO paciente1 = new PacienteDTO(
                    UUID.randomUUID(),
                    "Alice Marques",
                    28,
                    "feminino",
                    "89012345",
                    "98765432100",
                    " ",
                    "ab+",
                    "7890-1234",
                    "alicemarques@example.com"
            );

            PacienteDTO paciente2 = new PacienteDTO(
                    UUID.randomUUID(),
                    "Renato Marcelino",
                    34,
                    "masculino",
                    "12345678",
                    "12345678909",
                    "soja",
                    "o-",
                    "4567-8901",
                    "renatomarcelino@example.com"
            );

            PacienteDTO pac1 = pacienteService.savePaciente(paciente1);
            PacienteDTO pac2 = pacienteService.savePaciente(paciente2);

            AtendimentoDTO atendimento1 = new AtendimentoDTO(
                    UUID.randomUUID(),
                    med1.id(),
                    pac1.id(),
                    med1,
                    pac1,
                    new Date(),
                    "Paciente com febre e dor de cabeça",
                    "paracetamol",
                    "10.10",
                    "feito",
                    30
            );

            AtendimentoDTO atendimento2 = new AtendimentoDTO(
                    UUID.randomUUID(),
                    med2.id(),
                    pac2.id(),
                    med2,
                    pac2,
                    new Date(),
                    " ",
                    " ",
                    "20.20",
                    "pendente",
                    0
            );

            atendimentoService.saveAtendimento(atendimento1);
            atendimentoService.saveAtendimento(atendimento2);
        };
    }
}

