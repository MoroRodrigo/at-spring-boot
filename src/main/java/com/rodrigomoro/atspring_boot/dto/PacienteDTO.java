package com.rodrigomoro.atspring_boot.dto;

import jakarta.validation.constraints.NotBlank;

import java.time.LocalDate;

public class PacienteDTO {

    @NotBlank
    private String nome;

    private String cpf;

    private LocalDate dataNascimento;

    private String telefone;

    public PacienteDTO() {}

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}