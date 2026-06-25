package com.rodrigomoro.atspring_boot.repository;

import com.rodrigomoro.atspring_boot.entity.Paciente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PacienteRepository
        extends JpaRepository<Paciente, Long> {
}
