package com.gabrielbarrilli.LocalDataTime.repository;

import com.gabrielbarrilli.LocalDataTime.model.EntradaSaida;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface EntradaSaidaRepository extends JpaRepository<EntradaSaida, Long> {

    List<EntradaSaida>findByDataSaida(LocalDate dataSaida);
}
