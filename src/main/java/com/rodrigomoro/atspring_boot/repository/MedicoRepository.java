package com.rodrigomoro.atspring_boot.repository;

import com.rodrigomoro.atspring_boot.dto.MedicoRankingDTO;
import com.rodrigomoro.atspring_boot.entity.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MedicoRepository
        extends JpaRepository<Medico, Long> {

    List<Medico> findByEspecialidadeContainingIgnoreCase(
            String especialidade);

    @Query("""
    SELECT new com.rodrigomoro.atspring_boot.dto.MedicoRankingDTO(
        m.nome,
        COUNT(c.id)
    )
    FROM Medico m
    LEFT JOIN m.consultas c
    GROUP BY m.id, m.nome
    ORDER BY COUNT(c.id) DESC
""")
    List<MedicoRankingDTO> rankingMedicos();
}
