package com.rodrigomoro.atspring_boot.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    @Column(unique = true)
    private String cpf;

    private LocalDate dataNascimento;

    private String telefone;

    @OneToMany(mappedBy = "paciente")
    private List<Consulta> consultas = new ArrayList<>();

    @OneToMany(mappedBy = "paciente")
    private List<Internacao> internacoes = new ArrayList<>();

    public Paciente() {}

    public Paciente(String nome, String cpf,
                    LocalDate dataNascimento,
                    String telefone) {
        this.nome = nome;
        this.cpf = cpf;
        this.dataNascimento = dataNascimento;
        this.telefone = telefone;
    }

}
