package com.rodrigomoro.atspring_boot.controller;

import com.rodrigomoro.atspring_boot.dto.ConsultaDTO;
import com.rodrigomoro.atspring_boot.entity.Consulta;
import com.rodrigomoro.atspring_boot.service.ConsultaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/consultas")
public class ConsultaController {

    private final ConsultaService service;

    public ConsultaController(ConsultaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Consulta> cadastrar(
            @RequestBody ConsultaDTO dto) {

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(service.cadastrar(dto));
    }
}
