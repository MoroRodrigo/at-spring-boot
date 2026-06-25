package com.rodrigomoro.atspring_boot.repository;

import com.rodrigomoro.atspring_boot.entity.Internacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InternacaoRepository
        extends JpaRepository<Internacao, Long> {
}
