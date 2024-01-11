package com.gabrielbarrilli.LocalDataTime.repository;

import com.gabrielbarrilli.LocalDataTime.model.Quarto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuartoRepository extends JpaRepository<Quarto, Long> {

    Quarto findByNumero(Integer numero);
}
