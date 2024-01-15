package com.gabrielbarrilli.LocalDataTime.service;

import com.gabrielbarrilli.LocalDataTime.enums.StatusDoQuarto;
import com.gabrielbarrilli.LocalDataTime.model.ControleDeHorario;
import com.gabrielbarrilli.LocalDataTime.model.Quarto;
import com.gabrielbarrilli.LocalDataTime.repository.QuartoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QuartoService {

    private final QuartoRepository quartoRepository;

    public QuartoService(QuartoRepository quartoRepository) {
        this.quartoRepository = quartoRepository;
    }

    public List<Quarto> findAll(){
        return quartoRepository.findAll();
    }

    public Quarto findById(Long id) {
        return quartoRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("Quarto nao encontrado"));
    }

    public Quarto create(Quarto quarto) {
        var quartoSalvo = quartoRepository.save(quarto);
        quartoSalvo.setNumero(quartoSalvo.getId());
        quartoSalvo.setStatusDoQuarto(StatusDoQuarto.DISPONIVEL);
        quartoRepository.save(quartoSalvo);
        return quartoSalvo;
    }
}
