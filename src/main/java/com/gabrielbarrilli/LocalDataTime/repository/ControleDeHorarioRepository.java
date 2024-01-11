package com.gabrielbarrilli.LocalDataTime.repository;

import com.gabrielbarrilli.LocalDataTime.model.ControleDeHorario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ControleDeHorarioRepository extends JpaRepository<ControleDeHorario, Long> {
    List<ControleDeHorario>findByDataHoraAtual(LocalDateTime dataHoraAtual);
}
