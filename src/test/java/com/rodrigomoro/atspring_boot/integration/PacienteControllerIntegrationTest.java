package com.rodrigomoro.atspring_boot.integration;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.rodrigomoro.atspring_boot.dto.PacienteDTO;
import com.rodrigomoro.atspring_boot.entity.Paciente;
import com.rodrigomoro.atspring_boot.repository.PacienteRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

import java.time.LocalDate;

import static org.hamcrest.Matchers.hasSize;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
class PacienteControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private PacienteRepository pacienteRepository;

    @BeforeEach
    void setup() {
        pacienteRepository.deleteAll();
    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void deveCadastrarPaciente() throws Exception {

        PacienteDTO dto = new PacienteDTO();

        dto.setNome("João Silva");
        dto.setCpf("12345678900");
        dto.setTelefone("21999999999");
        dto.setDataNascimento(LocalDate.of(1990, 1, 1));

        mockMvc.perform(post("/pacientes")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(dto)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.nome").value("João Silva"))
                .andExpect(jsonPath("$.cpf").value("12345678900"));

    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void deveBuscarPacientePorId() throws Exception {

        Paciente paciente = new Paciente();

        paciente.setNome("Maria Oliveira");
        paciente.setCpf("99999999999");
        paciente.setTelefone("21988888888");
        paciente.setDataNascimento(LocalDate.of(1995, 5, 10));

        paciente = pacienteRepository.save(paciente);

        mockMvc.perform(get("/pacientes/{id}", paciente.getId()))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(paciente.getId()))
                .andExpect(jsonPath("$.nome").value("Maria Oliveira"))
                .andExpect(jsonPath("$.cpf").value("99999999999"));

    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void deveListarPacientes() throws Exception {

        Paciente paciente1 = new Paciente();
        paciente1.setNome("João");
        paciente1.setCpf("11111111111");
        paciente1.setTelefone("111111111");
        paciente1.setDataNascimento(LocalDate.of(1990, 1, 1));

        Paciente paciente2 = new Paciente();
        paciente2.setNome("Maria");
        paciente2.setCpf("22222222222");
        paciente2.setTelefone("222222222");
        paciente2.setDataNascimento(LocalDate.of(1992, 2, 2));

        pacienteRepository.save(paciente1);
        pacienteRepository.save(paciente2);

        mockMvc.perform(get("/pacientes"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(2)));

    }

    @Test
    @WithMockUser(username = "admin", roles = {"ADMIN"})
    void deveExcluirPaciente() throws Exception {

        Paciente paciente = new Paciente();

        paciente.setNome("Carlos");
        paciente.setCpf("33333333333");
        paciente.setTelefone("333333333");
        paciente.setDataNascimento(LocalDate.of(1980, 10, 10));

        paciente = pacienteRepository.save(paciente);

        mockMvc.perform(delete("/pacientes/{id}", paciente.getId()))
                .andExpect(status().isNoContent());

        boolean existe = pacienteRepository.findById(paciente.getId()).isPresent();

        org.junit.jupiter.api.Assertions.assertFalse(existe);

    }

    @Test
    void deveRetornar401QuandoNaoAutenticado() throws Exception {

        mockMvc.perform(get("/pacientes"))
                .andExpect(status().isUnauthorized());

    }

}