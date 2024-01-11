package com.gabrielbarrilli.LocalDataTime.service;

import com.gabrielbarrilli.LocalDataTime.model.ControleDeHorario;
import com.gabrielbarrilli.LocalDataTime.repository.ControleDeHorarioRepository;
import com.gabrielbarrilli.LocalDataTime.repository.QuartoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class ControleDeHorarioService {

    private final QuartoRepository quartoRepository;

    private final ControleDeHorarioRepository controleDeHorarioRepository;

    public ControleDeHorarioService(QuartoRepository quartoRepository, ControleDeHorarioRepository controleDeHorarioRepository) {
        this.quartoRepository = quartoRepository;
        this.controleDeHorarioRepository = controleDeHorarioRepository;
    }

    public List<ControleDeHorario> Teste (){
        LocalDateTime localDateTime = LocalDateTime.now();
        return controleDeHorarioRepository.findByDataHoraAtual(localDateTime);
    }

    public ControleDeHorario findById(Long id) {
        return controleDeHorarioRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("controle nao encontrado"));
    }

    public ControleDeHorario create(ControleDeHorario controleDeHorario, Long idQuarto) {
        var quarto = quartoRepository.findById(idQuarto).orElseThrow(()-> new EntityNotFoundException("Quarto inexistente, não foi possível criar horário"));
        controleDeHorario.setQuarto(quarto);
        return controleDeHorarioRepository.save(controleDeHorario);
    }

    public ControleDeHorario editarHorarioSaida(Long idControle) {
        var controle = controleDeHorarioRepository.findById(idControle).orElseThrow(()-> new EntityNotFoundException("Controle de horário inexistente"));
        controle.setDataHoraSaida(LocalDateTime.now());
        return controleDeHorarioRepository.save(controle);
    }
}
