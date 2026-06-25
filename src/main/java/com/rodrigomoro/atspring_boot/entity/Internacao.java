package com.rodrigomoro.atspring_boot.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "internacoes")
public class Internacao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate dataEntrada;

    private LocalDate dataAlta;

    private String quarto;

    @ManyToOne
    @JoinColumn(name = "paciente_id")
    private Paciente paciente;

    public Internacao() {}

}
