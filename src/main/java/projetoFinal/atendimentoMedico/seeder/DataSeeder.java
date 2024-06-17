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
            UUID med1 = UUID.randomUUID();
            UUID med2 = UUID.randomUUID();
            UUID pac1 = UUID.randomUUID();
            UUID pac2 = UUID.randomUUID();
            MedicoDTO medico1 = new MedicoDTO(
                    med1,
                    "Dr. John Doe",
                    40,
                    "Male",
                    "12345678",
                    "12345678901",
                    "555-1234",
                    "A+",
                    "555-2345",
                    "johndoe@example.com",
                    "General Practice",
                    "001"
            );

            MedicoDTO medico2 = new MedicoDTO(
                    med2,
                    "Dr. Jane Smith",
                    35,
                    "Female",
                    "87654321",
                    "23456789012",
                    "555-5678",
                    "O-",
                    "555-6789",
                    "janesmith@example.com",
                    "Pediatrics",
                    "002"
            );

            medicoService.saveMedico(medico1);
            medicoService.saveMedico(medico2);

            PacienteDTO paciente1 = new PacienteDTO(
                    pac1,
                    "Alice Johnson",
                    28,
                    "Female",
                    "89012345",
                    "98765432100",
                    "No allergies",
                    "AB+",
                    "7890-1234",
                    "alice@example.com"
            );

            PacienteDTO paciente2 = new PacienteDTO(
                    pac2,
                    "Bob Smith",
                    34,
                    "Male",
                    "12345678",
                    "12345678909",
                    "Peanuts",
                    "O-",
                    "4567-8901",
                    "bob@example.com"
            );

            pacienteService.savePaciente(paciente1);
            pacienteService.savePaciente(paciente2);

            AtendimentoDTO atendimento1 = new AtendimentoDTO(
                    UUID.randomUUID(),
                    med1,
                    pac1,
                    medico1,
                    paciente1,
                    new Date(),
                    "teste1",
                    "nada",
                    "10.10",
                    "feito",
                    30
            );

            AtendimentoDTO atendimento2 = new AtendimentoDTO(
                    UUID.randomUUID(),
                    med2,
                    pac2,
                    medico2,
                    paciente2,
                    new Date(),
                    "teste2",
                    "nada2",
                    "20.20",
                    "pendente",
                    0
            );

//            atendimentoService.saveAtendimento(atendimento1);
//            atendimentoService.saveAtendimento(atendimento2);
        };
    }
}

