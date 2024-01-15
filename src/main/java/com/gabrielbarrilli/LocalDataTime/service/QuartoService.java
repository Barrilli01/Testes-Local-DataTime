package com.gabrielbarrilli.LocalDataTime.service;

import com.gabrielbarrilli.LocalDataTime.model.ControleDeHorario;
import com.gabrielbarrilli.LocalDataTime.model.Quarto;
import com.gabrielbarrilli.LocalDataTime.repository.QuartoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class QuartoService {

    private final QuartoRepository quartoRepository;

    public QuartoService(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public Quarto findById(Long id) {
        return quartoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Quarto nao encontrado"));
    }

    public Quarto create(Quarto quarto) {
        var quartoSalvo = quartoRepository.save(quarto);
        quartoSalvo.setNumero(quartoSalvo.getId());
        quartoRepository.save(quartoSalvo);
        return quartoSalvo;
    }
}
