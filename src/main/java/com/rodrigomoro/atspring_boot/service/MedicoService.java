package com.rodrigomoro.atspring_boot.service;

import com.rodrigomoro.atspring_boot.dto.MedicoDTO;
import com.rodrigomoro.atspring_boot.dto.MedicoRankingDTO;
import com.rodrigomoro.atspring_boot.entity.Medico;
import com.rodrigomoro.atspring_boot.repository.MedicoRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicoService {

    private final MedicoRepository repository;

    public MedicoService(MedicoRepository repository) {
        this.repository = repository;
    }

    public Medico cadastrar(MedicoDTO dto) {

        Medico medico = new Medico();

        medico.setNome(dto.getNome());
        medico.setCrm(dto.getCrm());
        medico.setEspecialidade(dto.getEspecialidade());

        return repository.save(medico);
    }

    public List<Medico> listarTodos() {
        return repository.findAll();
    }
    public List<MedicoRankingDTO> rankingConsultas() {
        return repository.rankingMedicos();
    }
}
