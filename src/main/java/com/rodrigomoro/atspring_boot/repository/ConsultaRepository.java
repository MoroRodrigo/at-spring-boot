package com.rodrigomoro.atspring_boot.repository;

import com.rodrigomoro.atspring_boot.entity.Consulta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ConsultaRepository
        extends JpaRepository<Consulta, Long> {
}
