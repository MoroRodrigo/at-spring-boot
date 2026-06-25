package com.rodrigomoro.atspring_boot.service;

import com.rodrigomoro.atspring_boot.dto.PacienteDTO;
import com.rodrigomoro.atspring_boot.entity.Paciente;
import com.rodrigomoro.atspring_boot.exception.ResourceNotFoundException;
import com.rodrigomoro.atspring_boot.repository.PacienteRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PacienteService {

    private final PacienteRepository repository;

    public PacienteService(PacienteRepository repository) {
        this.repository = repository;
    }

    public Paciente cadastrar(PacienteDTO dto) {

        Paciente paciente = new Paciente();

        paciente.setNome(dto.getNome());
        paciente.setCpf(dto.getCpf());
        paciente.setDataNascimento(dto.getDataNascimento());
        paciente.setTelefone(dto.getTelefone());

        return repository.save(paciente);
    }

    public Paciente buscarPorId(Long id) {

        return repository.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException(
                                "Paciente não encontrado"));
    }

    public List<Paciente> listarTodos() {
        return repository.findAll();
    }

    public void remover(Long id) {

        Paciente paciente = buscarPorId(id);

        repository.delete(paciente);
    }
}