package com.gabrielbarrilli.LocalDataTime.service;

import com.gabrielbarrilli.LocalDataTime.enums.StatusDoQuarto;
import com.gabrielbarrilli.LocalDataTime.model.ControleDeHorario;
import com.gabrielbarrilli.LocalDataTime.repository.ControleDeHorarioRepository;
import com.gabrielbarrilli.LocalDataTime.repository.QuartoRepository;
import com.gabrielbarrilli.LocalDataTime.response.ControleDeHorarioResponse;
import com.gabrielbarrilli.LocalDataTime.response.HorarioResponse;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
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

    public List<ControleDeHorario> findAll(){
        return controleDeHorarioRepository.findAll();
    }

    public List<ControleDeHorario> findByData(LocalDate buscaData){
        return controleDeHorarioRepository.findByDataEntrada(buscaData);
    }

    public ControleDeHorarioResponse findById(Long id) {
        var porId = controleDeHorarioRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("controle nao encontrado"));
        return new ControleDeHorarioResponse(
                porId.getId(),
                porId.getDataHoraEntrada(),
                porId.getDataHoraSaida(),
                porId.getQuarto().getNumero(),
                porId.getPlaca(),
                calculoPermanencia(id)
                );
    }

    public ControleDeHorario create(ControleDeHorario controleDeHorario, Long idQuarto) {
        var quarto = quartoRepository.findById(idQuarto).orElseThrow(()-> new EntityNotFoundException("Quarto inexistente, não foi possível criar horário"));

        if(quarto.getStatusDoQuarto() == StatusDoQuarto.DISPONIVEL) {

            controleDeHorario.setQuarto(quarto);
            quarto.setStatusDoQuarto(StatusDoQuarto.OCUPADO);

            controleDeHorario.setDataEntrada(LocalDate.now());

            controleDeHorario.setDataHoraEntrada(LocalDateTime.now());

        } else {
            throw new EntityNotFoundException("O quarto está ocupado!");
        }

        return controleDeHorarioRepository.save(controleDeHorario);
    }

    public ControleDeHorario editarSaida(Long idControle) {
        var controle = controleDeHorarioRepository.findById(idControle).orElseThrow(()-> new EntityNotFoundException("Controle de horário inexistente"));
        var quarto = quartoRepository.findById(controle.getQuarto().getId()).orElseThrow(()-> new EntityNotFoundException("Quarto não identificado"));

        var statusqto = controle.getQuarto().getStatusDoQuarto();

        if (statusqto == StatusDoQuarto.OCUPADO) {
            quarto.setStatusDoQuarto(StatusDoQuarto.DISPONIVEL);

            controle.setDataHoraSaida(LocalDateTime.now());

            calculoPermanencia(idControle);
        } else {
            System.out.println("O Quarto não está ocupado!");
        }
        return controleDeHorarioRepository.save(controle);
    }

    public HorarioResponse calculoPermanencia(Long idControle){

        var controle = controleDeHorarioRepository.findById(idControle).orElseThrow(()-> new EntityNotFoundException("não achou id para calcular"));

        LocalDateTime localTimeEntrada = controle.getDataHoraEntrada();
        LocalDateTime localTimeSaida = controle.getDataHoraSaida();

        var duration = Duration.between(localTimeEntrada, localTimeSaida);

        long horas = duration.toHours();
        long minutos = duration.toMinutes() % 60;
        long segundos = duration.toSeconds() % 60;

        return new HorarioResponse(horas, minutos, segundos);
    }
}
