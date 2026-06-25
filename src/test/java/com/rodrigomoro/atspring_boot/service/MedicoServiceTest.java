package com.rodrigomoro.atspring_boot.service;

import com.rodrigomoro.atspring_boot.dto.MedicoDTO;
import com.rodrigomoro.atspring_boot.entity.Medico;
import com.rodrigomoro.atspring_boot.repository.MedicoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class MedicoServiceTest {

    @Mock
    private MedicoRepository repository;

    @InjectMocks
    private MedicoService service;

    @BeforeEach
    void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void deveCadastrarMedico() {

        MedicoDTO dto =
                new MedicoDTO();

        dto.setNome("Carlos");
        dto.setCrm("CRM123");

        Medico medico =
                new Medico();

        medico.setNome("Carlos");

        when(repository.save(any()))
                .thenReturn(medico);

        Medico resultado =
                service.cadastrar(dto);

        assertEquals(
                "Carlos",
                resultado.getNome());
    }
}
