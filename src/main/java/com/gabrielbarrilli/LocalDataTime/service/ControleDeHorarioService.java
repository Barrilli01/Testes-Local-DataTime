package com.gabrielbarrilli.LocalDataTime.service;

import com.gabrielbarrilli.LocalDataTime.model.ControleDeHorario;
import com.gabrielbarrilli.LocalDataTime.repository.ControleDeHorarioRepository;
import com.gabrielbarrilli.LocalDataTime.repository.QuartoRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.cglib.core.Local;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
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

    public ControleDeHorario findById(Long id) {
        return controleDeHorarioRepository.findById(id).orElseThrow(()-> new EntityNotFoundException("controle nao encontrado"));
    }

    public ControleDeHorario create(ControleDeHorario controleDeHorario, Long idQuarto) {
        var quarto = quartoRepository.findById(idQuarto).orElseThrow(()-> new EntityNotFoundException("Quarto inexistente, não foi possível criar horário"));
        controleDeHorario.setQuarto(quarto);

        LocalDate dataAtual = LocalDate.now();
        controleDeHorario.setDataEntrada(dataAtual);

        LocalTime agora = LocalTime.now();
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = agora.format(horaFormatter);
        LocalTime horaLocal = LocalTime.parse(horaFormatada, horaFormatter);
        controleDeHorario.setHoraEntrada(horaLocal);

        return controleDeHorarioRepository.save(controleDeHorario);
    }

    public ControleDeHorario editarSaida(Long idControle) {
        var controle = controleDeHorarioRepository.findById(idControle).orElseThrow(()-> new EntityNotFoundException("Controle de horário inexistente"));

        LocalTime agora = LocalTime.now();
        DateTimeFormatter horaFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horaFormatada = agora.format(horaFormatter);
        LocalTime horaLocal = LocalTime.parse(horaFormatada, horaFormatter);
        controle.setHoraSaida(horaLocal);

        controle.setDataSaida(LocalDate.now());

        calculoPermanencia(idControle);

        return controleDeHorarioRepository.save(controle);
    }

    public void calculoPermanencia(Long idControle){

        var controle = controleDeHorarioRepository.findById(idControle).orElseThrow(()-> new EntityNotFoundException("não achou id para calcular"));

        if(controle.getDataEntrada()  != null && controle.getHoraEntrada() != null) {
            Duration duracao = Duration.between(controle.getDataEntrada().atTime(controle.getHoraEntrada()), controle.getDataSaida().atTime(controle.getHoraSaida()));
            long horas = duracao.toHours();
            long minutos = duracao.toMinutes() % 60;
            long segundos = duracao.toSeconds() % 60;
            String permanencia = ("permaneceu " + horas + " horas " + minutos + " minutos e " + segundos + " segundos");
            controle.setTempoPermanencia(permanencia);
        } else {
            System.out.println("Horário de saída já definido!");
        }
    }
}
