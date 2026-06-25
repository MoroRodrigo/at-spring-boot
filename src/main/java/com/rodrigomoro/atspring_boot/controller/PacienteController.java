package com.rodrigomoro.atspring_boot.controller;

import com.rodrigomoro.atspring_boot.dto.PacienteDTO;
import com.rodrigomoro.atspring_boot.entity.Paciente;
import com.rodrigomoro.atspring_boot.service.PacienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pacientes")
public class PacienteController {

    private final PacienteService service;

    public PacienteController(PacienteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Paciente> cadastrar(
            @RequestBody @Valid PacienteDTO dto) {

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(service.cadastrar(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Paciente> buscar(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                service.buscarPorId(id));
    }

    @GetMapping
    public ResponseEntity<List<Paciente>> listar() {

        return ResponseEntity.ok(
                service.listarTodos());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> remover(
            @PathVariable Long id) {

        service.remover(id);

        return ResponseEntity.noContent().build();
    }
}
