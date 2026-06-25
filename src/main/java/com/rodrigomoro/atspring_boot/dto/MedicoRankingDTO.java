package com.rodrigomoro.atspring_boot.dto;

public class MedicoRankingDTO {

    private String nome;

    private Long quantidadeConsultas;

    public MedicoRankingDTO(String nome,
                            Long quantidadeConsultas) {
        this.nome = nome;
        this.quantidadeConsultas = quantidadeConsultas;
    }

    public String getNome() {
        return nome;
    }

    public Long getQuantidadeConsultas() {
        return quantidadeConsultas;
    }
}
