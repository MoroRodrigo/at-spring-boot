package com.rodrigomoro.atspring_boot.service;

import com.rodrigomoro.atspring_boot.dto.ConsultaDTO;
import com.rodrigomoro.atspring_boot.entity.Consulta;
import com.rodrigomoro.atspring_boot.entity.Medico;
import com.rodrigomoro.atspring_boot.entity.Paciente;
import com.rodrigomoro.atspring_boot.exception.ResourceNotFoundException;
import com.rodrigomoro.atspring_boot.repository.ConsultaRepository;
import com.rodrigomoro.atspring_boot.repository.MedicoRepository;
import com.rodrigomoro.atspring_boot.repository.PacienteRepository;
import org.springframework.stereotype.Service;

@Service
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public ConsultaService(
            ConsultaRepository consultaRepository,
            PacienteRepository pacienteRepository,
            MedicoRepository medicoRepository) {

        this.consultaRepository = consultaRepository;
        this.pacienteRepository = pacienteRepository;
        this.medicoRepository = medicoRepository;
    }

    public Consulta cadastrar(ConsultaDTO dto) {

        Paciente paciente =
                pacienteRepository.findById(dto.getPacienteId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Paciente não encontrado"));

        Medico medico =
                medicoRepository.findById(dto.getMedicoId())
                        .orElseThrow(() ->
                                new ResourceNotFoundException(
                                        "Médico não encontrado"));

        Consulta consulta = new Consulta();

        consulta.setDataConsulta(dto.getDataConsulta());
        consulta.setObservacoes(dto.getObservacoes());
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        return consultaRepository.save(consulta);
    }
}
