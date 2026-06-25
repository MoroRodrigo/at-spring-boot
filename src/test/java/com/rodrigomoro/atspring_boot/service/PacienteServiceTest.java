package com.rodrigomoro.atspring_boot.service;

import com.rodrigomoro.atspring_boot.dto.PacienteDTO;
import com.rodrigomoro.atspring_boot.entity.Paciente;
import com.rodrigomoro.atspring_boot.exception.ResourceNotFoundException;
import com.rodrigomoro.atspring_boot.repository.PacienteRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.LocalDate;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PacienteServiceTest {

    @Mock
    private PacienteRepository repository;

    @InjectMocks
    private PacienteService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarPaciente() {

        PacienteDTO dto = new PacienteDTO();

        dto.setNome("João");
        dto.setCpf("111");

        Paciente paciente = new Paciente();

        paciente.setNome(dto.getNome());

        when(repository.save(any()))
                .thenReturn(paciente);

        Paciente salvo =
                service.cadastrar(dto);

        assertEquals(
                "João",
                salvo.getNome());
    }

    @Test
    void deveBuscarPacientePorId() {

        Paciente paciente =
                new Paciente();

        paciente.setId(1L);

        when(repository.findById(1L))
                .thenReturn(
                        Optional.of(paciente));

        Paciente resultado =
                service.buscarPorId(1L);

        assertEquals(
                1L,
                resultado.getId());
    }

    @Test
    void deveExcluirPaciente() {

        Paciente paciente =
                new Paciente();

        paciente.setId(1L);

        when(repository.findById(1L))
                .thenReturn(
                        Optional.of(paciente));

        service.remover(1L);

        verify(repository)
                .delete(paciente);
    }

    @Test
    void deveLancarErroQuandoPacienteNaoExiste() {

        when(repository.findById(1L))
                .thenReturn(Optional.empty());

        assertThrows(
                ResourceNotFoundException.class,
                () -> service.buscarPorId(1L));
    }
}
