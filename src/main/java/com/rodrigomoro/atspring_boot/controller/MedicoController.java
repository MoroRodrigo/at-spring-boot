package com.rodrigomoro.atspring_boot.controller;

import com.rodrigomoro.atspring_boot.dto.MedicoDTO;
import com.rodrigomoro.atspring_boot.dto.MedicoRankingDTO;
import com.rodrigomoro.atspring_boot.entity.Medico;
import com.rodrigomoro.atspring_boot.service.MedicoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/medicos")
public class MedicoController {

    private final MedicoService service;

    public MedicoController(MedicoService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Medico> cadastrar(
            @RequestBody MedicoDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrar(dto));
    }

    @GetMapping
    public ResponseEntity<List<Medico>> listar() {

        return ResponseEntity.ok(
                service.listarTodos());
    }

    @GetMapping("/ranking")
    public ResponseEntity<List<MedicoRankingDTO>>
    ranking() {

        return ResponseEntity.ok(
                service.rankingConsultas());
    }
}
