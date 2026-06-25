package com.rodrigomoro.atspring_boot.config;

import com.rodrigomoro.atspring_boot.entity.Medico;
import com.rodrigomoro.atspring_boot.entity.Paciente;
import com.rodrigomoro.atspring_boot.repository.MedicoRepository;
import com.rodrigomoro.atspring_boot.repository.PacienteRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner init(
            MedicoRepository medicoRepository,
            PacienteRepository pacienteRepository) {

        return args -> {

            if (medicoRepository.count() == 0) {

                medicoRepository.save(
                        new Medico(
                                "Dr. Carlos Mendes",
                                "CRM1001",
                                "Cardiologista"));

                medicoRepository.save(
                        new Medico(
                                "Dr. Ricardo Lima",
                                "CRM1002",
                                "Ortopedista"));
            }

            if (pacienteRepository.count() == 0) {

                pacienteRepository.save(
                        new Paciente(
                                "João Silva",
                                "11111111111",
                                LocalDate.of(1990,5,10),
                                "21999999999"));

                pacienteRepository.save(
                        new Paciente(
                                "Maria Oliveira",
                                "22222222222",
                                LocalDate.of(1985,7,15),
                                "21888888888"));
            }
        };
    }
}
